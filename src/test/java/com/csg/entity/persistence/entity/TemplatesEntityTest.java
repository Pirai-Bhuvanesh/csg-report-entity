package com.csg.entity.persistence.entity;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TemplatesEntityTest {

    @Test
    public void testTemplatesEntity() {
        // Arrange
        TemplatesEntity templatesEntity = new TemplatesEntity();
        UUID uuid = UUID.randomUUID();
        String templateName = "Sample Template";
        String createdBy = "testUser";
        String modifiedBy = "testUser";
        Instant createdAt = Instant.now();
        Instant modifiedAt = Instant.now();

        // Act
        templatesEntity.setUuid(uuid);
        templatesEntity.setTemplateName(templateName);
        templatesEntity.setCreatedBy(createdBy);
        templatesEntity.setModifiedBy(modifiedBy);
        templatesEntity.setCreatedAt(createdAt);
        templatesEntity.setModifiedAt(modifiedAt);

        // Assert
        assertNotNull(templatesEntity.getUuid());
        assertEquals(uuid, templatesEntity.getUuid());
        assertEquals(templateName, templatesEntity.getTemplateName());
        assertEquals(createdBy, templatesEntity.getCreatedBy());
        assertEquals(modifiedBy, templatesEntity.getModifiedBy());
        assertEquals(createdAt, templatesEntity.getCreatedAt());
        assertEquals(modifiedAt, templatesEntity.getModifiedAt());
    }
}
