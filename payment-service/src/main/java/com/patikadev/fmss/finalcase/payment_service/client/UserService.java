package com.patikadev.fmss.finalcase.payment_service.client;

import com.patikadev.fmss.finalcase.payment_service.client.dto.UserResponse;
import com.patikadev.fmss.finalcase.payment_service.dto.response.GenericResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", url = "http://localhost:8091/")
public interface UserService {

    @GetMapping("/api/v1/users/{id}")
    GenericResponse<UserResponse> getById(@PathVariable Long id);
}
