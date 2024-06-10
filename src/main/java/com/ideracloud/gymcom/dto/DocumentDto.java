package com.ideracloud.gymcom.dto;

import com.ideracloud.gymcom.enums.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto extends BaseDto<DocumentDto>{

    Long id;
    String filename;
    String path;
    TypeDocument type;
    String fileType;
    String filenameUser;

}
