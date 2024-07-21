package com.patikadev.fmss.finalcase.user_service.service;

import com.patikadev.fmss.finalcase.user_service.converter.UserConverter;
import com.patikadev.fmss.finalcase.user_service.dto.request.UserSaveRequest;
import com.patikadev.fmss.finalcase.user_service.dto.response.UserResponse;
import com.patikadev.fmss.finalcase.user_service.exception.EstateException;
import com.patikadev.fmss.finalcase.user_service.exception.ExceptionMessage;
import com.patikadev.fmss.finalcase.user_service.model.User;
import com.patikadev.fmss.finalcase.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void save(UserSaveRequest userSaveRequest){

        Optional<User> foundUser = userRepository.findByEmail(userSaveRequest.getEmail());

        if (foundUser.isEmpty()){
            log.error("User not found.");
        }
        User user = UserConverter.toUser(userSaveRequest);
        userRepository.save(user);

        log.info("User created. {}", user.getEmail());
    }

    public UserResponse getByEmail(String email){

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()){
           log.error(ExceptionMessage.USER_NOT_FOUND);
           throw new EstateException(ExceptionMessage.USER_NOT_FOUND);
       }
       return UserConverter.toUserResponse(user.get());
    }

    public User getById(Long id){

        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()){
            log.error(ExceptionMessage.USER_NOT_FOUND);
            throw new EstateException(ExceptionMessage.USER_NOT_FOUND);
        }
        return foundUser.get();
    }

    public List<User> getUserList(){
        log.info("User listed.");
        return userRepository.findAll();
    }
}
