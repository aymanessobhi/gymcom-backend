package com.ideracloud.gymcom.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@FieldDefaults(level= AccessLevel.PRIVATE)
@Data
public abstract class Base<E> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate = new Date();

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedDate = new Date();

    @CreatedBy
    @Basic
    @Column(name="CREATED_BY", nullable=true)
    String createdBy;

    @LastModifiedBy
    @Basic
    @Column(name="MODIFIED_BY", nullable=true)
    String lastModifiedBy;
}
