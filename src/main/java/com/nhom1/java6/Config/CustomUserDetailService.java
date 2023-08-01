package com.nhom1.java6.Config;

import com.nhom1.java6.Model.Account;
import com.nhom1.java6.Repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    AccountDAO accountDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> result = accountDAO.findById(username);
        Account account = result.orElse(null);
        if(account == null){
            return null;
        }
        List<GrantedAuthority> roleName = account.getAuthorities().stream()
                                    .map(authority -> new SimpleGrantedAuthority(authority.getRole().getId()))
                                    .collect(Collectors.toList());
        return User.builder()
                .username(username)
                .password(account.getPassword())
                .authorities(roleName)
                .build();
    }
}
