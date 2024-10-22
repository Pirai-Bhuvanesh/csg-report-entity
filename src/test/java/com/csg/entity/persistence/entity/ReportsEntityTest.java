package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportsEntityTest {

    @Test
    void testReportsEntity() {
        // Arrange
        ReportsEntity reportsEntity = new ReportsEntity();
        UUID uuid = UUID.randomUUID();
        String reportName = "Monthly Report";
        boolean emailRequired = true;
        boolean freshWorks = false;
        boolean managerMail = true;
        UUID templateId = UUID.randomUUID();
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Act
        reportsEntity.setUuid(uuid);
        reportsEntity.setReportName(reportName);
        reportsEntity.setEmailRequired(emailRequired);
        reportsEntity.setFreshWorks(freshWorks);
        reportsEntity.setManagerMail(managerMail);
        reportsEntity.setTemplateId(templateId);
        reportsEntity.setCreatedBy(createdBy);
        reportsEntity.setModifiedBy(modifiedBy);
        reportsEntity.setCreatedAt(createdAt);
        reportsEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportsEntity.getUuid());
        assertEquals(uuid, reportsEntity.getUuid());
        assertEquals(reportName, reportsEntity.getReportName());
        assertEquals(emailRequired, reportsEntity.isEmailRequired());
        assertEquals(freshWorks, reportsEntity.isFreshWorks());
        assertEquals(managerMail, reportsEntity.isManagerMail());
        assertEquals(templateId, reportsEntity.getTemplateId());
        assertEquals(createdBy, reportsEntity.getCreatedBy());
        assertEquals(modifiedBy, reportsEntity.getModifiedBy());
        assertEquals(createdAt, reportsEntity.getCreatedAt());
        assertEquals(modifiedAt, reportsEntity.getModifiedAt());
    }
}
