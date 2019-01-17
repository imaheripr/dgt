<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang=es>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Acceso Agente</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">
    <link href="css/gly.css" rel="stylesheet">
  </head>

  <body >
	  <form  novalidate class="form-signin" method="post" action="login">
	   
	   	<h1 class="h3 mb-3 font-weight-normal">Acceso Agente</h1>
	   	
	   	  <div class="mb-1">
		    <label for="placa" >Agente</label>
		    <div class="input-group">   
		     	<input type="text" id="placa" name=placa class="form-control"  value= "${not empty placa ? placa : '444'}" >
		    </div>
	  	  </div> 
	  
		  <div class="mb-1">
		    <label for="pass" >Contraseña</label>
		    <div class="input-group">	     
		      <input type="text" class="form-control" id="pass" name="pass" placeholder="Pa$$w0rd" value="${not empty pass ? pass : '123456'}">
		    </div>
		  </div>  
	 
	      <button class="btn btn-lg  btn-block mb-3 mt-3  btn-outline-primary" type="submit">
	      Acceder
	      </button>
	   
		 <c:if test="${error != null }">
			 <div class="alert alert-primary  alert-dismissible fade show" role="alert">
		   		${error}
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    	<span aria-hidden="true">&times;</span>
			  	</button>
		  	</div>
		
		  	<!-- Bootstrap core JavaScript
		    ================================================== -->
		    <!-- Placed at the end of the document so the pages load faster -->
		    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	  
		</c:if>
	  </form>
	</body>
</html>
