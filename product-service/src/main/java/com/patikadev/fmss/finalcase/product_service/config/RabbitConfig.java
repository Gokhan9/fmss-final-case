package com.patikadev.fmss.finalcase.product_service.config;
import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RabbitConfig {

    @Value(value = "${payment.queue}")
    private String paymentQueue;

    @Value(value = "${payment.exchange}")
    private String exchange;

    @Value(value = "${payment.routingkey}")
    private String routingKey;

    @Bean
    public Queue paymentQueue() {
        return new Queue(paymentQueue);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding(Queue paymentQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(paymentQueue)
                .to(exchange)
                .with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
