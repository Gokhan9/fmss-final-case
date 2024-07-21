package com.patikadev.fmss.finalcase.advertisement_service.service;

import com.patikadev.fmss.finalcase.advertisement_service.converter.AdvertisementConverter;
import com.patikadev.fmss.finalcase.advertisement_service.dto.request.AdvertisementSaveRequest;
import com.patikadev.fmss.finalcase.advertisement_service.dto.response.AdvertisementResponse;
import com.patikadev.fmss.finalcase.advertisement_service.model.Advertisement;
import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import com.patikadev.fmss.finalcase.advertisement_service.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public void save(AdvertisementSaveRequest advertisementSaveRequest){

        List<Advertisement> advertisementList = advertisementRepository.findAllByUserId(advertisementSaveRequest.getUserId());

        if (advertisementList.size() > 10){
            log.error("İlan yayınlamak için yeni bir paket alın.");
        }

        Advertisement advertisement = AdvertisementConverter.toAdvertisement(advertisementSaveRequest);
        advertisement.setAdvertisementStatus(AdvertisementStatus.IN_REVIEW);
        advertisementRepository.save(advertisement);
    }

    public List<AdvertisementResponse> getAllByActiveStatus(){
        List<Advertisement> advertisementList = advertisementRepository.findAllByAdvertisementStatus(AdvertisementStatus.ACTIVE);
        return advertisementList.stream().map(advertisement -> AdvertisementConverter.toAdvertisementResponse(advertisement)).collect(Collectors.toList());
    }

    public List<AdvertisementResponse> getAllByPassiveStatus(){
        List<Advertisement> advertisementList = advertisementRepository.findAllByAdvertisementStatus(AdvertisementStatus.PASSIVE);
        return advertisementList.stream().map(advertisement -> AdvertisementConverter.toAdvertisementResponse(advertisement)).collect(Collectors.toList());
    }

    public void updateStatus(Long id, AdvertisementStatus newStatus){
        Optional<Advertisement> advertisement = advertisementRepository.findById(id);
        if (advertisement.isPresent() && AdvertisementStatus.ACTIVE.equals(newStatus) || AdvertisementStatus.PASSIVE.equals(newStatus)) {
            advertisement.get().setAdvertisementStatus(newStatus);
            advertisementRepository.save(advertisement.get());
        }
    }
}
