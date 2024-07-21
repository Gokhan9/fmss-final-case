package com.patikadev.fmss.finalcase.product_service.exception;

import com.patikadev.fmss.finalcase.product_service.dto.response.ExceptionResponse;
import com.patikadev.fmss.finalcase.product_service.dto.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public GenericResponse<ExceptionResponse> handleException(ProductException exception){
        log.error(exception.getLocalizedMessage());
        return GenericResponse.passive(exception.getMessage());
    }

    //exceptionların tümü bu metoda düşecektir.
    @ExceptionHandler(Exception.class)
    public String otherAllException(Exception exception) {
        return "Exception Mesajı: " + exception.getMessage();
    }
}
