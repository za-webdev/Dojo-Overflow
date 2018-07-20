<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>questions Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	
	<c:forEach items="${questions}" var="question">
		<a href="/show/${question.id}">${question.ques}</a>
		<ul>
		<c:forEach items="${question.tags}" var="tags">
			<li>${tags.tag}</li>
		</c:forEach>
		</ul>
	</c:forEach><br>
	
	<a href="/new">New Question</a>
</body>
</html>