package com.patikadev.fmss.finalcase.payment_service.consumer;

import com.patikadev.fmss.finalcase.payment_service.consumer.dto.PaymentDto;
import com.patikadev.fmss.finalcase.payment_service.dto.request.PaymentSaveRequest;
import com.patikadev.fmss.finalcase.payment_service.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentConsumer {

    @Autowired
    PaymentService paymentService;

    @RabbitListener(queues = "${payment.queue}")
    public void sendPayment(PaymentDto paymentSaveRequest) {

        log.info("payment :{}", paymentSaveRequest);
        paymentService.save(new PaymentSaveRequest(paymentSaveRequest.getStatus(), paymentSaveRequest.getUserId(), paymentSaveRequest.getProductId()));
    }
}
