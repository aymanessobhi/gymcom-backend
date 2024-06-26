package com.ideracloud.gymcom.domain;

import com.ideracloud.gymcom.enums.TypePaiement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="GYM_PAIEMENT")
public class Paiement extends Base<Paiement>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    TypePaiement typePaie;
    double totalAPaye;
    double montantPaye;
    double resteAPaye;
    boolean assuranceInclu;
    @Temporal(TemporalType.DATE)
    Date datePaiementCheque;
    String numeroCheque;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSCRIPTION_ID")
    Inscription inscription;
}
