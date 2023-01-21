package com.desidukaan.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderId;

    private LocalDate orderDate;

    private String orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ElementCollection
    private List<ProductDTO> productList;

//    @OneToOne
    private Address address;

    public Order() {
    }

    public Order(String orderId, LocalDate orderDate, String orderStatus, Customer customer, List<ProductDTO> productList, Address address) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.productList = productList;
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
                ", customer=" + customer +
                ", productList=" + productList +
                ", address=" + address +
                '}';
    }
}
