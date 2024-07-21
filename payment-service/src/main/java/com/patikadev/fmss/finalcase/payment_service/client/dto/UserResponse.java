package com.patikadev.fmss.finalcase.payment_service.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String address;

}
