<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="Login"/></title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;


}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="themeLink" rel="stylesheet" href="<c:url value="/resources/JQuery/css/sunny/jquery-ui-1.9.2.custom.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-1.8.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-ui-1.9.2.custom.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/resources/JQuery/prettyPrinter/style.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JQuery/prettyPrinter/tooltip.js"/>"></script>
</head>

<body onload='document.f.j_username.focus();'>
		<h3><spring:message code="Login"/></h3>
			
	<c:if test="${not empty error}">
		<div class="errorblock">
			<spring:message code="LoginFailed"/>
		</div>
    </c:if>
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td><spring:message code="User"/></td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td><spring:message code="Password"/>:</td>
				<td><input type='password' name='j_password'/></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="_spring_security_remember_me" id="rememberMe" /><spring:message code="Remember"/></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
			</tr>
		</table>
 
	</form>
</body>
</html>



