package com.mobica.catalog.graphql;

import com.mobica.catalog.entity.CartItem;
import com.mobica.catalog.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartGraphQLController {

    private final CartService service;

    @QueryMapping
    public List<CartItem> cart() {
        return service.findAll();
    }

    @MutationMapping
    public CartItem addToCart(
            @Argument Long productId,
            @Argument Integer quantity) {

        CartItem item = CartItem.builder()
                .productId(productId)
                .quantity(quantity)
                .build();

        return service.add(item);
    }

    @MutationMapping
    public Boolean deleteCartItem(@Argument Long id) {
        service.delete(id);
        return true;
    }
}