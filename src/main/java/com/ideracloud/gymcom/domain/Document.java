package com.ideracloud.gymcom.domain;

import com.ideracloud.gymcom.enums.TypeDocument;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="GYM_DOCUMENT")
public class Document extends Base<Document> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    TypeDocument type;
    String filenameUser;
    String filename;
    String path;
    String fileType;

    @ManyToOne
    @JoinColumn(name = "INSCR_ID")
    Inscription inscription;

}
