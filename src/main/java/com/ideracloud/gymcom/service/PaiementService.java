package com.ideracloud.gymcom.service;


import com.ideracloud.gymcom.domain.Paiement;
import com.ideracloud.gymcom.dto.Pager;
import com.ideracloud.gymcom.dto.PaiementDto;

import java.util.List;
import java.util.Optional;

public interface PaiementService {
    PaiementDto create(PaiementDto dto);

    PaiementDto update(PaiementDto dto);
    List<PaiementDto> listPaiements();

    //Pager<PaiementDto> search(SearchRequest<PaiementSearchDto> request);

    PaiementDto findById(Long id);
    void deletePaiement(Long id);
}
