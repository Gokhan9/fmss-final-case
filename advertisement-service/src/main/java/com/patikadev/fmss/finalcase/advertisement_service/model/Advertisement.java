package com.patikadev.fmss.finalcase.advertisement_service.model;

import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header;
    private String description;
    private BigDecimal amount;
    private AdvertisementStatus advertisementStatus;
    private Long userId;
    private Set<String> images;

}
