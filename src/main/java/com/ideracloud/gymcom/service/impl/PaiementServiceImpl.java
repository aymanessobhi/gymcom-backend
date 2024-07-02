package com.ideracloud.gymcom.service.impl;

import com.ideracloud.gymcom.domain.Document;
import com.ideracloud.gymcom.domain.Inscription;
import com.ideracloud.gymcom.domain.Paiement;
import com.ideracloud.gymcom.dto.PaiementDto;
import com.ideracloud.gymcom.mapper.InscriptionMapper;
import com.ideracloud.gymcom.mapper.PaiementMapper;
import com.ideracloud.gymcom.repository.DocumentRepository;
import com.ideracloud.gymcom.repository.InscriptionRepository;
import com.ideracloud.gymcom.repository.PaiementRepository;
import com.ideracloud.gymcom.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    PaiementMapper paiementMapper;
    @Autowired
    InscriptionMapper inscriptionMapper;
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public PaiementDto create(PaiementDto dto) {
        Paiement paiement = paiementMapper.toEntity(dto);

        // Check if the Inscription exists
        if (dto.getInscription() != null && dto.getInscription().getId() != null) {
            Long inscriptionId = dto.getInscription().getId();
            Inscription existingInscription = inscriptionRepository.findById(inscriptionId).orElse(null);
                      paiement.setInscription(existingInscription);
        } else {
            // If Inscription does not exist, save the new Inscription
            Inscription inscription = inscriptionMapper.toEntity(dto.getInscription());
            Inscription savedInscription = inscriptionRepository.save(inscription);
            for(Document doc : savedInscription.getDocuments()){
                doc.setInscription(savedInscription);
                documentRepository.save(doc);
            }
            paiement.setInscription(savedInscription);
        }

        // Save the Paiement
        Paiement savedPaiement = paiementRepository.save(paiement);
        return paiementMapper.toDto(savedPaiement);
    }


    @Override
    public PaiementDto update(PaiementDto dto) {
        paiementRepository.findById(dto.getId()).map(p->{
            p.setMontantPaye(dto.getMontantPaye());
            p.setNumeroCheque(dto.getNumeroCheque());
            p.setDatePaiementCheque(dto.getDatePaiementCheque());
            p.setTotalAPaye(dto.getTotalAPaye());
            p.setResteAPaye(dto.getResteAPaye());
            p.setTypePaie(dto.getTypePaie());
            p.setAssuranceInclu(dto.isAssuranceInclu());
            p.setInscription(paiementMapper.toEntity(dto).getInscription());
            return paiementRepository.save(p);
        }).orElseGet(()->null);
        return paiementMapper.toDto(paiementRepository.findById(dto.getId()).orElse(null));
    }

    @Override
    public List<PaiementDto> listPaiements() {
        return paiementRepository.findAll().stream().map(paiement -> paiementMapper.toDto(paiement)).collect(Collectors.toList());
    }

    @Override
    public PaiementDto findById(Long id) {
        return paiementMapper.toDto(paiementRepository.findById(id).orElse(null));
    }

    @Override
    public void deletePaiement(Long id) {
        Paiement p = paiementRepository.findById(id).orElse(null);
        if(p!=null){
            paiementRepository.delete(p);
        }
    }
}
