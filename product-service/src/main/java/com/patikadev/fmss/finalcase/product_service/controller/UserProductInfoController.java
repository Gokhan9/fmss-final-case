package com.patikadev.fmss.finalcase.product_service.controller;


import com.patikadev.fmss.finalcase.product_service.dto.request.UserProductInfoSaveRequest;
import com.patikadev.fmss.finalcase.product_service.dto.response.UserProductInfoResponse;
import com.patikadev.fmss.finalcase.product_service.service.UserProductInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/userProductInfo")
public class UserProductInfoController {

    @Autowired
    private UserProductInfoService infoService;


    @PostMapping
    public void save(UserProductInfoSaveRequest userProductInfoSaveRequest) {
        infoService.save(userProductInfoSaveRequest);
    }

    @PostMapping("saveAll")
    public void saveList(@RequestBody List<UserProductInfoSaveRequest> userProductInfoSaveRequestList) {
        infoService.saveList(userProductInfoSaveRequestList);
    }

    @GetMapping("/{userId}")
    public List<UserProductInfoResponse> getByUserId(@PathVariable Long userId) {
        return infoService.getListByUserId(userId);
    }
}
