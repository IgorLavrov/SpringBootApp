package com.taskspring.spring.service;

import com.taskspring.spring.models.Product;
import com.taskspring.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        // You can add validation or business logic here if needed
        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true; // Deletion was successful
        } catch (Exception e) {
            return false; // Deletion failed
        }
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Update the fields of the existing product with the new values
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setSkuCode(updatedProduct.getSkuCode());
            existingProduct.setUnitPrice(updatedProduct.getUnitPrice());
            // Add more fields to update as needed

            return productRepository.save(existingProduct);
        } else {
            return null; // Product with the given ID doesn't exist
        }
    }



    // You can implement more methods for updating and handling products
}
