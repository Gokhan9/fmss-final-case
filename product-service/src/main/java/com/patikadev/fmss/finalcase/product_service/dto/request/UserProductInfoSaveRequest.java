package com.patikadev.fmss.finalcase.product_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProductInfoSaveRequest {

    private Long productId;
    private Long userId;
}
