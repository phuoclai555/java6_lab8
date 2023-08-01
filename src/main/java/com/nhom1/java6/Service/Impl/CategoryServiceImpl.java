package com.nhom1.java6.Service.Impl;

import com.nhom1.java6.Model.Category;
import com.nhom1.java6.Model.Product;
import com.nhom1.java6.Repository.CategoryDAO;
import com.nhom1.java6.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

}
