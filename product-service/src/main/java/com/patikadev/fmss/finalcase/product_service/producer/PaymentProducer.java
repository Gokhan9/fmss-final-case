package com.patikadev.fmss.finalcase.product_service.producer;

import com.patikadev.fmss.finalcase.product_service.config.RabbitConfig;
import com.patikadev.fmss.finalcase.product_service.producer.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class PaymentProducer {

    private final AmqpTemplate rabbitTemplate;
    private final RabbitConfig rabbitConfig;

    public void sendPayment(PaymentDto paymentDto) {
        rabbitTemplate.convertAndSend(rabbitConfig.getExchange(), rabbitConfig.getRoutingKey(), paymentDto);
        log.info("payment sent. exchange:{}", rabbitConfig.getExchange());
    }

}
