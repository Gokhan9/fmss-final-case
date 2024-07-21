package com.patikadev.fmss.finalcase.product_service.dto.response;


import com.patikadev.fmss.finalcase.product_service.constants.EstateConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {

    private String message;
    private String status;
    private HttpStatus httpStatus;
    private T data;

    public static GenericResponse<ExceptionResponse> passive(String message){
        return GenericResponse.<ExceptionResponse>builder()
                .status(EstateConstants.PASSIVE)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(message)
                .build();

    }

    public static <T> GenericResponse<T> active(T data){
        return GenericResponse.<T>builder()
                .status(EstateConstants.ACTIVE)
                .httpStatus(HttpStatus.OK)
                .data(data)
                .build();
    }
}
