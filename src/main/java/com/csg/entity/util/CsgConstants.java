package com.csg.entity.util;

public final class CsgConstants {

    // Language and country constants
    public static final String ENGLISH = "en";
    public static final String COUNTRY = "US";

    // S3 file extensions
    public static final String S3_JPG = ".jpg";
    public static final String S3_JPEG = ".jpeg";
    public static final String S3_PNG = ".png";
    public static final String S3_GIF = ".gif";
    public static final String S3_PDF = ".pdf";

    // S3 MIME types
    public static final String S3_IMAGE_JPEG = "image/jpeg";
    public static final String S3_IMAGE_PNG = "image/png";
    public static final String S3_IMAGE_GIF = "image/gif";
    public static final String S3_APPLICATION_PDF = "application/pdf";
    public static final String S3_APPLICATION_OCTET_STREAM = "application/octet-stream";

    // Reactive error messages
    public static final String UNSUPPORTED_REACTIVE_TYPE = "Unsupported reactive type: ";
    public static final String FAILED_SERIALIZE_MONO = "Failed to serialize Mono";
    public static final String FAILED_SERIALIZE_FLUX = "Failed to serialize Flux";

    // Timezone
    public static final String ZONE = "Asia/Kolkata";

    // Mail configuration properties
    public static final String PROTOCOL = "mail.transport.protocol";
    public static final String AUTH = "mail.smtp.auth";
    public static final String STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String DEBUG = "mail.debug";

    // Processing statuses
    public static final String UNPROCESSED = "UnProcessed";
    public static final String PROCESSED = "Processed";

    // Error messages
    public static final String ERROR_COLUMN_ID_NOT_FOUND = "Error: Column ID '%s' not found in columns.";
    public static final String ERROR_ROW_DOES_NOT_CONTAIN_ENOUGH_COLUMNS = "Error: Row does not contain enough columns for rule '%s'.";
    public static final String ERROR_COLUMN_INVALID_VALUE = "Error in column '%s': Value '%s' is invalid according to rule %s.";
    public static final String ERROR_READING_CSV_FILE = "Error reading CSV file: %s";

    // Private constructor to prevent instantiation
    CsgConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
