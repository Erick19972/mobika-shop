package com.mobica.catalog.repository;

import com.mobica.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository
        extends JpaRepository<Product, Long>,
                JpaSpecificationExecutor<Product> {

    List<Product> findByCategory(String category);

    List<Product> findByMaterial(String material);

    List<Product> findByColor(String color);

    List<Product> findBySize(String size);

    List<Product> findByTitleContainingIgnoreCase(String title);
}