package com.nhom1.java6.Service.Impl;

import com.nhom1.java6.Model.Account;
import com.nhom1.java6.Repository.AccountDAO;
import com.nhom1.java6.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceimpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;
    @Override
    public Account findById(String username) {
        return accountDAO.findById(username).get();
    }

    @Override
    public List<Account> getAdministrators() {
        return accountDAO.getAdministrators();
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }
}
