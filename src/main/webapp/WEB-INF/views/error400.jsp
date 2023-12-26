<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%>
									<!-- isErrorPage설정해주면 자동으로 500에러만 뜨고, Controller에서 Exception담은Model 안받아도 됨-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error400.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
발생한 예외 : ${pageContext.exception}<br>
예외 메시지 : ${pageContext.exception.message}<br>
<ol> <!-- ordered list 태그 -->
<c:forEach items="${pageContext.exception.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>