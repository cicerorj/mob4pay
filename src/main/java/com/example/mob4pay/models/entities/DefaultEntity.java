package com.example.mob4pay.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class DefaultEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @MongoId(FieldType.STRING)
    private String id;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date lastModified;

}
