package com.csg.entity.persistence.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Table(name = "report_meta_data")
public class ReportMetaDataDetailsEntity {

    @Id
    private UUID uuid;
    private String data;
    private UUID reportMetaDataUuid;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant modifiedAt;
}
