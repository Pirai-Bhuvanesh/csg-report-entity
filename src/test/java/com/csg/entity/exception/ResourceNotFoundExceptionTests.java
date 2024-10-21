package com.csg.entity.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTests {


    @Test
    void testResourceNotFoundException_WithoutMessage() {
        ResourceNotFoundException exception = new ResourceNotFoundException();
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testResourceNotFoundException_WithMessage() {
        String message = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testResourceNotFoundException_WithMessageAndCause() {
        String message = "Resource not found";
        Throwable cause = new RuntimeException("Original cause");
        ResourceNotFoundException exception = new ResourceNotFoundException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}