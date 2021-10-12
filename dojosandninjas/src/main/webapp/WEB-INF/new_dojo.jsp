<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<meta charset="ISO-8859-1">
		<title> Dojos & Ninjas </title>
	</head>
	<body>
		<h1>New Dojo</h1>
		<form:form action="/dojos/create" modelAttribute="dojo" method="post" class="form">
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<input type="submit" class="btn-btn-secondary" value="Create"/>
		</form:form>
	</body>
</html>