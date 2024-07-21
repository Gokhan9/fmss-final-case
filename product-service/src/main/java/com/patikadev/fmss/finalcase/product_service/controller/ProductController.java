package com.patikadev.fmss.finalcase.product_service.controller;


import com.patikadev.fmss.finalcase.product_service.dto.request.ProductSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.ProductResponse;
import com.patikadev.fmss.finalcase.product_service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(ProductSaveRequest productSaveRequest) {
        productService.save(productSaveRequest);
    }

    @GetMapping("/{name}")
    public ProductResponse getByName(@PathVariable String name) {
        return productService.getByName(name);
    }

    @GetMapping
    public List<ProductResponse> getProductList() {
        return productService.getProductList();
    }

    @GetMapping("/user-assigned-products/{userId}")
    public List<ProductResponse> getProductDetailsByUserId(@PathVariable Long userId) {
        return productService.getAllByUserId(userId);
    }
}
