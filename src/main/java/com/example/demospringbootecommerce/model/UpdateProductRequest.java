package com.example.demospringbootecommerce.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
