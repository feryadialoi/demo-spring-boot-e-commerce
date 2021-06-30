package com.example.demospringbootecommerce.modelmapper;

import com.example.demospringbootecommerce.entity.Product;
import com.example.demospringbootecommerce.model.ProductResponse;

public interface ProductMapper {

    ProductResponse mapProductToProductResponse(Product product);

}
