package com.nhom1.java6.Service;

import com.nhom1.java6.Model.Authority;

import java.util.List;

public interface AuthorityService {
   public  List<Authority> findAuthoritiesOfAdministrators();

   public  List<Authority> findAll();

   public void delete(Integer id);

   public Authority create(Authority auth);


}
