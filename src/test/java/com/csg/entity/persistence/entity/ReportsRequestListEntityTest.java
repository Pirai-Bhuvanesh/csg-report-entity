package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReportsRequestListEntityTest {

    @Test
    void testReportsRequestListEntity() {
        // Arrange
        ReportsRequestListEntity reportsRequestListEntity = new ReportsRequestListEntity();
        UUID uuid = UUID.randomUUID();
        String fileFormat = "CSV";
        String fileName = "report.csv";
        UUID reportId = UUID.randomUUID();
        String status = "SUCCESS";
        String errorResponse = null; // Assuming no error response for this test
        String s3Key = "s3://bucket/report.csv";
        int successfulRowCount = 100;
        int unsuccessfulRowCount = 0;
        int totalRowCount = 100;
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Act
        reportsRequestListEntity.setUuid(uuid);
        reportsRequestListEntity.setFileFormat(fileFormat);
        reportsRequestListEntity.setFileName(fileName);
        reportsRequestListEntity.setReportId(reportId);
        reportsRequestListEntity.setStatus(status);
        reportsRequestListEntity.setErrorResponse(errorResponse);
        reportsRequestListEntity.setS3Key(s3Key);
        reportsRequestListEntity.setSuccessfulRowCount(successfulRowCount);
        reportsRequestListEntity.setUnsuccessfulRowCount(unsuccessfulRowCount);
        reportsRequestListEntity.setTotalRowCount(totalRowCount);
        reportsRequestListEntity.setCreatedBy(createdBy);
        reportsRequestListEntity.setModifiedBy(modifiedBy);
        reportsRequestListEntity.setCreatedAt(createdAt);
        reportsRequestListEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportsRequestListEntity.getUuid());
        assertEquals(uuid, reportsRequestListEntity.getUuid());
        assertEquals(fileFormat, reportsRequestListEntity.getFileFormat());
        assertEquals(fileName, reportsRequestListEntity.getFileName());
        assertEquals(reportId, reportsRequestListEntity.getReportId());
        assertEquals(status, reportsRequestListEntity.getStatus());
        assertEquals(errorResponse, reportsRequestListEntity.getErrorResponse());
        assertEquals(s3Key, reportsRequestListEntity.getS3Key());
        assertEquals(successfulRowCount, reportsRequestListEntity.getSuccessfulRowCount());
        assertEquals(unsuccessfulRowCount, reportsRequestListEntity.getUnsuccessfulRowCount());
        assertEquals(totalRowCount, reportsRequestListEntity.getTotalRowCount());
        assertEquals(createdBy, reportsRequestListEntity.getCreatedBy());
        assertEquals(modifiedBy, reportsRequestListEntity.getModifiedBy());
        assertEquals(createdAt, reportsRequestListEntity.getCreatedAt());
        assertEquals(modifiedAt, reportsRequestListEntity.getModifiedAt());
    }
}
