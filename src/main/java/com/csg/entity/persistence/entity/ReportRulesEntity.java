package com.csg.entity.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Table(name="report_rules")
public class ReportRulesEntity {

    @Id
    private UUID uuid;
    private UUID columnUuid;
    private UUID ruleMethodUuid;
    private UUID reportId;
    private String reportName;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant modifiedAt;
}
