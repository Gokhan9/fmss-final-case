package com.patikadev.fmss.finalcase.advertisement_service.dto.response;

import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementResponse {

    private Long id;

    private String header;
    private String description;
    private BigDecimal amount;
    private AdvertisementStatus advertisementStatus;
    private Long userId;
    private Set<String> images;

}
