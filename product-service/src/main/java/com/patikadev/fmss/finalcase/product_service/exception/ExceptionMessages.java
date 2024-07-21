package com.patikadev.fmss.finalcase.product_service.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String PRODUCT_NOT_FOUND = "Product is not found.";
    public static final String PRODUCT_NOT_ACTIVE_ANYMORE = "Product is not active.";

}
