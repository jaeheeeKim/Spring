package com.jaehee.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	// �޴����� source�� �������̵���
	@Override
	public void init() throws ServletException {
		// ������ �ʱ�ȭ �� �� �ڵ� ȣ��Ǵ� �޼ҵ�
		// 1. ������ �ʱ�ȭ �۾� ���
		System.out.println("[HelloServlet] init() is called.");
	}

	@Override // ȣ��ɶ����� �ݺ������� �����
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. �Է�
		// 2. ó��
		// 3. ���
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override // �� ���� �۾� - ������ ����(unload)�ɶ�, �� �ѹ��� �����
	public void destroy() { 
		System.out.println("[HelloServlet] destory() is called.");
	}


}
