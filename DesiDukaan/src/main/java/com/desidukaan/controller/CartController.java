package com.desidukaan.controller;

import com.desidukaan.model.Cart;
import com.desidukaan.model.Product;
import com.desidukaan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/addProduct/{quantity}")
    public ResponseEntity<Cart> addProductToCartHandler(@RequestBody Cart cart,@RequestBody Product p,@RequestParam("quantity") int quantity){
        Cart addProductToCar = cartService.addProductToCart(cart, p, quantity);
        return new ResponseEntity<>(cart,HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/removeProduct")
    public ResponseEntity<Cart> removeProductFromCartHandler(@RequestBody Cart cart,@RequestBody Product product){
        Cart removeProduct = cartService.removeProductFromCart(cart, product);
        return new ResponseEntity<>(removeProduct,HttpStatus.ACCEPTED);
    }

    @PutMapping("/cart/updateProduct/{quantity}")
    public ResponseEntity<Cart> updateProductQuantityHandler(@RequestBody Cart cart,@RequestBody Product product,@RequestParam("quantity") int quantity){
        Cart updateProduct = cartService.updateProductQuantity(cart, product, quantity);
        return new ResponseEntity<>(updateProduct,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/cart/removeAllProduct")
    public ResponseEntity<Cart> removeAllProductsHandler(@RequestBody Cart cart){
        Cart removeAllProduct = cartService.removeAllProducts(cart);
        return new ResponseEntity<>(removeAllProduct,HttpStatus.ACCEPTED);
    }

    @GetMapping("/cart/viewAllProducts")
    public ResponseEntity<Cart> viewAllProductsHandler(@RequestBody Cart cart){
        Cart viewAllProducts = cartService.viewAllProducts(cart);
        return new ResponseEntity<>(viewAllProducts,HttpStatus.OK);
    }
}
