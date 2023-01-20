package com.desidukaan.service;

import com.desidukaan.exception.OrderException;
import com.desidukaan.model.Order;
import com.desidukaan.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order addOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }

    @Override
    public Order updateOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) return orderDao.save(order);
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public Order removeOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) {

            Order order1 = byId.get();
            orderDao.delete(order1);
            return order1;

        }
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public Order viewOrder(Order order)throws OrderException {
        Optional<Order> byId = orderDao.findById(order.getOrderId());

        if (byId.isPresent()) return orderDao.save(order);
        else throw new OrderException("No Order Found with this Id"+order.getOrderId());
    }

    @Override
    public List<Order> viewAllOrders(LocalDate date) {
        return null;
    }

    @Override
    public List<Order> viewAllOrdersByLocation(String loc) {
        return null;
    }

    @Override
    public List<Order> viewAllOrdersByUserId(String userid) {

        return null;
    }
}
