package com.patikadev.fmss.finalcase.product_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    // Buna relation eklememe sebebimiz User modelinin farklı bir mikroserviste olmasıdır. Aynı tablodan yaratmak kayıt tutarsızlığına neden olur.
    private Long userId;

    private LocalDateTime creationTime;
}
