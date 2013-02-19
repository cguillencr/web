<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-1.8.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-ui-1.9.2.custom.js"/>"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="Builds"/></title>
</head>
<body>
<h3><spring:message code="LoggedUser"/> ${username}</h3>	<a href="<c:url value="/j_spring_security_logout" />" ><spring:message code="Logout"/></a>
	<h3><spring:message code="CurrentBranch"/> ${branch}</h3>	
<h3><spring:message code="Builds"/></h3>

	<table border="4">
	
			<tr>
				<th><spring:message code="Id"/></th>
				<th><spring:message code="Description"/></th>
				<th><spring:message code="Version"/></th>
			</tr>
		
			<c:forEach items="${list}" var="builds">
	    	<tr>
		    	<td>${builds.id}</td>
		    	<td><a href="${builds.description}/" >${builds.description}</a></td>
		   		<td> ${builds.version}</td>
	    	</tr>
			</c:forEach>		
	</table> 
	
	<a href="builder"><spring:message code="Create_Build"/></a>
	
  	<table border="4">
	
			<tr>
				<th><spring:message code="Id"/></th>
				<th><spring:message code="OracleUser"/></th>
				<th><spring:message code="Session"/></th>
				<th><spring:message code="MonarcaUser"/></th>
				<th><spring:message code="Bind"/></th>
				<th><spring:message code="UnBind"/></th>
			</tr>
	<c:forEach items="${listSessions}" var="sessions">
	    	<tr>
		    	<td>${sessions.id}</td>
		    	<td>${sessions.userOracle}</a></td>
		   		<td> ${sessions.session}</td>
		   		<td>${sessions.monarcaUser}</td>
		   		<td><a href="bind?session=${sessions.session}" ><spring:message code="Bind"/></a></td>
		   		<td><a href="unbind?session=${sessions.session}" ><spring:message code="UnBind"/></a></td>
	    	</tr>
			</c:forEach>		
	</table> 

</body>


</html>