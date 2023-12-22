package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Local Program
/*// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
public class YoilTeller {
	
	//���θ޼ҵ��� �Ű����� args�� ��Ʈ�� ���ڿ��� ���� ����������
	public static void main(String[] args) {
		//�� ���� year, month, day�� ������ �� ���ڿ��̴ϱ� ���ڷ� �ٲ���
		// 1. �Է�
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// ��¥ �����ϰ� ���� �˾Ƴ��� 
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������, 3:ȭ����...
		char yoil = "�Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		System.out.println(year + "�� " + month + "�� " + day + "���� ");
		System.out.println(yoil + "�����Դϴ�.");
		
	}

}*/

// ���� Program(response ��ü�� �̿��ؼ� �����ϴ� ���)
//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// ��¥ �����ϰ� ���� �˾Ƴ��� 
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������, 3:ȭ����...
		char yoil = "�Ͽ�ȭ�������".charAt(dayOfWeek);
		
		// 3. ���
		response.setContentType("text/html"); // �������� ���� ������ ������ �ؽ�Ʈ���� ��
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response ��ü���� ���������� ��� ��Ʈ���� ��´�.
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("</body>");
		out.println(year + "�� " + month + "�� " + day + "���� ");
		out.println(yoil + "�����Դϴ�.");
//		out.println("</body>");
//		out.println("</html>");
		
	}

}
