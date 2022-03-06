<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<hr />
	<ul>
		<c:forEach var="str" items="${hobby }">
			<li>${str }</li>			
		</c:forEach>
	</ul>
	<hr />
	<ol>
		<li>${map.name }</li>
		<li>${map.age }</li>
		<li>${map.gender }</li>
	</ol>
</body>
</html>