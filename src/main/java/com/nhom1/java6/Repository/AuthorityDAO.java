package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Account;
import com.nhom1.java6.Model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
    @Query("select distinct a from Authority a where a.account in ?1")
    List<Authority> authoritesOf(List<Account> accounts);
}
