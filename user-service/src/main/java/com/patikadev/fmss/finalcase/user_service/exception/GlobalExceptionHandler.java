package com.patikadev.fmss.finalcase.user_service.exception;

import com.patikadev.fmss.finalcase.user_service.constants.EstateConstants;
import com.patikadev.fmss.finalcase.user_service.dto.response.ExceptionResponse;
import com.patikadev.fmss.finalcase.user_service.dto.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EstateException.class)
    public GenericResponse<ExceptionResponse> handleException(EstateException exception){
        log.error(exception.getLocalizedMessage());
        return GenericResponse.failed(exception.getMessage());
    }



}
