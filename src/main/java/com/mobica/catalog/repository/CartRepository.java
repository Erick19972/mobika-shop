package com.mobica.catalog.repository;

import com.mobica.catalog.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<CartItem, Long> {
}