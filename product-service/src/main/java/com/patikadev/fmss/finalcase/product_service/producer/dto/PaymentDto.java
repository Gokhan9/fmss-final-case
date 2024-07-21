package com.patikadev.fmss.finalcase.product_service.producer.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private String status;
    private Long userId;
    private Long productId;
}
