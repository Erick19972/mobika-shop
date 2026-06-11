package com.mobica.catalog.controller;

import com.mobica.catalog.entity.Product;
import com.mobica.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam String q) {

        return service.searchProducts(q);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @GetMapping("/filter")
    public List<Product> filterProducts(

            @RequestParam(required = false) String category,

            @RequestParam(required = false) String color,

            @RequestParam(required = false) String material,

            @RequestParam(required = false) String size) {

        return service.filterProducts(
                category,
                color,
                material,
                size);
    }
}