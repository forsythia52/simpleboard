package com.board.config;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FailureHandler extends SimpleUrlAuthenticationFailureHandler {

	/*
	 * HttpServletRequest : request 정보 HttpServletResponse : Response에 대해 설정할 수 있는
	 * 변수 AuthenticationException : 로그인 실패 시 예외에 대한 정보
	 */

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String errorMessage;

		if (exception instanceof BadCredentialsException) { // 비밀번호 불일치
			errorMessage = "사원번호 또는 비밀번호가 맞지 않습니다.";
		} else if (exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "내부 시스템 문제로 로그인 요청을 처리할 수 없습니다.";
		} else if (exception instanceof AuthenticationCredentialsNotFoundException) {
			errorMessage = "인증 요청이 거부되었습니다.";
		} else {
			errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다.";
		}

		errorMessage = URLEncoder.encode(errorMessage, "UTF-8"); /* 한글 인코딩 깨진 문제 방지 */
		setDefaultFailureUrl("/login?error=true&exception=" + errorMessage);
		super.onAuthenticationFailure(request, response, exception);
	}
}