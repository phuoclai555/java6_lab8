package com.nhom1.java6.Service.Impl;

import com.nhom1.java6.Model.Account;
import com.nhom1.java6.Model.Authority;
import com.nhom1.java6.Repository.AccountDAO;
import com.nhom1.java6.Repository.AuthorityDAO;
import com.nhom1.java6.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthServiceImpl implements AuthorityService {
    @Autowired
    AuthorityDAO authorityDAO;

    @Autowired
    AccountDAO accountDAO;
    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountDAO.getAdministrators();
        return authorityDAO.authoritesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        authorityDAO.deleteById(id);
    }



    @Override
    public Authority create(Authority auth) {
        return authorityDAO.save(auth);
    }
}
