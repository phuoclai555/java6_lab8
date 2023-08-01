package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
    List<Product> findByCategoryId(String id);
}
