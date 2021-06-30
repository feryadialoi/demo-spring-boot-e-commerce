package com.example.demospringbootecommerce.controller;

import com.example.demospringbootecommerce.model.CreateProductRequest;
import com.example.demospringbootecommerce.model.ProductResponse;
import com.example.demospringbootecommerce.model.UpdateProductRequest;
import com.example.demospringbootecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getProducts(Pageable pageable) {
        return new ResponseEntity<>(productService.getProducts(pageable), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productId") Long productId) {
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("productId") Long productId,
                                                         @Valid @RequestBody UpdateProductRequest updateProductRequest) {
        return new ResponseEntity<>(
                productService.updateProduct(productId, updateProductRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
