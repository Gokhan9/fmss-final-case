package com.patikadev.fmss.finalcase.payment_service.converter;

import com.patikadev.fmss.finalcase.payment_service.dto.request.PaymentSaveRequest;
import com.patikadev.fmss.finalcase.payment_service.dto.response.PaymentResponse;
import com.patikadev.fmss.finalcase.payment_service.model.Payment;
import com.patikadev.fmss.finalcase.payment_service.model.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentConverter {

    public static Payment toPayment(PaymentSaveRequest paymentSaveRequest) {

        Payment payment = new Payment();

        payment.setStatus(paymentSaveRequest.getStatus());
        payment.setUserId(paymentSaveRequest.getUserId());
        payment.setProductId(paymentSaveRequest.getProductId());
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        return payment;
    }

    public static PaymentResponse toPaymentResponse(Payment payment) {

        PaymentResponse paymentResponse = new PaymentResponse();

        paymentResponse.setId(payment.getId());
        paymentResponse.setStatus(payment.getStatus());
        paymentResponse.setUserId(payment.getUserId());
        paymentResponse.setProductId(payment.getProductId());
        return paymentResponse;
    }

}
