package com.csg.entity.util;

import com.csg.entity.payload.response.ApiResponse;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.regex.Pattern;

public class CommonUtils {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom random = new SecureRandom();
	private static final String EMAIL_REGEX = "^[\\w&*-]+(?:\\.[\\w&*-]+)*@[\\w-]+(?:\\.[\\w-]+)+$";
	private static final String MOBILE_NUMBER_REGEX = "^\\+91[6-9]\\d{9}$";

	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile(MOBILE_NUMBER_REGEX);

	// Private constructor to prevent instantiation
	CommonUtils() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	public static boolean isValidEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}

	public static boolean isValidIndianMobileNumber(String mobileNumber) {
		return mobileNumber != null && MOBILE_NUMBER_PATTERN.matcher(mobileNumber).matches();
	}

	public static <T extends ApiResponse> T buildResponse(String messageKey, MessageSource messageSource,
														  HttpStatus httpStatus, T response, boolean isSuccess) {
		Locale locale = getLocaly();
		response.setMessage(getMessageInfo(locale, messageKey, messageSource));
		response.setStatus(isSuccess);
		response.setStatusCode(String.valueOf(httpStatus.value()));
		return response;
	}

	public static <T extends ApiResponse> T buildSuccessResponse(String messageKey, MessageSource messageSource,
																 HttpStatus httpStatus, T response) {
		return buildResponse(messageKey, messageSource, httpStatus, response, true);
	}

	public static <T extends ApiResponse> T buildFailureResponse(String messageKey, MessageSource messageSource,
																 HttpStatus httpStatus, T response) {
		return buildResponse(messageKey, messageSource, httpStatus, response, false);
	}

	public static <T extends ApiResponse> T buildFailureResponseBadRequest(String messageKey, MessageSource messageSource,
																		   HttpStatus httpStatus, T response) {
		return buildFailureResponse(messageKey, messageSource, httpStatus, response);
	}

	public static <T extends ApiResponse> T buildFailureResponseResourceNotFound(String messageKey, MessageSource messageSource,
																				 HttpStatus httpStatus, T response) {
		return buildFailureResponse(messageKey, messageSource, httpStatus, response);
	}

	public static String getMessageInfo(Locale locale, String messageKey, MessageSource messageSource) {
		LocalizationMessageUtil instance = LocalizationMessageUtil.getInstance();
		try {
			return instance.getMessageInfo(locale, messageKey, messageSource);
		} catch (Exception e) {
			// Log the exception (optional) and return a fallback message
			return "Message not found"; // Or any appropriate default value
		}
	}


	public static Locale getLocaly() {
		return new Locale.Builder()
				.setLanguage(CsgConstants.ENGLISH)
				.setRegion(CsgConstants.COUNTRY)
				.build();
	}


	public static String generateToken(int tokenLength) {
		StringBuilder token = new StringBuilder(tokenLength);
		for (int i = 0; i < tokenLength; i++) {
			int index = random.nextInt(CHARACTERS.length());
			token.append(CHARACTERS.charAt(index));
		}
		return token.toString();
	}
}
