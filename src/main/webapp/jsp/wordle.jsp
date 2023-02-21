<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="play" method="post" modelAttribute="info">
		<span>Palabra:</span>
		<form:input path="wordToPlay" type="text" name="wordToPlay"/>
		<input type="submit"/>
	</form:form>
	<br/>
	${info.message}
	
	${info.answer}
	
</body>
</html>