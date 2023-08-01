package com.nhom1.java6.Service;

import com.nhom1.java6.Model.Account;

import java.util.List;

public interface AccountService {
    Account findById(String username);

    List<Account> getAdministrators();

    List<Account> findAll();
}
