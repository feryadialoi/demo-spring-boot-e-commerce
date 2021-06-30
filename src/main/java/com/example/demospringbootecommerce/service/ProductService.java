package com.example.demospringbootecommerce.service;

import com.example.demospringbootecommerce.model.CreateProductRequest;
import com.example.demospringbootecommerce.model.ProductResponse;
import com.example.demospringbootecommerce.model.UpdateProductRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getProducts(Pageable pageable);

    ProductResponse getProduct(Long productId);

    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse updateProduct(Long productId, UpdateProductRequest updateProductRequest);

    void deleteProduct(Long productId);

}
