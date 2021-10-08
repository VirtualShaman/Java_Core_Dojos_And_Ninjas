<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<h1>All Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>					
				<th>Age</th>
				<th>Dojo</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="i" items="${ninjas}" >
				<tr>
					<td><c:out value="${i.firstName}"></c:out></td>
					<td><c:out value="${i.lastName}"></c:out></td>
					<td><c:out value="${i.age}"></c:out></td>
					<td><a href="/oneDojo/${i.dojo.id }"><c:out value="${i.dojo.name}"></c:out></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/createDojo">Create A Dojo</a><a href="/createNinja">Create A Ninja</a>
</body>
</html>