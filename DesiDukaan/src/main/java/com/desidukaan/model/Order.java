package com.desidukaan.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
//@Entity
public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private LocalDate orderDate;

    private String orderStatus;

    private Double total;

//    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

//    @ElementCollection
    private List<ProductDTO> productList;

//    @OneToOne
    private Address address;

    public Order() {
    }

    public Order(int orderId, LocalDate orderDate, String orderStatus, Double total, Customer customer, List<ProductDTO> productList, Address address) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.total = total;
        this.customer = customer;
        this.productList = productList;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", total=" + total +
                ", customer=" + customer +
                ", productList=" + productList +
                ", address=" + address +
                '}';
    }
}
