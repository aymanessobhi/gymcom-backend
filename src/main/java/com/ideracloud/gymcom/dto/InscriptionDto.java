package com.ideracloud.gymcom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ideracloud.gymcom.enums.Genre;
import com.ideracloud.gymcom.enums.Status;
import com.ideracloud.gymcom.enums.TypeAbonnement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InscriptionDto extends BaseDto<InscriptionDto> {

    Long id;
    String nom;
    String cin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date datenaiss;
    TypeAbonnement abonnment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date dateDebut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date dateFin;
    boolean active;
    String prenom;
    @Enumerated(EnumType.STRING)
    Genre genre;
    @Enumerated(EnumType.STRING)
    Status status;
    String tele;
    List<DocumentDto> documents;
}
