package com.jaehee.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {	
	// 2. URL�� �޼�Ʈ ����
	@RequestMapping("/hello")
	public void main() { // �ν��Ͻ� �޼ҵ�
		System.out.println("Hello");
	}
	
	int iv = 10;
	static int cv = 20;
	
	// tomcat�� ��ü ���� �� �޼ҵ� ȣ��
	public void main2() { // instance �޼ҵ� - iv, cv �� �� ��밡��
		System.out.println(cv); // OK
		System.out.println(iv); // OK
	}
	public static void main3() { // static �޼ҵ� - cv�� ��밡��
		System.out.println(cv);	// OK
//		System.out.println(iv); // ERROR
	}
	
	/* �ּ�ó�� ���ϸ� 500 servlet ������
	// Reflection API ���� - Main.java
	@RequestMapping("/hello")
	private void main4() {
		System.out.println("hello");
	}
	*/
}
