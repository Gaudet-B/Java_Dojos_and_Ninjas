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
		<div class="container p-4">
			<h1 class="display-4 mb-3">New Ninja</h1>
			<form:form action="/ninjas/create" method="post" modelAttribute="ninja" class="form">
				<div class="d-flex flex-row justify-content-between my-2">
					<form:label path="dojo" class="form-label">Dojo</form:label>
					<form:select path="dojo" class="form-select" style="max-width: 70%;">
						<c:forEach var="dojo" items="${ dojos }">
							<form:option value="${ dojo.id }">${ dojo.name } Location</form:option>			
						</c:forEach>
					</form:select>
				</div>
				<div class="d-flex flex-row justify-content-between my-2">
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<form:input path="firstName" class="form-control" style="max-width: 70%;"/>
				</div>
				<div class="d-flex flex-row justify-content-between my-2">
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<form:input path="lastName" class="form-control" style="max-width: 70%;"/>
				</div>
				<div class="d-flex flex-row justify-content-between my-2">
					<form:label path="age" class="form-label">Age:</form:label>
					<form:input path="age" class="form-control" style="max-width: 70%;"/>
				</div>
				<input type="submit" class="btn btn-outline-secondary" value="Create"/>
			</form:form>
		</div>
	</body>
</html>