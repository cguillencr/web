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
<title><spring:message code="Projects"/></title>
</head>
<body>
<h3><spring:message code="LoggedUser"/> ${username} </h3><a href="<c:url value="/j_spring_security_logout" />" ><spring:message code="Logout"/></a>
<h3><spring:message code="Projects"/></h3>

<table border="4">
	<tr>
		<th><spring:message code="Id"/></th>
		<th><spring:message code="Description"/></th>
		<th><spring:message code="CreatedOn"/></th>
	</tr>

		<c:forEach items="${list}" var="projects">
    	<tr>
	    	<td> ${projects.id}</td>				
	    	<td><a href="${projects.description}/" >${projects.description}</a></td>	    	
	   		<td>${projects.createdOn}</td>
    	</tr>
		</c:forEach>	
</table>


</body>
</html>