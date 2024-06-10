package com.ideracloud.gymcom.controller;

import com.ideracloud.gymcom.dto.ApiResponse;
import com.ideracloud.gymcom.dto.DataDto;
import com.ideracloud.gymcom.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@CrossOrigin("*")
@Slf4j
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping("")
    public ApiResponse<DataDto> getData() {
        DataDto data = new DataDto();
        data.setGenre(dataService.loadGenre());
        data.setDocumentType(dataService.loadSDocType());
        data.setStatus(dataService.loadStatus());
        data.setTypeAbonnement(dataService.loadStatus());

        return ApiResponse.ok(data);
    }
}
