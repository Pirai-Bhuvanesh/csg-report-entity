package com.csg.entity.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageKeyConstantsTest {

    @Test
    void testConstants() {
        assertEquals("map.column", MessageKeyConstants.MAP_COLUMN);

        // Error codes
        assertEquals("error.code.401", MessageKeyConstants.ERROR_CODE_401);
        assertEquals("error.code.400", MessageKeyConstants.ERROR_CODE_400);
        assertEquals("error.code.200", MessageKeyConstants.ERROR_CODE_200);
        assertEquals("error.code.404", MessageKeyConstants.ERROR_CODE_404);
        assertEquals("error.code.500", MessageKeyConstants.ERROR_CODE_500);
        assertEquals("internal.server.error", MessageKeyConstants.INTERNAL_SERVER_ERROR);
        assertEquals("file.uploaded.success", MessageKeyConstants.FILE_UPLOAD_SUCCESS);
        assertEquals("size.limit.message", MessageKeyConstants.SIZE_LIMIT_MESSAGE);
        assertEquals("before.s3.upload.put.object", MessageKeyConstants.BEFORE_S3_UPLOAD_PUT_OBJECT);
        assertEquals("before.s3.upload.get.object", MessageKeyConstants.BEFORE_S3_UPLOAD_GET_OBJECT);
        assertEquals("after.s3.upload.put.object", MessageKeyConstants.AFTER_S3_UPLOAD_PUT_OBJECT);
        assertEquals("after.s3.upload.get.object", MessageKeyConstants.AFTER_S3_UPLOAD_GET_OBJECT);
        assertEquals("image.uploaded.successfully", MessageKeyConstants.IMAGE_UPLOADED_SUCCESSFULLY);
        assertEquals("exception.in.uploadFile", MessageKeyConstants.EXCEPTION_IN_UPLOAD_FILE);
        assertEquals("problem.in.image.upload", MessageKeyConstants.PROBLEM_IN_IMAGE_UPLOAD);
        assertEquals("empty.row.data", MessageKeyConstants.EMPTY_ROW_DATA);
        assertEquals("file.size.exceeds.limit", MessageKeyConstants.FILE_SIZE_EXCEEDS_LIMIT);
        assertEquals("new.report.creation", MessageKeyConstants.CREATED_NEW_REPORT);
        assertEquals("template.not.found", MessageKeyConstants.TEMPLATE_NOT_FOUND);
        assertEquals("rule.not.found", MessageKeyConstants.RULE_NOT_FOUND);
        assertEquals("error.no.files.uploaded", MessageKeyConstants.NO_FILES_UPLOADED);
        assertEquals("error.report.not.found", MessageKeyConstants.REPORT_NOT_FOUND);
        assertEquals("csv.empty", MessageKeyConstants.CSV_EMPTY);
        assertEquals("invalid.file.name", MessageKeyConstants.INVALID_FILE_NAME);
    }

    @Test
    void testPrivateConstructor() {
        Exception exception = assertThrows(UnsupportedOperationException.class, MessageKeyConstants::new);
        assertEquals("Utility class", exception.getMessage());
    }
}
