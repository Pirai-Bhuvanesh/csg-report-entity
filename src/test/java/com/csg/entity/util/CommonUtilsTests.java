package com.csg.entity.util;

import com.csg.entity.payload.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommonUtilsTests {

	@Mock
	private MessageSource messageSource;

	@Test
	void testIsValidEmail_ValidEmail_ReturnsTrue() {
		String validEmail = "test@example.com";
		assertTrue(CommonUtils.isValidEmail(validEmail));
	}

	@Test
	void testIsValidEmail_InvalidEmail_ReturnsFalse() {
		String invalidEmail = "invalid-email";
		assertFalse(CommonUtils.isValidEmail(invalidEmail));
	}

	@Test
	void testIsValidEmail_NullEmail_ReturnsFalse() {
		assertFalse(CommonUtils.isValidEmail(null));
	}

	@Test
	void testIsValidIndianMobileNumber_ValidNumber_ReturnsTrue() {
		String validMobile = "+919876543210";
		assertTrue(CommonUtils.isValidIndianMobileNumber(validMobile));
	}

	@Test
	void testIsValidIndianMobileNumber_InvalidNumber_ReturnsFalse() {
		String invalidMobile = "9876543210";
		assertFalse(CommonUtils.isValidIndianMobileNumber(invalidMobile));
	}

	@Test
	void testIsValidIndianMobileNumber_NullNumber_ReturnsFalse() {
		assertFalse(CommonUtils.isValidIndianMobileNumber(null));
	}

	@Test
	void testBuildSuccessResponse() {
		ApiResponse response = new ApiResponse();
		String messageKey = "success.message";
		HttpStatus status = HttpStatus.OK;

		Locale locale = Locale.forLanguageTag("en-US");
		Mockito.when(messageSource.getMessage(messageKey, null, locale)).thenReturn("Success");

		ApiResponse result = CommonUtils.buildSuccessResponse(messageKey, messageSource, status, response);

		assertEquals("Success", result.getMessage());
		assertTrue(result.isStatus());
		assertEquals("200", result.getStatusCode());
	}

	@Test
	void testBuildFailureResponse() {
		ApiResponse response = new ApiResponse();
		String messageKey = "error.message";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		Locale locale = Locale.forLanguageTag("en-US");
		Mockito.when(messageSource.getMessage(messageKey, null, locale)).thenReturn("Error");

		ApiResponse result = CommonUtils.buildFailureResponse(messageKey, messageSource, status, response);

		assertEquals("Error", result.getMessage());
		assertFalse(result.isStatus());
		assertEquals("400", result.getStatusCode());
	}

	@Test
	void testBuildResponse_NullMessageKey() {
		ApiResponse response = new ApiResponse();
		HttpStatus status = HttpStatus.BAD_REQUEST;

		// Ensure that it handles null messageKey properly
		ApiResponse result = CommonUtils.buildFailureResponse(null, messageSource, status, response);
		assertNotNull(result);
		assertEquals("400", result.getStatusCode());
		assertFalse(result.isStatus());
	}

	@Test
	void testGetMessageInfo_NonExistentKey() {
		Locale locale = Locale.forLanguageTag("en-US");
		String messageKey = "nonexistent.key";

		// Ensure that a nonexistent key returns null or a default message
		Mockito.when(messageSource.getMessage(messageKey, null, locale)).thenReturn(null);
		String message = CommonUtils.getMessageInfo(locale, messageKey, messageSource);
		assertNull(message); // or assertEquals("default message", message) if you want a default message
	}

	@Test
	void testGenerateToken_LengthGreaterThanZero() {
		int tokenLength = 10;
		String token = CommonUtils.generateToken(tokenLength);
		assertEquals(tokenLength, token.length());
	}

	@Test
	void testGenerateToken_ValidCharacters() {
		int tokenLength = 20;
		String token = CommonUtils.generateToken(tokenLength);
		assertTrue(token.matches("^[A-Za-z0-9]+$")); // Check for valid characters
	}
}
