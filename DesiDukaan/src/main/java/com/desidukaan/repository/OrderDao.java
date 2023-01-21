package com.desidukaan.repository;

import com.desidukaan.exception.OrderException;
import com.desidukaan.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {


    @Query("select o from Orders o where o.orderAddress.city= ?1")
    public List<Order> getOrderByCity(String city) throws OrderException;

    @Query("select o from Orders o where o.customer.mobileNumber=?1")
    public List<Order> getOrdersByUserId(int userID);
}
