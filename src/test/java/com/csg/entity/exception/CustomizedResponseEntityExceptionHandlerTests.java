package com.csg.entity.exception;

import com.csg.entity.payload.response.ApiResponse;
import com.csg.entity.util.MessageKeyConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomizedResponseEntityExceptionHandlerTests {

    private CustomizedResponseEntityExceptionHandler exceptionHandler;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        exceptionHandler = new CustomizedResponseEntityExceptionHandler(messageSource);
    }

    @Test
    void handleException_ShouldReturnInternalServerErrorResponse() {
        Exception ex = new Exception("Test internal server error");

        Mockito.when(messageSource.getMessage(MessageKeyConstants.INTERNAL_SERVER_ERROR, null, null))
                .thenReturn("Internal server error");

        Mono<ApiResponse> response = exceptionHandler.handleException(ex);

        ApiResponse apiResponse = response.block(); // Blocking to get the response

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.parseInt(apiResponse.getStatusCode()));
        assertEquals("Message not found", apiResponse.getMessage());
        assertEquals(false, apiResponse.isStatus());
    }

    @Test
    void handleResourceNotFoundException_ShouldReturnNotFoundResponse() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");

        Mockito.when(messageSource.getMessage("Resource not found", null, null))
                .thenReturn("Resource not found");

        Mono<ApiResponse> response = exceptionHandler.handleResourceNotFoundException(ex);

        ApiResponse apiResponse = response.block();

        assertEquals(HttpStatus.NOT_FOUND.value(), Integer.parseInt(apiResponse.getStatusCode()));
        assertEquals("Message not found", apiResponse.getMessage());
        assertEquals(false, apiResponse.isStatus());
    }

    @Test
    void handleBadRequestException_ShouldReturnBadRequestResponse() {
        BadRequestException ex = new BadRequestException("Bad request");

        Mockito.when(messageSource.getMessage("Bad request", null, null))
                .thenReturn("Bad request");

        Mono<ApiResponse> response = exceptionHandler.handleBadRequestException(ex);

        ApiResponse apiResponse = response.block();

        assertEquals(HttpStatus.BAD_REQUEST.value(), Integer.parseInt(apiResponse.getStatusCode()));
        assertEquals("Message not found", apiResponse.getMessage());
        assertEquals(false, apiResponse.isStatus());
    }

    @Test
    void handleFallbackException_ShouldReturnInternalServerErrorResponse() {
        Throwable ex = new Throwable("Unexpected error occurred");

        Mockito.when(messageSource.getMessage(MessageKeyConstants.INTERNAL_SERVER_ERROR, null, null))
                .thenReturn("Internal server error");

        Mono<ApiResponse> response = exceptionHandler.handleFallbackException(ex);

        ApiResponse apiResponse = response.block();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), Integer.parseInt(apiResponse.getStatusCode()));
        assertEquals("Message not found", apiResponse.getMessage());
        assertEquals(false, apiResponse.isStatus());
    }
}
