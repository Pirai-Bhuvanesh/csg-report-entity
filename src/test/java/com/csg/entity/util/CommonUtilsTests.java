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

	private static final String SUCCESS_MESSAGE_KEY = "success.message";
	private static final String ERROR_MESSAGE_KEY = "error.message";
	private static final Locale LOCALE_EN_US = Locale.forLanguageTag("en-US");

	@Mock
	private MessageSource messageSource;

	@Test
	void testIsValidEmail_ValidEmail() {
		assertTrue(CommonUtils.isValidEmail("test@example.com"));
	}

	@Test
	void testIsValidEmail_InvalidEmail() {
		assertFalse(CommonUtils.isValidEmail("invalid-email"));
	}

	@Test
	void testIsValidEmail_NullEmail() {
		assertFalse(CommonUtils.isValidEmail(null));
	}

	@Test
	void testIsValidIndianMobileNumber_ValidNumber() {
		assertTrue(CommonUtils.isValidIndianMobileNumber("+919876543210"));
	}

	@Test
	void testIsValidIndianMobileNumber_InvalidNumber() {
		assertFalse(CommonUtils.isValidIndianMobileNumber("9876543210"));
	}

	@Test
	void testIsValidIndianMobileNumber_NullNumber() {
		assertFalse(CommonUtils.isValidIndianMobileNumber(null));
	}

	@Test
	void testBuildSuccessResponse() {
		ApiResponse response = new ApiResponse();

		Mockito.when(messageSource.getMessage(SUCCESS_MESSAGE_KEY, null, LOCALE_EN_US)).thenReturn("Success");

		ApiResponse result = CommonUtils.buildSuccessResponse(SUCCESS_MESSAGE_KEY, messageSource, HttpStatus.OK, response);

		assertEquals("Success", result.getMessage());
		assertTrue(result.isStatus());
		assertEquals("200", result.getStatusCode());
	}

	@Test
	void testBuildFailureResponse() {
		ApiResponse response = new ApiResponse();

		Mockito.when(messageSource.getMessage(ERROR_MESSAGE_KEY, null, LOCALE_EN_US)).thenReturn("Error");

		ApiResponse result = CommonUtils.buildFailureResponse(ERROR_MESSAGE_KEY, messageSource, HttpStatus.BAD_REQUEST, response);

		assertEquals("Error", result.getMessage());
		assertFalse(result.isStatus());
		assertEquals("400", result.getStatusCode());
	}

	@Test
	void testBuildResponse_NullMessageKey() {
		ApiResponse response = new ApiResponse();

		ApiResponse result = CommonUtils.buildFailureResponse(null, messageSource, HttpStatus.BAD_REQUEST, response);
		assertNotNull(result);
		assertEquals("400", result.getStatusCode());
		assertFalse(result.isStatus());
	}

	@Test
	void testGetMessageInfo_ExistingKey() {
		String messageKey = SUCCESS_MESSAGE_KEY;

		Mockito.when(messageSource.getMessage(messageKey, null, LOCALE_EN_US)).thenReturn("Success");

		String message = CommonUtils.getMessageInfo(LOCALE_EN_US, messageKey, messageSource);
		assertEquals("Success", message);
	}

	@Test
	void testGetMessageInfo_NonExistentKey() {
		String messageKey = "nonexistent.key";

		// Simulate that the key does not exist by returning a default message or null
		Mockito.when(messageSource.getMessage(messageKey, null, LOCALE_EN_US)).thenReturn("Default message");

		String message = CommonUtils.getMessageInfo(LOCALE_EN_US, messageKey, messageSource);
		assertEquals("Default message", message);
	}

	@Test
	void testGetMessageInfo_NonExistentKey_ExceptionThrown() {
		String messageKey = "nonexistent.key";

		// Simulate that the key does not exist by throwing an exception
		Mockito.when(messageSource.getMessage(messageKey, null, LOCALE_EN_US))
				.thenThrow(new org.springframework.context.NoSuchMessageException(messageKey));

		String message = CommonUtils.getMessageInfo(LOCALE_EN_US, messageKey, messageSource);
		assertEquals("Message not found", message); // Verify the fallback message
	}

	@Test
	void testGenerateToken_LengthGreaterThanZero() {
		String token = CommonUtils.generateToken(10);
		assertEquals(10, token.length());
	}

	@Test
	void testGenerateToken_ValidCharacters() {
		String token = CommonUtils.generateToken(20);
		assertTrue(token.matches("^[A-Za-z0-9]+$")); // Check for valid characters
	}

	@Test
	void testPrivateConstructor() {
		Exception exception = assertThrows(UnsupportedOperationException.class, CommonUtils::new);
		assertEquals("Utility class cannot be instantiated", exception.getMessage());
	}
}
