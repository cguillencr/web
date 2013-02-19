<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<div id="coverageTable">
		instances
	</div>
	<div id="coverageActions">
		actions
		 <c:forEach items="${activities}" var="activity">
	  		<li>${activity.name}</li>    
		</c:forEach>
	</div>