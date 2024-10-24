package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportMetaDataDetailsEntityTest {

    @Test
    void testReportMetaDataDetailsEntity() {
        // Arrange
        ReportMetaDataDetailsEntity reportMetaDataDetailsEntity = new ReportMetaDataDetailsEntity();
        UUID uuid = UUID.randomUUID();
        UUID reportMetaDataUuid = UUID.randomUUID();
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        // Create a sample Map for the 'data' field
        Map<String, Object> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", 123);

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
