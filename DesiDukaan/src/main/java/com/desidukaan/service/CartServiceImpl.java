package com.desidukaan.service;

import com.desidukaan.exception.CartException;
import com.desidukaan.model.Cart;
import com.desidukaan.model.Product;
import com.desidukaan.repository.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart addProductToCart(Cart cart, Product p, int quantity) throws CartException {
        Optional<Cart> byId = cartDao.findById(cart.getCartId());
        if (byId.isPresent()) {
            Cart cart1 = byId.get();
            cart1.getProducts().put(p,quantity);
            cartDao.save(cart1);
            return cart1;
        }
        else throw new CartException("No Cart Found with this Id"+cart.getCartId());
    }

    @Override
    public Cart removeProductFromCart(Cart cart, Product p) throws CartException {
        Optional<Cart> byId = cartDao.findById(cart.getCartId());
        if (byId.isPresent()) {
            Cart cart1 = byId.get();
            cart1.getProducts().remove(p);
            cartDao.save(cart1);
            return cart1;
        }
        else throw new CartException("No Cart Found with this Id"+cart.getCartId());
    }

    @Override
    public Cart updateProductQuantity(Cart cart, Product p, int quantity) throws CartException {
        Optional<Cart> byId = cartDao.findById(cart.getCartId());
        if (byId.isPresent()) {
            Cart cart1 = byId.get();
            cart1.getProducts().replace(p,quantity);
            cartDao.save(cart1);
            return cart1;
        }
        else throw new CartException("No Cart Found with this Id"+cart.getCartId());
    }

    @Override
    public Cart removeAllProducts(Cart cart) throws CartException {
        Optional<Cart> byId = cartDao.findById(cart.getCartId());
        if (byId.isPresent()) {
            Cart cart1 = byId.get();
            cart1.getProducts().clear();
            cartDao.save(cart1);
            return cart1;
        }
        else throw new CartException("No Cart Found with this Id"+cart.getCartId());
    }

    @Override
    public Cart viewAllProducts(Cart cart) throws CartException {
        Optional<Cart> byId = cartDao.findById(cart.getCartId());
        if (byId.isPresent()) {
            Cart cart1 = byId.get();
            return cart1;
        }
        else throw new CartException("No Cart Found with this Id"+cart.getCartId());
    }
}
