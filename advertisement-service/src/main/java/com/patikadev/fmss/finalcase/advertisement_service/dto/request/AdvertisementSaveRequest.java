package com.patikadev.fmss.finalcase.advertisement_service.dto.request;

import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementSaveRequest {

    private String header;
    private String description;
    private BigDecimal amount;
    private Long userId;
    private Set<String> images;

}
