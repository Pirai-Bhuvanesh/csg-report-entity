package com.csg.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReportMetaDataDetailsEntityTest {

    @Test
    public void testReportMetaDataDetailsEntity() {
        // Arrange
        ReportMetaDataDetailsEntity reportMetaDataDetailsEntity = new ReportMetaDataDetailsEntity();
        UUID uuid = UUID.randomUUID();
        String data = "Sample Data";
        UUID reportMetaDataUuid = UUID.randomUUID();
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Act
        reportMetaDataDetailsEntity.setUuid(uuid);
        reportMetaDataDetailsEntity.setData(data);
        reportMetaDataDetailsEntity.setReportMetaDataUuid(reportMetaDataUuid);
        reportMetaDataDetailsEntity.setCreatedBy(createdBy);
        reportMetaDataDetailsEntity.setModifiedBy(modifiedBy);
        reportMetaDataDetailsEntity.setCreatedAt(createdAt);
        reportMetaDataDetailsEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportMetaDataDetailsEntity.getUuid());
        assertEquals(uuid, reportMetaDataDetailsEntity.getUuid());
        assertEquals(data, reportMetaDataDetailsEntity.getData());
        assertEquals(reportMetaDataUuid, reportMetaDataDetailsEntity.getReportMetaDataUuid());
        assertEquals(createdBy, reportMetaDataDetailsEntity.getCreatedBy());
        assertEquals(modifiedBy, reportMetaDataDetailsEntity.getModifiedBy());
        assertEquals(createdAt, reportMetaDataDetailsEntity.getCreatedAt());
        assertEquals(modifiedAt, reportMetaDataDetailsEntity.getModifiedAt());
    }
}
