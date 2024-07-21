package com.patikadev.fmss.finalcase.payment_service.controller;

import com.patikadev.fmss.finalcase.payment_service.dto.request.PaymentSaveRequest;
import com.patikadev.fmss.finalcase.payment_service.dto.response.PaymentResponse;
import com.patikadev.fmss.finalcase.payment_service.model.Payment;
import com.patikadev.fmss.finalcase.payment_service.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping
    public Boolean save(@RequestBody PaymentSaveRequest paymentSaveRequest){
        return paymentService.save(paymentSaveRequest);
    }

    @GetMapping
    public List<Payment> getAllPayment(){
        return paymentService.getPaymentList();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id){
        return paymentService.getById(id);
    }

    @GetMapping("/{status}")
    public PaymentResponse getByStatus(@PathVariable String status){
        return paymentService.getByStatus(status);
    }

}
