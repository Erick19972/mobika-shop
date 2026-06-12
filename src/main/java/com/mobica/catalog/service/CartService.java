package com.mobica.catalog.service;

import com.mobica.catalog.entity.CartItem;
import com.mobica.catalog.kafka.CartProducer;
import com.mobica.catalog.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;
    private final CartProducer producer;

    public CartItem add(CartItem item) {

        CartItem savedItem = repository.save(item);

        producer.sendCartEvent(
                "PRODUCT_ADDED_TO_CART | productId="
                        + savedItem.getProductId()
                        + " | quantity="
                        + savedItem.getQuantity()
        );

        return savedItem;
    }

    public List<CartItem> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {

        repository.deleteById(id);

        producer.sendCartEvent(
                "PRODUCT_REMOVED_FROM_CART | cartItemId="
                        + id
        );
    }
}