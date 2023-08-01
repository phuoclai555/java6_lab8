package com.nhom1.java6.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nhom1.java6.Model.Order;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Order findById(Long id);

    List<Order> findByUsername(String username);
}
