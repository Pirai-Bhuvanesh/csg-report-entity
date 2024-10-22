package com.csg.entity.util.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FileTypeTest {

    @Test
    void testEnumValues() {
        // Verify enum values exist
        assertNotNull(FileType.EMPLOYEE_REPORT);
        assertNotNull(FileType.TRELLIX_REPORT);

        // Verify the enum values match expected names
        assertEquals("EMPLOYEE_REPORT", FileType.EMPLOYEE_REPORT.name());
        assertEquals("TRELLIX_REPORT", FileType.TRELLIX_REPORT.name());
    }

    @Test
    void testEnumCount() {
        // Verify the number of enums in FileType
        assertEquals(2, FileType.values().length);
    }
}
