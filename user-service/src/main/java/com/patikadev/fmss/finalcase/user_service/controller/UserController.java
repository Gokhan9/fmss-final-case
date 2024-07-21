package com.patikadev.fmss.finalcase.user_service.controller;

import com.patikadev.fmss.finalcase.user_service.dto.request.UserSaveRequest;
import com.patikadev.fmss.finalcase.user_service.dto.response.GenericResponse;
import com.patikadev.fmss.finalcase.user_service.dto.response.UserResponse;
import com.patikadev.fmss.finalcase.user_service.model.User;
import com.patikadev.fmss.finalcase.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest);
    }

    @GetMapping("/email/{email}")
    public UserResponse getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }


    @GetMapping("/{id}")
    public GenericResponse<User> getById(@PathVariable Long id) {

        User user = userService.getById(id);

        return GenericResponse.success(user);
    }


    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
