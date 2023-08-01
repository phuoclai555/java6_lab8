package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Category;
import com.nhom1.java6.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category,String> {

}
