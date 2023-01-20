package com.desidukaan.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cartId;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ElementCollection
    @OneToOne
    private Map<Product,Integer> products;

    public Cart() {
    }

    public Cart(String cartId, Customer customer, Map<Product, Integer> products) {
        this.cartId = cartId;
        this.customer = customer;
        this.products = products;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}

