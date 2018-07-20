<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question and answers</title>
</head>
<body>
	<h1>${question.ques}</h1>
	<h3>Tags:</h3>
	
	<c:forEach items="${question.tags}" var="tag" varStatus="loop">
	
	<c:out value="${tag.tag},"/>
	</c:forEach>
	
	<h4>Answers</h4>
	
	<ul>
		<c:forEach items="${question.answers}" var="answer" varStatus="loop">
		<li>${answer.ans}<li/>
		</c:forEach>
	</ul>
	
	<form:form method="POST" action="/answer/${question.id}" modelAttribute="addanswer">
		<form:label path="ans">Answer:
		<form:textarea path="ans" />
		<form:errors path="ans"/>
		</form:label><br>
		<input type="submit" value="Answer It"/>
		 <input type="hidden" name="question" value="${question.id}">
	</form:form>

</body>
</html>