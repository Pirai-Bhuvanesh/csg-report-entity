package com.csg.entity.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonoFluxSerializationExceptionTest {

    @Test
    void testMonoFluxSerializationException() {
        // Arrange
        String message = "Serialization error occurred";
        Throwable cause = new RuntimeException("Cause of the error");

        // Act
        MonoFluxSerializationException exception = new MonoFluxSerializationException(message, cause);

        // Assert
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception instanceof RuntimeException);

        // Check that the exception has the correct HTTP status
        ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
        assertEquals(HttpStatus.FORBIDDEN, responseStatus.value());
    }
}
