package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl+shift+O 는 자동 import
public class TwoDice { // 실행 할 때마다 결과가 변함 (동적 리소스-프로그램,스트리밍) // 이미지는 정적 리소스(*.js, *.css, *.html)
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1; // 랜덤 다이스 이미지1
		int idx2 = (int)(Math.random()*6)+1; // Toggle BreakPoint(중단점) 설정함 > debug on server실행
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");		
		out.print("</body>");
		out.print("</html>");

	}
}

/* 2023.12.18 월요일
 * ch2 04.HTTP 요청과 응답 - 예제
 * 브라우저로 요청을 하면 서버는 응답하여 프로그램 실행
 * 결과는 html으로 나옴(text문서로)
 * 브라우저가 출력 내용을 해석해서 보여주는거임
 * 3. 클라이언트와 서버
 * 클라이언트(client): 서비스를 요청하는 애플리케이션
 * 서버(server): 서비스를 제공하는 애플리케이션
 * 
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 
 * ch2 05.클라이언트와 서버
 * 브라우저를 이용해서 요청하면 톰캣이 객체를 생성해서 브라우저 정보를 request객체에 담아서 main메소드를 실행
 * Iterator(new) = Enumeration(old)
 * ?year=2021&year=2022&year=2023 처럼 쿼리스트링(QueryString) 이름이 다 같은 경우 String[] yearArr = request.getParameterValues("year"); 로 받을 수 있음
 * 
 * 1. 클라이언트와 서버
 * 클라이언트(client): 서비스를 요청하는 애플리케이션
 * 서버(server): 서비스를 제공하는 애플리케이션 
 * 2. 서버의 종류
 * Email server, File server, Web server
 * 3. 서버의 포트
 * 1대의 PC에 여러 서버가 존재하기때문에 이때 필요한 것이 바로 포트번호임 111.22.33.44:25(email server) 111.22.33.44:22(file server) 111.22.33.44:80(web server) 
 * 80 포트번호는 생략가능
 * 바인딩 되어있는 한 서버에 한 포트번호만 연결되어있음(서버 프로그램을 실행할때는 특정 포트하고 연결되어서 바인딩되어 요청을 기다린 상태가 리스닝 상태가 되는것)
 * 0~1023은 이미 예약된 포트번호 / 그 외의 65535개의 포트번호 사용가능함
 * 4. 웹 애플리케이션 서버(WAS)란?
 * WAS(Web Applicaion Server): 웹 애플리케이션을 서비스하는 서버(서버에 프로그램을 설치하고 클라이언트가 이 프로그램을 사용할 수 있게 해줌)
 * 클라이언트에서 원격프로그램 호출하면 tomcat 같은 WAS가 실행결과를 전송해줌 
 * 5. tomcat의 내부 구조
 * servlet은 작은 서버 프로그램임
 **** 끝 부분에 tomcat 실행 과정 잘 설명해주심
 *
 *ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 *
 * 6. 설정 파일 - server.xml, web.xml
 * <원격프로그램> ①서블릿 등록(@Controller) ②URL연결(@RequestMapping)
 *
 */
