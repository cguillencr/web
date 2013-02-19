<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
<link id="themeLink" rel="stylesheet" href="<c:url value="/resources/JQuery/css/sunny/jquery-ui-1.9.2.custom.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-1.8.3.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/JQuery/js/jquery-ui-1.9.2.custom.js"/>"></script>
<title>Ajax jquery</title>
</head>
<body>
	<input id="textoSW" class="textoSW" name="textoSW" type="text" value="Texto a procesar en el controller" />
	<input class="btProcesar" id="btProcesar" type="button" value="Procesar" />
	<div class="respuesta" id="respuesta">
	
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('input.btProcesar').click(function () {
			var textoAProcesar = $('#textoSW').val();
			var n1 = 1;			
//             $.post("/mvc-basic/ajax/add",
//             	     {  inputNumber1:  n1,
//                 inputNumber2:  textoAProcesar },
//               function(data){
//                $('div.respuesta').html(data);
//              });			
				alert("afuera");
				$.ajax({
                    type: "GET",
                    async: true,
                    url: "/mvc-basic/account",
                    success: function (data) {                    	
                      $('#respuesta').html(data);
                    }
                });

                return rt;
            });
		});
</script>
</html>