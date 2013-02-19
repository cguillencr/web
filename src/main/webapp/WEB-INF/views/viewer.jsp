<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link id="themeLink" rel="stylesheet" href="<c:url value="/resources/JQuery/css/sunny/jquery-ui-1.9.2.custom.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-1.8.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-ui-1.9.2.custom.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/resources/JQuery/prettyPrinter/style.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JQuery/prettyPrinter/tooltip.js"/>"></script>

<title>Code Viewer</title>
</head>
<body>
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	<div id="codePanel">
		
	</div>
	<div id="topicTabs">
	  <ul>
	 	 <c:forEach items="${topics}" var="topic">
	  		<li><a href="${pageContext.request.contextPath}/${topic.key}">${topic.name}</a></li>    
		</c:forEach>
	  </ul>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		

		$.ajax({
            type: "GET",
            async: true,
            url: "${pageContext.request.contextPath}/ajax/<c:out value="${pageCode}"/>",
            success: function (data) {   
           		$('#codePanel').height(450);
               	$('#codePanel').html(data); 	    	 	
              	$('#section48').removeAttr("class");
              	$('#section49').attr("style","color:#FF0000;font-weight:bold;font-style:italic;");
              	$('#section48').attr("style","color:#FF0085;font-weight:bold;font-style:italic;");
              	
            }
        });	   

	    $( "#topicTabs" ).tabs({
   			beforeLoad: function( event, ui ) {
		        ui.jqXHR.error(function() {
	          		ui.panel.html(
		            "Couldn't load this tab. We'll try to fix this as soon as possible. " );
		        });
	      	}
	    });
	});
</script>
</html>