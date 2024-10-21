package com.csg.entity.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Table(name="reports_request_list")
public class ReportsRequestListEntity {

    @Id
    private UUID uuid;
    private String fileFormat;
    private String fileName;
    private UUID reportId;
    private String status;
    private String errorResponse;
    private String s3Key;
    private int successfulRowCount;
    private int unsuccessfulRowCount;
    private int totalRowCount;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant modifiedAt;
}
