package com.patikadev.fmss.finalcase.advertisement_service.controller;

import com.patikadev.fmss.finalcase.advertisement_service.dto.request.AdvertisementSaveRequest;
import com.patikadev.fmss.finalcase.advertisement_service.dto.response.AdvertisementResponse;
import com.patikadev.fmss.finalcase.advertisement_service.model.Enums.AdvertisementStatus;
import com.patikadev.fmss.finalcase.advertisement_service.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/advertisements")
public class AdvertisementController {

    private AdvertisementService advertisementService;

    @PostMapping
    public void save(AdvertisementSaveRequest advertisementSaveRequest){
        advertisementService.save(advertisementSaveRequest);
    }

    @GetMapping("getAllActiveStatus")
    public List<AdvertisementResponse> getAllByActiveStatus(){
        return advertisementService.getAllByActiveStatus();
    }

    @GetMapping("getAllPassiveStatus")
    public List<AdvertisementResponse> getAllByPassiveStatus(){
        return advertisementService.getAllByPassiveStatus();
    }

    @PutMapping("/status/{id}/{newStatus}")
    public void updateStatus(@PathVariable Long id, @PathVariable AdvertisementStatus newStatus){
        advertisementService.updateStatus(id, newStatus);
    }

}
