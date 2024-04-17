package com.example.products.service;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;
import com.example.products.repository.ProductRepository;
import com.example.products.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductDto addProductToList(ProductDto product) {
        ProductModel productModel = ProductMapper.toProductModel(product);
        ProductModel model = productRepository.save(productModel);
        return ProductMapper.toProductDto(model);
    }

    public ProductModel findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
    productRepository.deleteById(id);
    }


    public void editById(ProductModel model,Long id) {
        model.setId(id);
        productRepository.save(model);
    }
}