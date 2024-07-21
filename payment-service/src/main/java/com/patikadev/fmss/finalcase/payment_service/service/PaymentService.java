package com.patikadev.fmss.finalcase.payment_service.service;

import com.patikadev.fmss.finalcase.payment_service.client.UserService;
import com.patikadev.fmss.finalcase.payment_service.client.dto.UserResponse;
import com.patikadev.fmss.finalcase.payment_service.converter.PaymentConverter;
import com.patikadev.fmss.finalcase.payment_service.dto.request.PaymentSaveRequest;
import com.patikadev.fmss.finalcase.payment_service.dto.response.GenericResponse;
import com.patikadev.fmss.finalcase.payment_service.dto.response.PaymentResponse;
import com.patikadev.fmss.finalcase.payment_service.exception.EstateException;
import com.patikadev.fmss.finalcase.payment_service.model.Payment;
import com.patikadev.fmss.finalcase.payment_service.repository.PaymentRepository;
import com.patikadev.fmss.finalcase.user_service.exception.ExceptionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class PaymentService {

    private final UserService userService;
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository, UserService userService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
    }

    public Boolean save(PaymentSaveRequest paymentSaveRequest) {

        GenericResponse<UserResponse> userResponse = userService.getById(paymentSaveRequest.getUserId());

        if (Objects.isNull(userResponse.getData())) {
            log.error("User not found");
            return false;

        } else {
            Payment payment = PaymentConverter.toPayment(paymentSaveRequest);

            paymentRepository.save(payment);
            return true;
        }
    }

    public Payment getById(Long id) {

        Optional<Payment> foundPayment = paymentRepository.findById(id);

        if (foundPayment.isEmpty()) {
            log.error(ExceptionMessage.PAYMENT_UNSUCCESSFUL);
            throw new EstateException(ExceptionMessage.PAYMENT_UNSUCCESSFUL);
        }
        return foundPayment.get();
    }

    public PaymentResponse getByStatus(String status) {

        Optional<Payment> payment = paymentRepository.findByStatus(status);

        if (!payment.isPresent()) {
            log.error(ExceptionMessage.SUCCESSFUL);
        }
        return PaymentConverter.toPaymentResponse(payment.get());
    }

    public List<Payment> getPaymentList() {
        return paymentRepository.findAll();
    }

}
