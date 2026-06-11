package com.mobica.catalog.controller;

import com.mobica.catalog.entity.CartItem;
import com.mobica.catalog.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @PostMapping("/add")
    public CartItem addToCart(
            @RequestBody CartItem item) {

        return service.add(item);
    }

    @GetMapping
    public List<CartItem> getCart() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(
            @PathVariable Long id) {

        service.delete(id);
    }
}