<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>날짜 1 : ${now }</h2>	
	<hr />
	날짜 2 : <fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일(E) hh:mm:Ss"/>	
</body>
</html>