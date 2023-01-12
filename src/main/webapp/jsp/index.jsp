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
<h1>hola mundo</h1>
	<form:form action="addStudentForm" method="post" modelAttribute="estudiante">
		<span>Nombre:</span>
		<form:input path="name" type="text" name="name"/>
		<span>Apellidos:</span>
		<form:input path="surname" type="text" name="surname"/>
		<input type="submit"/>
	</form:form>
</body>
</html>