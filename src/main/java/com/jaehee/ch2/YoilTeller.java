package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Local Program
/*// 년월일을 입력하면 요일을 알려주는 프로그램
public class YoilTeller {
	
	//메인메소드의 매개변수 args로 스트링 문자열로 값을 받은다음에
	public static void main(String[] args) {
		//그 값을 year, month, day에 저장한 후 문자열이니까 숫자로 바꿔줌
		// 1. 입력
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 날짜 세팅하고 요일 알아내면 
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, 3:화요일...
		char yoil = "일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		System.out.println(yoil + "요일입니다.");
		
	}

}*/

// 원격 Program(response 객체를 이용해서 실행하는 방법)
//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 날짜 세팅하고 요일 알아내면 
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, 3:화요일...
		char yoil = "일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		response.setContentType("text/html"); // 브라우저는 내가 보내는 내용이 텍스트인지 모름
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response 객체에서 브라우저로의 출력 스트림을 얻는다.
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("</body>");
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
//		out.println("</body>");
//		out.println("</html>");
		
	}

}
