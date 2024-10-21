package com.csg.entity.exception;

import com.csg.entity.payload.response.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CustomizedResponseEntityExceptionHandlerTests {

    @InjectMocks
    private CustomizedResponseEntityExceptionHandler exceptionHandler;

    @Mock
    private MessageSource messageSource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleExceptionTest() {
        Exception exception = new Exception("Exception not found");
        when(messageSource.getMessage(anyString(), any(), any())).thenReturn("Exception not found message");
        Mono<ApiResponse> responseMono = exceptionHandler.handleException(exception);
        StepVerifier.create(responseMono).expectNextMatches(response -> {
            assertEquals("500", response.getStatusCode());
            assertEquals("Exception not found message", response.getMessage());
            return true;
        }).verifyComplete();
    }

    @Test
    void testHandleResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        when(messageSource.getMessage(anyString(), any(), any())).thenReturn("Resource not found message");
        Mono<ApiResponse> responseMono = exceptionHandler.handleResourceNotFoundException(exception);
        StepVerifier.create(responseMono).expectNextMatches(response -> {
            assertEquals("404", response.getStatusCode());
            assertEquals("Resource not found message", response.getMessage());
            return true;
        }).verifyComplete();
    }

    @Test
    void testHandleBadRequestException() {
        BadRequestException exception = new BadRequestException("Bad request");
        when(messageSource.getMessage(anyString(), any(), any())).thenReturn("Bad request message");
        Mono<ApiResponse> responseMono = exceptionHandler.handleBadRequestException(exception);
        StepVerifier.create(responseMono).expectNextMatches(response -> {
            assertEquals("400", response.getStatusCode());
            assertEquals("Bad request message", response.getMessage());
            return true;
        }).verifyComplete();
    }

    @Test
    void testHandleMaxUploadSizeExceededException() {
        MaxUploadSizeExceededException exception = new MaxUploadSizeExceededException(5 * 1024 * 1024); // 5MB
        when(messageSource.getMessage(anyString(), any(), any())).thenReturn("File size exceeded");
        Mono<ApiResponse> responseMono = exceptionHandler.handleMaxUploadSizeExceededException(exception);

        StepVerifier.create(responseMono).expectNextMatches(response -> {
            assertEquals("413", response.getStatusCode()); // Check for HTTP status code
            assertEquals("File size exceeded", response.getMessage());
            return true;
        }).verifyComplete();
    }

}
