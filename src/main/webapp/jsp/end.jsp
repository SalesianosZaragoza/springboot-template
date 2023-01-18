<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>end</title>
</head>
<body>
<div>usted ha terminado de trabajar</div>
<div><c:out value="${student.name}"></c:out></div>
<div>${student.name}</div>
<div><c:out value="${student.surname}"></c:out></div>
</body>
</html>