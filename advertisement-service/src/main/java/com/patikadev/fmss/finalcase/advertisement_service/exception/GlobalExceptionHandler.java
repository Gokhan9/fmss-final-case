package com.patikadev.fmss.finalcase.advertisement_service.exception;

import com.patikadev.fmss.finalcase.advertisement_service.dto.response.ExpectionResponse;
import com.patikadev.fmss.finalcase.advertisement_service.dto.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EstateException.class)
    public GenericResponse<ExpectionResponse> handleException(EstateException exception){
        log.error(exception.getLocalizedMessage());
        return GenericResponse.failed(exception.getMessage());
    }
}
