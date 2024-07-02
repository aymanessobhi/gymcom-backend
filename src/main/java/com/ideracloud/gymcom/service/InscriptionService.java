package com.ideracloud.gymcom.service;

import com.ideracloud.gymcom.dto.*;
import com.ideracloud.gymcom.enums.TypeDocument;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface InscriptionService {

    DocumentDto upload(Long id, MultipartFile file, TypeDocument type) throws IOException;

    InscriptionDto create(InscriptionDto dto);

    InscriptionDto update(InscriptionDto dto);

    Pager<InscriptionDto> search(SearchRequest<InscriptionSearchDto> request);

    InscriptionDto findById(Long id);
    List<InscriptionDto> listInscriptions();

    void deleteFile(Long id, String filename);

    Resource load(String filename);

    void deleteInscription(Long id);

}
