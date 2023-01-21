package com.desidukaan.controller;

import com.desidukaan.model.Order;
import com.desidukaan.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/setOrder")
    public ResponseEntity<Order> addOrderHandler(@RequestBody Order order){
        Order addedOrder = orderService.addOrder(order);
        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/orders/updateOrder")
    public ResponseEntity<Order> updateOrderHandler(@RequestBody Order order){
        Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/orders/removeOrder")
    public ResponseEntity<Order> removeOrderHandler(Order order){
        Order orderRemove = orderService.removeOrder(order);
        return new ResponseEntity<>(orderRemove, HttpStatus.ACCEPTED);
    }

    @GetMapping("/orders/viewOrder")
    public ResponseEntity<Order> viewOrderHandler(Order order){
        Order viewOrder = orderService.viewOrder(order);
        return new ResponseEntity<>(viewOrder, HttpStatus.FOUND);
    }


}
