package com.patikadev.fmss.finalcase.advertisement_service.converter;

import com.patikadev.fmss.finalcase.advertisement_service.dto.request.AdvertisementSaveRequest;
import com.patikadev.fmss.finalcase.advertisement_service.dto.response.AdvertisementResponse;
import com.patikadev.fmss.finalcase.advertisement_service.model.Advertisement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertisementConverter {


    public static Advertisement toAdvertisement(AdvertisementSaveRequest advertisementSaveRequest){

        Advertisement advertisement = new Advertisement();

        advertisement.setHeader(advertisementSaveRequest.getHeader());
        advertisement.setDescription(advertisementSaveRequest.getDescription());
        advertisement.setAmount(advertisementSaveRequest.getAmount());
        advertisement.setUserId(advertisementSaveRequest.getUserId());
        advertisement.setImages(advertisement.getImages());
        return advertisement;

        }

    public static AdvertisementResponse toAdvertisementResponse(Advertisement advertisement){

        AdvertisementResponse advertisementResponse = new AdvertisementResponse();

        advertisementResponse.setId(advertisement.getId());
        advertisementResponse.setHeader(advertisement.getHeader());
        advertisementResponse.setDescription(advertisement.getDescription());
        advertisementResponse.setAmount(advertisement.getAmount());
        advertisementResponse.setAdvertisementStatus(advertisement.getAdvertisementStatus());
        advertisementResponse.setUserId(advertisement.getUserId());
        advertisementResponse.setImages(advertisement.getImages());

        return advertisementResponse;
    }
}
