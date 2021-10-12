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
		<h1><c:out value="${ dojo.name }"/> Location Ninjas</h1>
		<table class="table table-secondary table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ dojo.ninjas }">
					<tr>
						<td> <c:out value="${ ninja.firstName }"/> </td>
						<td> <c:out value="${ ninja.lastName }"/> </td>
						<td> <c:out value="${ ninja.age }"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>