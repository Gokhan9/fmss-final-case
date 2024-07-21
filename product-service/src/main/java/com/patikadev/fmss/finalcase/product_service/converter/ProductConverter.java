package com.patikadev.fmss.finalcase.product_service.converter;

import com.patikadev.fmss.finalcase.product_service.dto.request.ProductSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.ProductResponse;
import com.patikadev.fmss.finalcase.product_service.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConverter {

    public static Product toProduct(ProductSaveRequest productSaveRequest){

        Product product = new Product();

        product.setName(productSaveRequest.getName());
        product.setDescription(productSaveRequest.getDescription());
        product.setAmount(productSaveRequest.getAmount());
        product.setExpirationDate(productSaveRequest.getExpirationDate());

        return product;
    }

    public static ProductResponse toProductResponse(Product product){

        ProductResponse productResponse = new ProductResponse();

        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setAmount(product.getAmount());
        productResponse.setExpirationDate(product.getExpirationDate());

        return productResponse;
    }
}
