package com.mobica.catalog.repository;

import com.mobica.catalog.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> filter(
            String category,
            String color,
            String material,
            String size) {

        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (category != null && !category.isBlank()) {
                predicate = cb.and(
                        predicate,
                        cb.equal(root.get("category"), category)
                );
            }

            if (color != null && !color.isBlank()) {
                predicate = cb.and(
                        predicate,
                        cb.equal(root.get("color"), color)
                );
            }

            if (material != null && !material.isBlank()) {
                predicate = cb.and(
                        predicate,
                        cb.equal(root.get("material"), material)
                );
            }

            if (size != null && !size.isBlank()) {
                predicate = cb.and(
                        predicate,
                        cb.equal(root.get("size"), size)
                );
            }

            return predicate;
        };
    }
}