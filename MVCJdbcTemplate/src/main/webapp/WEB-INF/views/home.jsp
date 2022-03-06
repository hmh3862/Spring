<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style type="text/css">
		table { width: 600px; margin: auto; }
		th { background-color: silver; border: 1px solid gray; padding: 5px;}
		td { border: 1px solid gray; padding: 5px;}
	</style>
</head>
<body>
	<h1>서버시간 : ${serverTime }</h1>
	<table border="1">
		<tr>
			<td colspan="5" style="border: none;">
				<form action="insert" method="post">
 					<input type="text" name="firstName" required="required" placeholder="이름"/>
 					<input type="text" name="lastName" required="required" placeholder="성" size="5"/>
 					<input type="number" name="age" required="required" placeholder="나이" />
 					<input type="submit" value="저장" />
				</form>
			</td>
		</tr>
		<tr>
			<th>id</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>age</th>
			<th>del</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.id }</td>			
				<td>${vo.firstName }</td>			
				<td>${vo.lastName }</td>			
				<td>${vo.age }</td>			
				<td> <button onclick="location.href='delete?id=${vo.id}'">삭제</button> </td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>
