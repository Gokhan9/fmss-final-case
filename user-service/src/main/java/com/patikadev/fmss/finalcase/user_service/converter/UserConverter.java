package com.patikadev.fmss.finalcase.user_service.converter;

import com.patikadev.fmss.finalcase.user_service.dto.request.UserSaveRequest;
import com.patikadev.fmss.finalcase.user_service.dto.response.UserResponse;
import com.patikadev.fmss.finalcase.user_service.model.User;
import com.patikadev.fmss.finalcase.user_service.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static User toUser(UserSaveRequest userSaveRequest){

        User user = new User();

        user.setName(userSaveRequest.getName());
        user.setSurname(userSaveRequest.getSurname());
        user.setEmail(userSaveRequest.getEmail());
        user.setPhone(userSaveRequest.getPhone());
        user.setPassword(userSaveRequest.getPassword());
        user.setAddress(userSaveRequest.getAddress());

        return user;
    }

    public static UserResponse toUserResponse(User user){

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setPassword(user.getPassword());
        userResponse.setAddress(user.getAddress());

        return userResponse;
    }

    public static User user(UserSaveRequest userSaveRequest) {
        String hashedPassword = HashUtil.generate(userSaveRequest.getPassword());

        User customer = new User(userSaveRequest.getName(), userSaveRequest.getSurname(), userSaveRequest.getEmail(), hashedPassword);
        customer.setId(1L);
        //customer.setAccountType(AccountType.STANDARD);  CHECK
        //customer.setIsActive(Boolean.TRUE);             CHECK
        return user(userSaveRequest);
    }
}
