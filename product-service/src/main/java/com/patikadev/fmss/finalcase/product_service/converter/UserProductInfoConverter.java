package com.patikadev.fmss.finalcase.product_service.converter;

import com.patikadev.fmss.finalcase.product_service.dto.request.UserProductInfoSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.UserProductInfoResponse;
import com.patikadev.fmss.finalcase.product_service.model.Product;
import com.patikadev.fmss.finalcase.product_service.model.UserProductInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserProductInfoConverter {

    public static UserProductInfo toUserProductInfo(UserProductInfoSaveRequest saveRequest, Product product){
        UserProductInfo userProductInfo = new UserProductInfo();
        userProductInfo.setProduct(product);
        userProductInfo.setUserId(saveRequest.getUserId());
        return userProductInfo;
    }

    public static UserProductInfoResponse toUserProductInfoResponse(UserProductInfo userProductInfo){
        UserProductInfoResponse userProductInfoResponse = new UserProductInfoResponse();
        userProductInfoResponse.setId(userProductInfo.getId());
        userProductInfoResponse.setProductId(userProductInfo.getProduct().getId());
        userProductInfoResponse.setUserId(userProductInfo.getUserId());
        userProductInfoResponse.setCreationTime(userProductInfo.getCreationTime());
        return userProductInfoResponse;
    }
}
