<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!doctype html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm   navbar-dark bg-primary " >  <!-- kitar navbar para cambiar color y cambiar palabra secondary por otra danger es rojo por ejemplo mirar en bootstrap el problema es que deja de funcionar los colores hover y focus del css extra-->	
		  <button class= "navbar-expand-sm   navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation"></button>
		
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		    	<ul class="navbar-nav  mr-auto mt-2 mt-lg-0">
   
				 <h5>Usuario conectado:</h5>  
				 <h3><span class="badge badge-light mr-3">${agente_logeado.apellido}</span></h3>
			
		  </div>
		</nav>
	</header>
</body>	
</html>
