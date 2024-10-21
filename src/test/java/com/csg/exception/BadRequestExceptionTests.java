package com.csg.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BadRequestExceptionTests {
    @Test
    void testBadRequestException_WithMessage() {
        String errorMessage = "Bad Request Error";
        BadRequestException exception = new BadRequestException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testBadRequestException_WithMessageAndCause() {
        String errorMessage = "Bad Request Error";
        Throwable cause = new RuntimeException("Cause of the error");
        BadRequestException exception = new BadRequestException(errorMessage, cause);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}