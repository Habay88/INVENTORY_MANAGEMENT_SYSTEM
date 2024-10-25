package com.sid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sid.model.Order;
import com.sid.model.OrderStats;
import com.sid.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@RequestBody() Order order, @PathVariable("id") Long id){
        return orderService.save(order);
    }

    @PostMapping("/orders")
    public Order addNew(@RequestBody() Order order){
        return orderService.save(order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/order/stats")
    public ResponseEntity<OrderStats> getOrderStats() {
        OrderStats stats = orderService.getOrderStats();
        return ResponseEntity.ok(stats);
    }
}