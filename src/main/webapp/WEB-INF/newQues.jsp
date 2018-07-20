<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Question</title>
</head>
<body>
	<form:form method="POST" action="create" modelAttribute="addQuestion">
	    <form:label path="ques">Add a Question:
		    <form:input path="ques"/>
		    <form:errors path="ques"/>
	    </form:label><br>
	    
	   tags:<input type="text" name="my_tag">	    
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>

