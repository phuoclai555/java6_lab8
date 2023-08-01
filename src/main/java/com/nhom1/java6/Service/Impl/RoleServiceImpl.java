package com.nhom1.java6.Service.Impl;

import com.nhom1.java6.Model.Role;
import com.nhom1.java6.Repository.RoleDAO;
import com.nhom1.java6.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO roleDAO;
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }
}
