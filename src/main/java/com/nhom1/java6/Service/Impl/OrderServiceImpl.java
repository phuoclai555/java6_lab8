package com.nhom1.java6.Service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhom1.java6.Model.Order;
import com.nhom1.java6.Model.OrderDetail;
import com.nhom1.java6.Repository.OrderDAO;
import com.nhom1.java6.Repository.OrderDetailDAO;
import com.nhom1.java6.Service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData,Order.class);
        orderDAO.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<>(){};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d-> d.setOrder(order)).collect(Collectors.toList());
        orderDetailDAO.saveAll(details);
        details.forEach(x -> System.out.println(x.toString()));
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderDAO.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {

        return orderDAO.findByUsername(username);
    }
}
