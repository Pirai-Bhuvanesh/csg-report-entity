package com.csg.entity.utils.enums;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StatusTest {

    @Test
    public void testEnumValues() {
        // Verify enum values exist
        assertNotNull(Status.YET_TO_START);
        assertNotNull(Status.IN_PROGRESS);
        assertNotNull(Status.COMPLETED);

        // Verify the enum values match expected names
        assertEquals("YET_TO_START", Status.YET_TO_START.name());
        assertEquals("IN_PROGRESS", Status.IN_PROGRESS.name());
        assertEquals("COMPLETED", Status.COMPLETED.name());
    }

    @Test
    public void testEnumCount() {
        // Verify the number of enums in Status
        assertEquals(3, Status.values().length);
    }
}
