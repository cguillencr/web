<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link id="themeLink" rel="stylesheet" href="<c:url value="/resources/JQuery/css/sunny/jquery-ui-1.9.2.custom.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-1.8.3.js"/>"> </script>
	<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-ui-1.9.2.custom.js"/>"> </script>
	<link rel="stylesheet" href="<c:url value="/resources/JQuery/prettyPrinter/style.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/JQuery/prettyPrinter/tooltip.js"/>"></script>

	<title>Builder</title>
</head>
<body>
	<form:form method="get" action="builder/insert" commandName="build">
		<form:label path="branch.project.description">
			<spring:message code="Project" />:
        </form:label>
        <form:input path="branch.project.description" type="text" />
        <br>
		<form:label path="branch.description">
			<spring:message code="Branch" />:
        </form:label>
		<form:input path="branch.description" type="text" />
		<br>
		<form:label path="description">
			<spring:message code="Build" />:
        </form:label>
		<form:input path="description" type="text"></form:input>
		<br>
		<input type="submit" value="<spring:message code="Build_Now" />"/>
		<br>
	</form:form>

</body>
</html>