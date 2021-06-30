package com.example.demospringbootecommerce.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Min(1)
    private BigDecimal price;

    @NotNull
    @Min(1)
    private Integer quantity;
}
