package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MethodRulesEntityTest {

    @Test
    void testMethodRulesEntity() {
        // Arrange
        MethodRulesEntity methodRulesEntity = new MethodRulesEntity();
        UUID uuid = UUID.randomUUID();
        String methodName = "testMethod";
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime modifiedAt = LocalDateTime.now();

        // Act
        methodRulesEntity.setUuid(uuid);
        methodRulesEntity.setMethodName(methodName);
        methodRulesEntity.setCreatedBy(createdBy);
        methodRulesEntity.setModifiedBy(modifiedBy);
        methodRulesEntity.setCreatedAt(createdAt);
        methodRulesEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(methodRulesEntity.getUuid());
        assertEquals(uuid, methodRulesEntity.getUuid());
        assertEquals(methodName, methodRulesEntity.getMethodName());
        assertEquals(createdBy, methodRulesEntity.getCreatedBy());
        assertEquals(modifiedBy, methodRulesEntity.getModifiedBy());
        assertEquals(createdAt, methodRulesEntity.getCreatedAt());
        assertEquals(modifiedAt, methodRulesEntity.getModifiedAt());
    }
}
