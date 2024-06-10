package com.ideracloud.gymcom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto<T> implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    Date createdDate = new Date();

    Date lastModifiedDate = new Date();

    String createdBy;

    String lastModifiedBy;

}
