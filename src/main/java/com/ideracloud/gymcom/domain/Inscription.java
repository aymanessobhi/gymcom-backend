package com.ideracloud.gymcom.domain;

import com.ideracloud.gymcom.enums.Genre;
import com.ideracloud.gymcom.enums.Status;
import com.ideracloud.gymcom.enums.TypeAbonnement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="GYM_INSCRIPTION")
public class Inscription extends Base<Inscription>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cin;
    @Enumerated(EnumType.STRING)
    TypeAbonnement abonnment;
    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    Date dateFin;
    boolean active;
    String nom;
    @Temporal(TemporalType.DATE)
    Date datenaiss;
    String prenom;
    @Enumerated(EnumType.STRING)
    Genre genre;
    @Enumerated(EnumType.STRING)
    Status status;
    String tele;

    @OneToMany(mappedBy = "inscription")
    List<Document> documents;

}
