package com.ideracloud.gymcom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ideracloud.gymcom.enums.Genre;
import com.ideracloud.gymcom.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InscriptionDto extends BaseDto<InscriptionDto> {

    Long id;
    String nom;
    String lieunais;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date datenaiss;
    String prenom;
    String nationalite;
    Genre genre;
    Status status;
    Integer nbrEnfants;
    String telephone;
    String lieuResidence;
    String numCmu;
    List<DocumentDto> documents;
}
