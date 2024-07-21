package com.patikadev.fmss.finalcase.payment_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSaveRequest {

    private String status;
    private Long userId;
    private Long productId;
}
