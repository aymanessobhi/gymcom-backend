package com.ideracloud.gymcom.repository;


import com.ideracloud.gymcom.domain.Paiement;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaiementRepository extends BaseRepository<Paiement>{
    Optional<Paiement> findByInscription_Id(Long id);
}
