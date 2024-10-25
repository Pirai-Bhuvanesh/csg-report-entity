package com.csg.entity.persistence.entity;

import com.csg.entity.persistence.entity.ReportMetaDataDetailsEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportMetaDataDetailsEntityTest {

    @Test
    void testReportMetaDataDetailsEntity() throws JsonProcessingException {
        // Arrange
        ReportMetaDataDetailsEntity reportMetaDataDetailsEntity = new ReportMetaDataDetailsEntity();
        UUID uuid = UUID.randomUUID();
        UUID reportMetaDataUuid = UUID.randomUUID();
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Create a sample Map for the 'data' field
        Map<String, Object> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", 123);

        // Convert Map to JSON String for comparison
        ObjectMapper mapper = new ObjectMapper();
        String expectedDataJson = mapper.writeValueAsString(data);

        // Act
        reportMetaDataDetailsEntity.setUuid(uuid);
        reportMetaDataDetailsEntity.setDataFromMap(data); // Use new method for serialization
        reportMetaDataDetailsEntity.setReportMetaDataUuid(reportMetaDataUuid);
        reportMetaDataDetailsEntity.setCreatedBy(createdBy);
        reportMetaDataDetailsEntity.setModifiedBy(modifiedBy);
        reportMetaDataDetailsEntity.setCreatedAt(createdAt);
        reportMetaDataDetailsEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportMetaDataDetailsEntity.getUuid());
        assertEquals(uuid, reportMetaDataDetailsEntity.getUuid());
        assertEquals(expectedDataJson, reportMetaDataDetailsEntity.getData()); // Compare JSON strings
        assertEquals(reportMetaDataUuid, reportMetaDataDetailsEntity.getReportMetaDataUuid());
        assertEquals(createdBy, reportMetaDataDetailsEntity.getCreatedBy());
        assertEquals(modifiedBy, reportMetaDataDetailsEntity.getModifiedBy());
        assertEquals(createdAt, reportMetaDataDetailsEntity.getCreatedAt());
        assertEquals(modifiedAt, reportMetaDataDetailsEntity.getModifiedAt());
    }
}
