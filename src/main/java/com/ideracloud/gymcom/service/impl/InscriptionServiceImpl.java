package com.ideracloud.gymcom.service.impl;

import com.ideracloud.gymcom.domain.Document;
import com.ideracloud.gymcom.domain.Inscription;
import com.ideracloud.gymcom.dto.*;
import com.ideracloud.gymcom.enums.TypeDocument;
import com.ideracloud.gymcom.exception.DataNotFoundException;
import com.ideracloud.gymcom.mapper.DocumentMapper;
import com.ideracloud.gymcom.mapper.InscriptionMapper;
import com.ideracloud.gymcom.repository.DocumentRepository;
import com.ideracloud.gymcom.repository.InscriptionRepository;
import com.ideracloud.gymcom.service.InscriptionService;
import com.ideracloud.gymcom.specification.InscriptionSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InscriptionServiceImpl implements InscriptionService {
    protected final Path root = Paths.get(System.getProperty("user.home"),"uploads","gymcom");

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    InscriptionSpecification inscriptionSpecification;

    @Autowired
    InscriptionMapper inscriptionMapper;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    DocumentMapper documentMapper;


    @Override
    public DocumentDto upload(Long id, MultipartFile file, TypeDocument type) throws IOException {

        if (!Files.exists(root)) {
            Files.createDirectories(root);
        }

        Inscription dca  = id > 0 ?  inscriptionRepository.findById(id).orElse(null) : null;
        Document doc = new Document();

        try{
            long millis = System.currentTimeMillis();
            String sig = Long.toHexString(millis);
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String filename = sig+"."+extension;

            Files.copy(file.getInputStream(), this.root.resolve(filename));
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/inscription/load/")
                    .path(String.valueOf(id))
                    .path(filename)
                    .toUriString();
            doc.setFilenameUser(file.getOriginalFilename());
            doc.setFilename(filename);
            doc.setPath(fileDownloadUri);
            doc.setFileType(file.getContentType());
            doc.setType(type);
            doc.setInscription(dca);
            documentRepository.save(doc);

        }catch(Exception e){
            log.error(e.getMessage());
        }

        return documentMapper.toDto(doc);
    }

    @Override
    public InscriptionDto create(InscriptionDto dto) {
        Inscription insc = inscriptionMapper.toEntity(dto);
        insc = inscriptionRepository.save(insc);
        for(Document doc : insc.getDocuments()){
            doc.setInscription(insc);
            documentRepository.save(doc);
        }
       return inscriptionMapper.toDto(insc);
    }

    @Override
    public InscriptionDto update(InscriptionDto dto) {
        inscriptionRepository.findById(dto.getId()).map(i->
        {
            i.setAbonnment(dto.getAbonnment());
            i.setNom(dto.getNom());
            i.setCin(dto.getCin());
            i.setDatenaiss(dto.getDatenaiss());
            i.setAbonnment(dto.getAbonnment());
            i.setDateDebut(dto.getDateDebut());
            i.setDateFin(dto.getDateFin());
            i.setActive(dto.isActive());
            i.setPrenom(dto.getPrenom());
            i.setGenre(dto.getGenre());
            i.setStatus(dto.getStatus());
            i.setTele(dto.getTele());
            i.setDocuments(dto.getDocuments().stream().map(documentMapper::toEntity) .collect(Collectors.toList()));
            return inscriptionRepository.save(i);
        }).orElseGet(()->null);
        return inscriptionMapper.toDto(inscriptionRepository.findById(dto.getId()).orElse(null));
    }

    @Override
    public Pager<InscriptionDto> search(SearchRequest<InscriptionSearchDto> request) {
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        Page<InscriptionDto> list = inscriptionRepository.findAll(inscriptionSpecification.findInscriptions(request.getCriteria()), pageRequest);
        return inscriptionMapper.toDtosWithPagination(list);
    }

    @Override
    public InscriptionDto findById(Long id) {
        Inscription obj = inscriptionRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Data not found for given parameters {} :" + id));
        return inscriptionMapper.toDto(obj);
    }

    @Override
    public List<InscriptionDto> listInscriptions() {
        return inscriptionRepository.findAll().stream().map( i -> inscriptionMapper.toDto(i)).collect(Collectors.toList());
    }


    @Override
    public void deleteFile(Long id, String filename) {
        Document vh = documentRepository.findById(id).orElse(null);
        Path file = root.resolve(filename);
        try {
            Files.deleteIfExists(file);
            documentRepository.delete(vh);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                log.error("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    @Override
    public void deleteInscription(Long id) {
        Inscription s = inscriptionRepository.findById(id).orElse(null);
        if(s != null){
            for(Document doc : s.getDocuments()){
                doc.setInscription(s);
                documentRepository.delete(doc);
            }
            inscriptionRepository.delete(s);
        }
    }

}
