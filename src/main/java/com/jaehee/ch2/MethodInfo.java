package com.jaehee.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		// 1. YoilTeller 클래스의 객체를 생성
		Class clazz = Class.forName("com.jaehee.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		// 2. 모든 메소드 정보를 가져와서 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName(); // 메소드의 이름
			Parameter[] paramArr = m.getParameters(); // 매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); // 반환 타입
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

// window-compiler-java 1.8버전부터 메소드파라미터(매개변수) 이름 얻어와서 적용가능
// 방법 1. Reflection API 방법 2. Class File
//pom.xml에서 수정해줄 경우 / Maven-update project 해줘야함