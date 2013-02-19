<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Builds by project</title>
</head>
<body>
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>

	<table border="4">
	
		<tr>
			<th>Build ID</th>
			<th>Description</th>
			<th>Created On</th>
		</tr>
		
			<c:forEach items="${list}" var="builds">
	    	<tr>
		    	<td>${builds.id}</td>
		    	<td><a href="${builds.description}/" >${builds.description}</a></td>
		   		<td> ${builds.createdOn}</td>
	    	</tr>
			</c:forEach>
		
	</table>
 <a href="builder"><spring:message code="Create_Build"/></a>
</body>
</html>