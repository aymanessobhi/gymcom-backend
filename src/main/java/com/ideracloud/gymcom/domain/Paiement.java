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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TypePaiement typePaie;
    @Column(nullable = false)
    double totalAPaye;
    @Column(nullable = false)
    double montantPaye;
    @Column(nullable = false)
    double resteAPaye;
    @Column(nullable = false)
    boolean assuranceInclu;

    @Temporal(TemporalType.DATE)
    Date datePaiementCheque;

    @Temporal(TemporalType.DATE)
    Date datePaiement;

    String numeroCheque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSCRIPTION_ID")
    Inscription inscription;
}
