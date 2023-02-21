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
	<form:form action="searchTry" method="get" modelAttribute="info">
		<span>Num intento a buscar:</span>
		<form:input path="numJugada" type="text" name="wordToPlay"/>
		<input type="submit"/>
	</form:form>
	<br/>
	${info.message}
	
	
</body>
</html>