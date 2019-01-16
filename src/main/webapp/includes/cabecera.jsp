<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>DGT ${sessionScope.agente_logeado.apellido} </title> 
    <base href="${pageContext.request.contextPath}/">
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css">

<!-- FONT AWESOME -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<!--  nuestro css -->
	<link rel="stylesheet" href="css/principal.css">
</head>
 
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark  bg-dark">
	<a class="navbar-brand  mr-auto" href="${pageContext.request.contextPath}/privado/principal"><i class="fas fa-home fa-2x"></i></a>
	
	<ul class="navbar-nav float-right">
       <li><a href="logout" class="badge badge-info mr-3 font-weight-normal">Logout</a></li>
    </ul>
	
	<ul class="navbar-nav float-right">
	<li><span class="badge badge-info mr-3 font-weight-normal">${sessionScope.agente_logeado.apellido}</span></li>
	</ul>      
	
</nav>

</header>

