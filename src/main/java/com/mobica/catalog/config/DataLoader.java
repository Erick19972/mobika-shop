package com.mobica.catalog.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobica.catalog.entity.Product;
import com.mobica.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() > 0) {
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream =
                new ClassPathResource("products.json").getInputStream();

        List<Product> products =
                objectMapper.readValue(
                        inputStream,
                        new TypeReference<List<Product>>() {}
                );

        productRepository.saveAll(products);

        System.out.println("Productos cargados: " + products.size());
    }
}