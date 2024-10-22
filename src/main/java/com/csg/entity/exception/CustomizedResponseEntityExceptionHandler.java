package com.csg.entity.exception;

import com.csg.entity.payload.response.ApiResponse;
import com.csg.entity.util.CommonUtils;
import com.csg.entity.util.MessageKeyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public CustomizedResponseEntityExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // General Exception handler for unhandled exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ApiResponse> handleException(Exception ex) {
        log.error("An internal server error occurred: ", ex); // Log with full stack trace
        ApiResponse errorResponse = CommonUtils.buildFailureResponse(
                MessageKeyConstants.INTERNAL_SERVER_ERROR, messageSource,
                HttpStatus.INTERNAL_SERVER_ERROR, new ApiResponse()
        );
        return Mono.just(errorResponse); // Return Mono with error response
    }

    // Handler for ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("Resource not found: ", ex);
        ApiResponse errorResponse = CommonUtils.buildFailureResponseResourceNotFound(
                ex.getMessage(), messageSource,
                HttpStatus.NOT_FOUND, new ApiResponse()
        );
        return Mono.just(errorResponse);
    }

    // Handler for BadRequestException
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ApiResponse> handleBadRequestException(BadRequestException ex) {
        log.error("Bad request: ", ex);
        ApiResponse errorResponse = CommonUtils.buildFailureResponseBadRequest(
                ex.getMessage(), messageSource,
                HttpStatus.BAD_REQUEST, new ApiResponse()
        );
        return Mono.just(errorResponse);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ApiResponse> handleFallbackException(Throwable ex) {
        log.error("Unexpected error occurred: ", ex);
        ApiResponse errorResponse = CommonUtils.buildFailureResponse(
                MessageKeyConstants.INTERNAL_SERVER_ERROR, messageSource,
                HttpStatus.INTERNAL_SERVER_ERROR, new ApiResponse()
        );
        return Mono.just(errorResponse);
    }
}
