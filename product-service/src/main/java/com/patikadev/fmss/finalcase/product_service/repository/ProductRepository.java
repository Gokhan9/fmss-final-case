package com.patikadev.fmss.finalcase.product_service.repository;

import com.patikadev.fmss.finalcase.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findAllByIdIn(List<Long> idList);
}


