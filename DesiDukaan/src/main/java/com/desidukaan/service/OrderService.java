package com.desidukaan.service;

import com.desidukaan.exception.OrderException;
import com.desidukaan.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    public Order addOrder(Order order);

    public Order updateOrder(Order order) throws OrderException;

    public Order removeOrder(Order order) throws OrderException;

    public Order viewOrder(Order order) throws OrderException;

    public List<Order> viewAllOrdersByLocation(String loc);

    public List<Order> viewAllOrdersByUserId(int userid);

}
