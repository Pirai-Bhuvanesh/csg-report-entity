package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReportRulesEntityTest {

    @Test
    void testReportRulesEntity() {
        // Arrange
        ReportRulesEntity reportRulesEntity = new ReportRulesEntity();
        UUID uuid = UUID.randomUUID();
        UUID columnUuid = UUID.randomUUID();
        UUID ruleMethodUuid = UUID.randomUUID();
        UUID reportId = UUID.randomUUID();
        String reportName = "Sample Report";
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        // Act
        reportRulesEntity.setUuid(uuid);
        reportRulesEntity.setColumnUuid(columnUuid);
        reportRulesEntity.setRuleMethodUuid(ruleMethodUuid);
        reportRulesEntity.setReportId(reportId);
        reportRulesEntity.setReportName(reportName);
        reportRulesEntity.setCreatedBy(createdBy);
        reportRulesEntity.setModifiedBy(modifiedBy);
        reportRulesEntity.setCreatedAt(createdAt);
        reportRulesEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(reportRulesEntity.getUuid());
        assertEquals(uuid, reportRulesEntity.getUuid());
        assertEquals(columnUuid, reportRulesEntity.getColumnUuid());
        assertEquals(ruleMethodUuid, reportRulesEntity.getRuleMethodUuid());
        assertEquals(reportId, reportRulesEntity.getReportId());
        assertEquals(reportName, reportRulesEntity.getReportName());
        assertEquals(createdBy, reportRulesEntity.getCreatedBy());
        assertEquals(modifiedBy, reportRulesEntity.getModifiedBy());
        assertEquals(createdAt, reportRulesEntity.getCreatedAt());
        assertEquals(modifiedAt, reportRulesEntity.getModifiedAt());
    }
}
