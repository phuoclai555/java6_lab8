package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("select distinct ar.account from Authority ar where ar.role.id IN ('DIRE','STAF')")
    List<Account> getAdministrators();
}
