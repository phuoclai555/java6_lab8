package com.nhom1.java6.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.nhom1.java6.Model.Order;
import com.nhom1.java6.Repository.OrderDetailDAO;
import com.nhom1.java6.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public Order create(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
    }
}
