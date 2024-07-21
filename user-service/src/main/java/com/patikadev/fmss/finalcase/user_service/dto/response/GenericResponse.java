package com.patikadev.fmss.finalcase.user_service.dto.response;


import com.patikadev.fmss.finalcase.user_service.constants.EstateConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {

    private String status;
    private HttpStatus httpStatus;
    private T data;
    private T error;

    public static GenericResponse<ExceptionResponse> failed(String message){
        return GenericResponse.<ExceptionResponse>builder()
                .status(EstateConstants.FAILED)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .error(new ExceptionResponse(message))
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
