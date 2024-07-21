package com.patikadev.fmss.finalcase.advertisement_service.repository;

import com.patikadev.fmss.finalcase.advertisement_service.model.Advertisement;
import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByUserId(Long userId);
    List<Advertisement> findAllByAdvertisementStatus(AdvertisementStatus advertisementStatus);
}
