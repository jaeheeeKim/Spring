package com.jaehee.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	// 메뉴바의 source로 오버라이드함
	@Override
	public void init() throws ServletException {
		// 서블릿이 초기화 될 때 자동 호출되는 메소드
		// 1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloServlet] init() is called.");
	}

	@Override // 호출될때마다 반복적으로 수행됨
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override // 뒷 정리 작업 - 서블릿이 제거(unload)될때, 단 한번만 수행됨
	public void destroy() { 
		System.out.println("[HelloServlet] destory() is called.");
	}


}
