package com.ideracloud.gymcom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ideracloud.gymcom.domain.Inscription;
import com.ideracloud.gymcom.enums.TypePaiement;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class PaiementDto extends BaseDto<PaiementDto>{
    Long id;
    TypePaiement typePaie;
    double totalAPaye;
    double montantPaye;
    double resteAPaye;
    boolean assuranceInclu;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date datePaiementCheque;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date datePaiement;
    String numeroCheque;
    InscriptionDto inscription;
}
