package com.patikadev.fmss.finalcase.advertisement_service.dto.response;

import com.patikadev.fmss.finalcase.advertisement_service.constants.EstateConstants;
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
    private T error;

    public static GenericResponse<ExpectionResponse> failed(String message){
        return GenericResponse.<ExpectionResponse>builder()
                .status(EstateConstants.FAILED)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .error(new ExpectionResponse(message))
                .build();
    }

    public static <T> GenericResponse<T> success(T data){
        return GenericResponse.<T>builder()
                .status(EstateConstants.SUCCESS)
                .httpStatus(HttpStatus.OK)
                .data(data)
                .build();
    }
}
