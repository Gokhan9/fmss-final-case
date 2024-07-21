package com.patikadev.fmss.finalcase.product_service.repository;

import com.patikadev.fmss.finalcase.product_service.model.UserProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProductInfoRepository extends JpaRepository<UserProductInfo, Long> {
    List<UserProductInfo> findAllByUserId(Long userId);

    Optional<UserProductInfo> findByProductIdAndUserId(Long productId, Long userId);
}


