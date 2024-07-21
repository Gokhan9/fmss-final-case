package com.patikadev.fmss.finalcase.product_service.service;

import com.patikadev.fmss.finalcase.product_service.converter.ProductConverter;
import com.patikadev.fmss.finalcase.product_service.dto.request.ProductSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.ProductResponse;
import com.patikadev.fmss.finalcase.product_service.dto.response.UserProductInfoResponse;
import com.patikadev.fmss.finalcase.product_service.exception.ProductException;
import com.patikadev.fmss.finalcase.product_service.model.Product;
import com.patikadev.fmss.finalcase.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;
    private UserProductInfoService userProductInfoService;

    public ProductService(ProductRepository productRepository, UserProductInfoService userProductInfoService) {
        this.productRepository = productRepository;
        this.userProductInfoService = userProductInfoService;
    }

    public void save(ProductSaveRequest productSaveRequest) {
        Optional<Product> foundProduct = productRepository.findByName(productSaveRequest.getName());

        if (foundProduct.isPresent()) {
            log.error("Same product name exists !");
            throw new ProductException("Same product name exists !");
        }

        Product product = ProductConverter.toProduct(productSaveRequest);
        product.setExpirationDate(LocalDateTime.now().plusMonths(1));
        productRepository.save(product);
        log.info("Product Created. {}", product.getName());

    }

    public ProductResponse getByName(String name) {
        Optional<Product> product = productRepository.findByName(name);

        if (product.isEmpty()) {
            log.error("I couldn't find a package with this name.");
            throw new ProductException("Product not found.");
        }
        return ProductConverter.toProductResponse(product.get());
    }

    public List<ProductResponse> getProductList() {
        log.info("Product listed.");
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductConverter::toProductResponse).toList();
    }

    public List<ProductResponse> getAllByUserId(Long userId) {
        List<Long> userProductIds = userProductInfoService.getListByUserId(userId).stream().map(UserProductInfoResponse::getProductId).collect(Collectors.toList());

        if (userProductIds.isEmpty()) {
            return new ArrayList<>();
        }

        List<Product> userAssignedProducts = productRepository.findAllByIdIn(userProductIds);
        return userAssignedProducts.stream().map(ProductConverter::toProductResponse).toList();
    }
}






