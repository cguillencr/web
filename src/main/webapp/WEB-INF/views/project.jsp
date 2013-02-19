<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>

<form action="buildsByProject.jsp" method="get" name="sendData">
<table border="4">
	<tr>
		<th>Project ID</th>
		<th>Description</th>
		<th>Created On</th>
	</tr>

		<c:forEach items="${list}" var="projects">
    	<tr>
	    	<td><a href="../buildController/${projects.id}" > ${projects.id}</a></td>
	    	<td>${projects.description}</td>
	   		<td>${projects.createdOn}</td>
    	</tr>
		</c:forEach>
	
</table>
</form>


</body>
</html>