package com.example.products.controller;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;
import com.example.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final List<ProductModel> products;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProductsList() {
        try {
            List<ProductModel> allProducts = productService.getAllProducts();
            return ResponseEntity.ok(allProducts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Long id) {
        try {
            ProductModel productModel = productService.findProductById(id);
            return ResponseEntity.ok(productModel);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> postAddProduct(@RequestBody ProductDto product) {
        try {
            ProductDto newProduct = productService.addProductToList(product);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductModel> deleteById(@PathVariable("id") Long id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductModel> editProductById(@PathVariable("id") Long id
            , @RequestBody ProductModel model) {
        try {
            productService.editById(model, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<ProductDto> changePrice(@PathVariable("id") Long id,
                                                  @RequestBody ProductDto productDto) {
        try {
            ProductDto newPrice = productService.updatePrice(id, productDto);
            return ResponseEntity.ok(newPrice);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
