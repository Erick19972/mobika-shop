package com.mobica.catalog.service;

import com.mobica.catalog.entity.Product;
import com.mobica.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mobica.catalog.repository.ProductSpecification;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void saveAll(List<Product> products) {
        repository.saveAll(products);
    }

    public long count() {
        return repository.count();
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> findByMaterial(String material) {
        return repository.findByMaterial(material);
    }

    public List<Product> findByColor(String color) {
        return repository.findByColor(color);
    }

    public List<Product> findBySize(String size) {
        return repository.findBySize(size);
    }

    public List<Product> searchProducts(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    public List<Product> filterProducts(
            String category,
            String color,
            String material,
            String size) {

        return repository.findAll(
                ProductSpecification.filter(
                        category,
                        color,
                        material,
                        size));
    }
}