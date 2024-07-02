package com.ideracloud.gymcom.controller;


import com.ideracloud.gymcom.domain.Paiement;
import com.ideracloud.gymcom.dto.ApiResponse;
import com.ideracloud.gymcom.dto.PaiementDto;
import com.ideracloud.gymcom.exception.BadRequestException;
import com.ideracloud.gymcom.exception.ResourceUtil;
import com.ideracloud.gymcom.service.PaiementService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@RestController
@RequestMapping("/paiement")
@CrossOrigin("*")
@Slf4j
public class PaiementController {
    @Autowired
    PaiementService paiementService;

    @PostMapping("create")
    public ApiResponse<PaiementDto> create(@RequestBody @Valid PaiementDto dto, BindingResult result){
        try {
            return ApiResponse.ok(HttpStatus.CREATED, paiementService.create(dto));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestException(result, ResourceUtil.getMessage("Invalid request"));
        }
    }

    @GetMapping("list")
    public ApiResponse<List<PaiementDto>> listPaiements(){
        return ApiResponse.ok(paiementService.listPaiements());
    }

    @GetMapping("find/{id}")
    public ApiResponse<PaiementDto> findPaimentById(@PathVariable Long id){
        return ApiResponse.ok(paiementService.findById(id));
    }

    @PutMapping("update")
    public ApiResponse<PaiementDto> update(@RequestBody PaiementDto dto, BindingResult result){
        try {
            return ApiResponse.ok(paiementService.update(dto));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestException(result, ResourceUtil.getMessage("Invalid request"));
        }
    }

    @DeleteMapping("delete/{id}")
    public void deletePaiment(@PathVariable Long id){
        paiementService.deletePaiement(id);
    }

}
