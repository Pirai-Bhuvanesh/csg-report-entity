package com.csg.entity.utils.enums;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MailStatusTest {

    @Test
    public void testEnumValues() {
        // Verify enum values exist
        assertNotNull(MailStatus.REQUIRED);
        assertNotNull(MailStatus.NOT_REQUIRED);
        assertNotNull(MailStatus.MAIL_SENT);

        // Verify the enum values match expected names
        assertEquals("REQUIRED", MailStatus.REQUIRED.name());
        assertEquals("NOT_REQUIRED", MailStatus.NOT_REQUIRED.name());
        assertEquals("MAIL_SENT", MailStatus.MAIL_SENT.name());
    }

    @Test
    public void testEnumCount() {
        // Verify the number of enums in MailStatus
        assertEquals(3, MailStatus.values().length);
    }
}
