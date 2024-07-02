package com.ideracloud.gymcom.controller;

import com.ideracloud.gymcom.dto.*;
import com.ideracloud.gymcom.enums.TypeDocument;
import com.ideracloud.gymcom.exception.BadRequestException;
import com.ideracloud.gymcom.exception.ResourceUtil;
import com.ideracloud.gymcom.service.InscriptionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/inscription")
@CrossOrigin("*")
@Slf4j
public class InscriptionController {

    @Autowired
    InscriptionService inscriptionService;

    @PostMapping("create")
    public ApiResponse<InscriptionDto> create(@RequestBody @Valid InscriptionDto dto, BindingResult result) {
        try {
            return ApiResponse.ok(HttpStatus.CREATED, inscriptionService.create(dto));
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestException(result, ResourceUtil.getMessage("Invalid request"));
        }
    }

    @GetMapping({"find/{id}"})
    public ApiResponse<InscriptionDto> getOne(@PathVariable Long id) {
        return ApiResponse.ok(inscriptionService.findById(id));
    }


    @PutMapping("update")
    public ApiResponse<InscriptionDto> update(@RequestBody @Valid InscriptionDto dto, BindingResult result){
        try{
            return ApiResponse.ok(inscriptionService.update(dto));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BadRequestException(result, ResourceUtil.getMessage("Invalid request"));
        }
    }

    @PostMapping({"search"})
    public ApiResponse<Pager<InscriptionDto>> search(@RequestBody SearchRequest<InscriptionSearchDto> dto) {
        return ApiResponse.ok(inscriptionService.search(dto));
    }

    @GetMapping("load")
    @ResponseBody
    public ResponseEntity<String> downloadFile(@RequestParam("filename") String filename) throws Exception {
        Resource resource =  inscriptionService.load(filename);
        String fileBase64 = Base64.getMimeEncoder().encodeToString(resource.getContentAsByteArray());
        return ResponseEntity.ok(fileBase64);
    }
    @GetMapping("list")
    public ApiResponse<List<PaiementDto>> listInscriptions(){
        return ApiResponse.ok(inscriptionService.listInscriptions());
    }

    @PostMapping("upload")
    @ResponseBody
    public ApiResponse<DocumentDto> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("inscriptionId") Long inscriptionId , @RequestParam(value = "documentType",required = false) String documentType) throws Exception {
        DocumentDto dto = inscriptionService.upload(inscriptionId,file, TypeDocument.valueOf(documentType));
        return ApiResponse.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInscription(@PathVariable Long id){
        inscriptionService.deleteInscription(id);
    }
}
