package com.example.demospringbootecommerce.serviceimpl;

import com.example.demospringbootecommerce.entity.Product;
import com.example.demospringbootecommerce.exception.ProductNotFoundException;
import com.example.demospringbootecommerce.model.CreateProductRequest;
import com.example.demospringbootecommerce.model.ProductResponse;
import com.example.demospringbootecommerce.model.UpdateProductRequest;
import com.example.demospringbootecommerce.modelmapper.ProductMapper;
import com.example.demospringbootecommerce.repository.ProductRepository;
import com.example.demospringbootecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> getProducts(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .get()
                .map(product -> productMapper.mapProductToProductResponse(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return productMapper.mapProductToProductResponse(product);
        } else {
            throw new ProductNotFoundException("product with id " + productId + " not found");
        }
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product = productRepository.save(product);

        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long productId, UpdateProductRequest updateProductRequest) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (Objects.nonNull(updateProductRequest.getName())) {
                product.setName(updateProductRequest.getName());
            }

            if (Objects.nonNull(updateProductRequest.getPrice())) {
                product.setPrice(updateProductRequest.getPrice());
            }

            if (Objects.nonNull(updateProductRequest.getQuantity())) {
                product.setQuantity(updateProductRequest.getQuantity());
            }

            productRepository.save(product);

            return productMapper.mapProductToProductResponse(product);

        } else {
            throw new ProductNotFoundException("product with id " + productId + " not found");
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
