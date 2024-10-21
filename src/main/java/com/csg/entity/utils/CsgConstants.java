package com.csg.entity.utils;

public interface CsgConstants {
    String ENGLISH = "en";
    String COUNTRY = "US";
    String S3_JPG = ".jpg";
    String S3_JPEG = ".jpeg";
    String S3_PNG = ".png";
    String S3_GIF = ".gif";
    String S3_PDF = ".pdf";
    String S3_IMAGE_JPEG = "image/jpeg";
    String S3_IMAGE_PNG = "image/png";
    String S3_IMAGE_GIF = "image/gif";
    String UNSUPPORTED_REACTIVE_TYPE="Unsupported reactive type: ";
    String FAILED_SERIALIZE_MONO="Failed to serialize Mono";
    String FAILED_SERIALIZE_FLUX="Failed to serialize Flux";
    String S3_APPLICATION_PDF = "application/pdf";
    String S3_APPLICATION_OCTET_STREAM = "application/octet-stream";
    String ZONE = "Asia/Kolkata";
    String PROTOCOL = "mail.transport.protocol";
    String AUTH = "mail.smtp.auth";
    String STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    String DEBUG = "mail.debug";
    String UNPROCESSED = "UnProcessed";
    String PROCESSED = "Processed";
    String ERROR_COLUMN_ID_NOT_FOUND = "Error: Column ID '%s' not found in columns.";
    String ERROR_ROW_DOES_NOT_CONTAIN_ENOUGH_COLUMNS = "Error: Row does not contain enough columns for rule '%s'.";
    String ERROR_COLUMN_INVALID_VALUE = "Error in column '%s': Value '%s' is invalid according to rule %s.";
    String ERROR_READING_CSV_FILE = "Error reading CSV file: %s";
}
