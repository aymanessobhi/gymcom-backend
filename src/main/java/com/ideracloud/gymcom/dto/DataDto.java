package com.ideracloud.gymcom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataDto {
    List<DataRef> documentType;
    List<DataRef> genre;
    List<DataRef> status;
    List<DataRef> typeAbonnement;

}
