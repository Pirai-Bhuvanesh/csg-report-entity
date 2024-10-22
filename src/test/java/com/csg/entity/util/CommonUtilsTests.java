package com.csg.entity.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csg.entity.payload.response.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CommonUtilsTests {

	@InjectMocks
	private CommonUtils commonUtils;

	@Mock
	private MessageSource messageSource;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks before each test
	}

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	@Test
	void verifyComplete() {
		int tokenLength = 10;
		String token = commonUtils.generateToken(tokenLength);
		System.out.println("Generated Token: " + token); // Debugging statement to print the token

		assertNotNull(token, "Generated token should not be null");
		assertEquals(tokenLength, token.length(), "Generated token should have the correct length");

		for (char c : token.toCharArray()) {
			assertTrue(CHARACTERS.indexOf(c) >= 0, "Token contains an invalid character: " + c);
		}
	}

	@Test
	void testIsValidIndianMobileNumber() {
		assertTrue(commonUtils.isValidIndianMobileNumber("+919876543210")); // Valid
		assertFalse(commonUtils.isValidIndianMobileNumber("9876543210")); // Missing country code
		assertFalse(commonUtils.isValidIndianMobileNumber("+91987654321")); // Less than 10 digits
		assertFalse(commonUtils.isValidIndianMobileNumber("+9198765432100")); // More than 10 digits
		assertFalse(commonUtils.isValidIndianMobileNumber("+91123456789")); // Starts with 1
		assertFalse(commonUtils.isValidIndianMobileNumber(null)); // Null input
		assertFalse(commonUtils.isValidIndianMobileNumber("+91abcdefg")); // Non-numeric characters
	}

	@Test
	void testIsValidEmail() {
		assertTrue(commonUtils.isValidEmail("test@example.com")); // Valid email
		assertFalse(commonUtils.isValidEmail("test@example")); // Missing TLD
		assertFalse(commonUtils.isValidEmail("test@.com")); // Invalid format
		assertFalse(commonUtils.isValidEmail("test@com.")); // Invalid format
		assertFalse(commonUtils.isValidEmail("test@com")); // Missing dot in domain
		assertFalse(commonUtils.isValidEmail(null)); // Null input
	}

	@Test
	void testBuildSuccessResponse() {
		String messageKey = "success.message";
		String responseCodeKey = MessageKeyConstants.ERROR_CODE_200;
		HttpStatus httpStatus = HttpStatus.OK;

		ApiResponse response = new ApiResponse();

		when(messageSource.getMessage(eq(messageKey), any(), any())).thenReturn("Success Message");
		when(messageSource.getMessage(eq(responseCodeKey), any(), any())).thenReturn("200");

		ApiResponse result = CommonUtils.buildSuccessResponse(messageKey, messageSource, httpStatus, response);

		assertEquals(true, result.getStatus());
		assertEquals("200", result.getStatusCode());
		verify(messageSource, times(1)).getMessage(eq(messageKey), any(), any());
		verify(messageSource, times(1)).getMessage(eq(responseCodeKey), any(), any());
	}

	@Test
	void testBuildFailureResponse() {
		String messageKey = "error.message";
		String responseCodeKey = MessageKeyConstants.ERROR_CODE_500;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		ApiResponse response = new ApiResponse();

		when(messageSource.getMessage(eq(messageKey), any(), any())).thenReturn("Error Message");
		when(messageSource.getMessage(eq(responseCodeKey), any(), any())).thenReturn("500");

		ApiResponse result = CommonUtils.buildFailureResponse(messageKey, messageSource, httpStatus, response);

		assertEquals(false, result.getStatus());
		assertEquals("500", result.getStatusCode());
		verify(messageSource, times(1)).getMessage(eq(messageKey), any(), any());
		verify(messageSource, times(1)).getMessage(eq(responseCodeKey), any(), any());
	}

	@Test
	void testBuildFailureResponseBadRequest() {
		String messageKey = "error.badRequest";
		String responseCodeKey = MessageKeyConstants.ERROR_CODE_400;
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		ApiResponse response = new ApiResponse();

		when(messageSource.getMessage(eq(messageKey), any(), any())).thenReturn("Bad Request Error");
		when(messageSource.getMessage(eq(responseCodeKey), any(), any())).thenReturn("400");

		ApiResponse result = CommonUtils.buildFailureResponseBadRequest(messageKey, messageSource, httpStatus, response);

		assertEquals(false, result.getStatus());
		assertEquals("400", result.getStatusCode());
		verify(messageSource, times(1)).getMessage(eq(messageKey), any(), any());
		verify(messageSource, times(1)).getMessage(eq(responseCodeKey), any(), any());
	}

	@Test
	void testBuildFailureResponseResourceNotFound() {
		String messageKey = "error.resourceNotFound";
		String responseCodeKey = MessageKeyConstants.ERROR_CODE_404;
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		ApiResponse response = new ApiResponse();

		when(messageSource.getMessage(eq(messageKey), any(), any())).thenReturn("Resource Not Found");
		when(messageSource.getMessage(eq(responseCodeKey), any(), any())).thenReturn("404");

		ApiResponse result = CommonUtils.buildFailureResponseResourceNotFound(messageKey, messageSource, httpStatus, response);

		assertEquals(false, result.getStatus());
		assertEquals("404", result.getStatusCode());
		verify(messageSource, times(1)).getMessage(eq(messageKey), any(), any());
		verify(messageSource, times(1)).getMessage(eq(responseCodeKey), any(), any());
	}
}
