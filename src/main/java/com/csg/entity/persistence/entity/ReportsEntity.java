package com.csg.entity.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name="reports")
public class ReportsEntity {

    @Id
    private UUID uuid;
    private String reportName;
    private boolean emailRequired;
    private boolean freshWorks;
    private boolean managerMail;
    private UUID templateId;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
