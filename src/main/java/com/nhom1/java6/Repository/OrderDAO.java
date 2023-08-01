package com.nhom1.java6.Repository;

import com.nhom1.java6.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {
   @Query("select o from Order o where o.account.username=?1")
    List<Order> findByUsername(String username);
}
