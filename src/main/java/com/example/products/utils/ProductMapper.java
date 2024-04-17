package com.example.products.utils;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductMapper {
    public static ProductModel toProductModel(ProductDto productDto) {
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setPrice(productDto.getPrice());
        return productModel;
    }
    public static ProductDto toProductDto(ProductModel productModel) {
        ProductDto productDto = new ProductDto();
        productModel.setName(productDto.getName());
        productModel.setPrice(productDto.getPrice());
        return productDto;
    }



}
