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

        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();


            existingProduct.setName(updatedProduct.getName());
            existingProduct.setSkuCode(updatedProduct.getSkuCode());
            existingProduct.setUnitPrice(updatedProduct.getUnitPrice());

            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }




}
