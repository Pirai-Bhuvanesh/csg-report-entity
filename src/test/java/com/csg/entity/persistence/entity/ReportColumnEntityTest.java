package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportColumnEntityTest {

    @Test
    void testReportColumnEntity() {
        // Arrange
        ReportColumnEntity reportColumnEntity = new ReportColumnEntity();
        UUID uuid = UUID.randomUUID();
        String columnName = "testColumn";
        String dataType = "String";
        int columnNumber = 1;
        UUID reportId = UUID.randomUUID();
        String reportName = "testReport";
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Act
        reportColumnEntity.setUuid(uuid);
        reportColumnEntity.setColumnName(columnName);
        reportColumnEntity.setDataType(dataType);
        reportColumnEntity.setColumnNumber(columnNumber);
        reportColumnEntity.setReportId(reportId);
        reportColumnEntity.setReportName(reportName);
        reportColumnEntity.setCreatedBy(createdBy);
        reportColumnEntity.setModifiedBy(modifiedBy);
        reportColumnEntity.setCreatedAt(createdAt);
        reportColumnEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportColumnEntity.getUuid());
        assertEquals(uuid, reportColumnEntity.getUuid());
        assertEquals(columnName, reportColumnEntity.getColumnName());
        assertEquals(dataType, reportColumnEntity.getDataType());
        assertEquals(columnNumber, reportColumnEntity.getColumnNumber());
        assertEquals(reportId, reportColumnEntity.getReportId());
        assertEquals(reportName, reportColumnEntity.getReportName());
        assertEquals(createdBy, reportColumnEntity.getCreatedBy());
        assertEquals(modifiedBy, reportColumnEntity.getModifiedBy());
        assertEquals(createdAt, reportColumnEntity.getCreatedAt());
        assertEquals(modifiedAt, reportColumnEntity.getModifiedAt());
    }
}
