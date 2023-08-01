package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role,String> {
}
