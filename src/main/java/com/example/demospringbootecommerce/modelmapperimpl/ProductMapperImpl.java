package com.example.demospringbootecommerce.modelmapperimpl;

import com.example.demospringbootecommerce.entity.Product;
import com.example.demospringbootecommerce.model.ProductResponse;
import com.example.demospringbootecommerce.modelmapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse mapProductToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setQuantity(product.getQuantity());

        return productResponse;
    }
}
