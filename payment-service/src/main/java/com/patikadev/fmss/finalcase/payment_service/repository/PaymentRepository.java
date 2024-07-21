package com.patikadev.fmss.finalcase.payment_service.repository;

import com.patikadev.fmss.finalcase.payment_service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByStatus(String status);

}
