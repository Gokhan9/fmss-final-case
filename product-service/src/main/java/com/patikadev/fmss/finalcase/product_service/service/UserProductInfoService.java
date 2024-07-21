package com.patikadev.fmss.finalcase.product_service.service;


import com.patikadev.fmss.finalcase.product_service.converter.UserProductInfoConverter;
import com.patikadev.fmss.finalcase.product_service.dto.request.UserProductInfoSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.UserProductInfoResponse;
import com.patikadev.fmss.finalcase.product_service.exception.ProductException;
import com.patikadev.fmss.finalcase.product_service.model.Product;
import com.patikadev.fmss.finalcase.product_service.model.UserProductInfo;
import com.patikadev.fmss.finalcase.product_service.producer.PaymentProducer;
import com.patikadev.fmss.finalcase.product_service.producer.dto.PaymentDto;
import com.patikadev.fmss.finalcase.product_service.repository.ProductRepository;
import com.patikadev.fmss.finalcase.product_service.repository.UserProductInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserProductInfoService {

    private UserProductInfoRepository userProductInfoRepository;
    private ProductRepository productRepository;
    private PaymentProducer paymentProducer;

    public UserProductInfoService(UserProductInfoRepository userProductInfoRepository, ProductRepository productRepository, PaymentProducer paymentProducer) {
        this.userProductInfoRepository = userProductInfoRepository;
        this.productRepository = productRepository;
        this.paymentProducer = paymentProducer;
    }

    public void saveList(List<UserProductInfoSaveRequest> requests) {
        if (requests.size() != 10) {
            log.error("You can create product.");
            throw new ProductException("Cannot Create Product More Than 10 Products");
        }
        requests.forEach(saveRequest -> save(saveRequest));
    }

    public void save(UserProductInfoSaveRequest saveRequest) {

        Optional<UserProductInfo> info = userProductInfoRepository.findByProductIdAndUserId(saveRequest.getProductId(), saveRequest.getUserId());

        if (info.isEmpty()) {
            Optional<Product> product = productRepository.findById(saveRequest.getProductId());

            if (product.isEmpty()) {
                log.error("Product not found.");
                throw new ProductException("Product not found.");
            }

            // SENKRON
            UserProductInfo userProductInfo = UserProductInfoConverter.toUserProductInfo(saveRequest, product.get());
            userProductInfoRepository.save(userProductInfo);

            //ASENKRON
            paymentProducer.sendPayment(preparePaymentDto(userProductInfo.getUserId(), userProductInfo.getProduct().getId()));
        } else {
            log.error("This product is available for the user");
            throw new ProductException("This product is available for the user");
        }
    }

    public List<UserProductInfoResponse> getListByUserId(Long userId) {
        List<UserProductInfo> info = userProductInfoRepository.findAllByUserId(userId);

        if (info.isEmpty()) {
            throw new ProductException("User Not Found");
        }
        return info.stream().map(UserProductInfoConverter::toUserProductInfoResponse).collect(Collectors.toList());
    }

    private PaymentDto preparePaymentDto(Long userId, Long productId) {
        return PaymentDto.builder()
                .userId(userId)
                .productId(productId)
                .status("NEW")
                .build();
    }
}
