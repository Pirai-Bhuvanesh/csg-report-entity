package com.csg.entity.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsgConstantsTest {

    @Test
    void testConstants() {
        // Language and country constants
        assertEquals("en", CsgConstants.ENGLISH);
        assertEquals("US", CsgConstants.COUNTRY);

        // S3 file extensions
        assertEquals(".jpg", CsgConstants.S3_JPG);
        assertEquals(".jpeg", CsgConstants.S3_JPEG);
        assertEquals(".png", CsgConstants.S3_PNG);
        assertEquals(".gif", CsgConstants.S3_GIF);
        assertEquals(".pdf", CsgConstants.S3_PDF);

        // S3 MIME types
        assertEquals("image/jpeg", CsgConstants.S3_IMAGE_JPEG);
        assertEquals("image/png", CsgConstants.S3_IMAGE_PNG);
        assertEquals("image/gif", CsgConstants.S3_IMAGE_GIF);
        assertEquals("application/pdf", CsgConstants.S3_APPLICATION_PDF);
        assertEquals("application/octet-stream", CsgConstants.S3_APPLICATION_OCTET_STREAM);

        // Reactive error messages
        assertEquals("Unsupported reactive type: ", CsgConstants.UNSUPPORTED_REACTIVE_TYPE);
        assertEquals("Failed to serialize Mono", CsgConstants.FAILED_SERIALIZE_MONO);
        assertEquals("Failed to serialize Flux", CsgConstants.FAILED_SERIALIZE_FLUX);

        // Timezone
        assertEquals("Asia/Kolkata", CsgConstants.ZONE);

        // Mail configuration properties
        assertEquals("mail.transport.protocol", CsgConstants.PROTOCOL);
        assertEquals("mail.smtp.auth", CsgConstants.AUTH);
        assertEquals("mail.smtp.starttls.enable", CsgConstants.STARTTLS_ENABLE);
        assertEquals("mail.debug", CsgConstants.DEBUG);

        // Processing statuses
        assertEquals("UnProcessed", CsgConstants.UNPROCESSED);
        assertEquals("Processed", CsgConstants.PROCESSED);

        // Error messages
        assertEquals("Error: Column ID '%s' not found in columns.", CsgConstants.ERROR_COLUMN_ID_NOT_FOUND);
        assertEquals("Error: Row does not contain enough columns for rule '%s'.", CsgConstants.ERROR_ROW_DOES_NOT_CONTAIN_ENOUGH_COLUMNS);
        assertEquals("Error in column '%s': Value '%s' is invalid according to rule %s.", CsgConstants.ERROR_COLUMN_INVALID_VALUE);
        assertEquals("Error reading CSV file: %s", CsgConstants.ERROR_READING_CSV_FILE);
    }

    @Test
    void testPrivateConstructor() {
        Exception exception = assertThrows(UnsupportedOperationException.class, CsgConstants::new);
        assertEquals("This is a utility class and cannot be instantiated", exception.getMessage());
    }
}
