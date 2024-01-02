package com.jaehee.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {	
	// 2. URL과 메소트 연결
	@RequestMapping("/hello")
	public void main() { // 인스턴스 메소드
		System.out.println("Hello");
	}
	
	int iv = 10;
	static int cv = 20;
	
	// tomcat이 객체 생성 후 메소드 호출
	public void main2() { // instance 메소드 - iv, cv 둘 다 사용가능
		System.out.println(cv); // OK
		System.out.println(iv); // OK
	}
	public static void main3() { // static 메소드 - cv만 사용가능
		System.out.println(cv);	// OK
//		System.out.println(iv); // ERROR
	}
	
	/* 주석처리 안하면 500 servlet 에러남
	// Reflection API 예제 - Main.java
	@RequestMapping("/hello")
	private void main4() {
		System.out.println("hello");
	}
	*/
}
