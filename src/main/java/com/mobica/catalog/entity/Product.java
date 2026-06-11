package com.mobica.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal price;

    @Column(length = 3000)
    private String description;

    @Column(length = 1000)
    private String image;

    @Column(length = 1000)
    private String banner;

    private String category;

    private String color;

    private String material;

    private String size;

    private Integer stock;

    private Boolean active;
}