package com.patikadev.fmss.finalcase.payment_service.consumer.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PaymentDto {

    private String status;
    private Long userId;
    private Long productId;
}
