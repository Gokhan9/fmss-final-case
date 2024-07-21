package com.patikadev.fmss.finalcase.payment_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private Long id;
    private Long userId;
    private Long productId;
    private String status;

}
