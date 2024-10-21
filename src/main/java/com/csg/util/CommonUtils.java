package com.csg.util;

import com.csg.payload.response.ApiResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom random = new SecureRandom();
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	// Compiling the regex
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}
	private static final String MOBILE_NUMBER_REGEX = "^\\+91[6-9][0-9]{9}$";

	// Compiling the regex
	private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile(MOBILE_NUMBER_REGEX);

	public static boolean isValidIndianMobileNumber(String mobileNumber) {
		if (mobileNumber == null) {
			return false;
		}
		Matcher matcher = MOBILE_NUMBER_PATTERN.matcher(mobileNumber);
		return matcher.matches();
	}

	public static <T extends ApiResponse> T buildSuccessResponse(String messageKey, MessageSource messageSource,
																 HttpStatus httpStatus, T response) {
		response = buildResponse(messageKey, MessageKeyConstants.ERROR_CODE_200, messageSource, response);
		response.setStatus(true);
		response.setStatusCode(String.valueOf(httpStatus.value()));
		return response;
	}

	public static <T extends ApiResponse> T buildFailureResponse(String messageKey, MessageSource messageSource,HttpStatus httpStatus, T response) {
		response = buildResponse(messageKey, MessageKeyConstants.ERROR_CODE_500, messageSource, response);
		response.setStatus(false);
		response.setStatusCode(String.valueOf(httpStatus.value()));
		return response;
	}

	public static <T extends ApiResponse> T buildFailureResponseBadRequest(String messageKey, MessageSource messageSource,HttpStatus httpStatus, T response) {
		response = buildResponse(messageKey, MessageKeyConstants.ERROR_CODE_400, messageSource, response);
		response.setStatus(false);
		response.setStatusCode(String.valueOf(httpStatus.value()));
		return response;
	}


	public static <T extends ApiResponse> T buildFailureResponseResourceNotFound(String messageKey, MessageSource messageSource,HttpStatus httpStatus, T response) {
		response = buildResponse(messageKey, MessageKeyConstants.ERROR_CODE_404, messageSource, response);
		response.setStatus(false);
		response.setStatusCode(String.valueOf(httpStatus.value()));
		return response;
	}

	private static <T extends ApiResponse> T buildResponse(String messageKey, String responseCodeKey,
			MessageSource messageSource, T response) {
		Locale locale = getLocaly();
		response.setMessage(getMessageInfo(locale, messageKey, messageSource));
		response.setStatusCode(getMessageInfo(locale, responseCodeKey, messageSource));
		return response;
	}

	public static String getMessageInfo(Locale locale, String messageKey, MessageSource messageSource) {
		LocalizationMessageUtil instance = LocalizationMessageUtil.getInstance();
		return instance.getMessageInfo(locale, messageKey, messageSource);
	}

	public static Locale getLocaly() {
		Locale locale = LocaleContextHolder.getLocale();
		locale = new Locale(CsgConstants.ENGLISH, CsgConstants.COUNTRY);
		return locale;
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
