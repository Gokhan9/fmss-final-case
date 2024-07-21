package com.patikadev.fmss.finalcase.product_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {

    private String name;
    private String description;
    private BigDecimal amount;
    private LocalDateTime expirationDate;
}
