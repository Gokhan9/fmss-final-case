package com.patikadev.fmss.finalcase.product_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProductInfoResponse {
    private Long id;
    private Long productId;
    private Long userId;
    private LocalDateTime creationTime;
}
