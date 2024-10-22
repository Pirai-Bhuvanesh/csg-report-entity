package com.csg.entity.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApiResponseTest {

    @Test
    void testApiResponse() {
        // Arrange
        ApiResponse apiResponse = new ApiResponse();
        String message = "Request was successful";
        Boolean status = true;
        String statusCode = "200";

        // Act
        apiResponse.setMessage(message);
        apiResponse.setStatus(status);
        apiResponse.setStatusCode(statusCode);

        // Assert
        assertNotNull(apiResponse);
        assertEquals(message, apiResponse.getMessage());
        assertEquals(status, apiResponse.getStatus());
        assertEquals(statusCode, apiResponse.getStatusCode());
    }
}
