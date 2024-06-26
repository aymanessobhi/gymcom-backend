package com.ideracloud.gymcom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataRef {
    String code;
    String description;
    double value;
}
