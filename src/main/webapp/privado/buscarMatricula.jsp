<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container mt-5">	

<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong>Holy guacamole!</strong> ${mensaje }
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>	

<form action="privado/buscar" method="post">		
	<div class="form-group">
	<label for="buscar">Buscar Matricula</label>
	<input type="text" name="buscar" value="3548MKZ" class="form-control">			    
	</div>	
	
	<div  class="form-group">								
	<button type="submit" class="btn btn-primary btn-block">BUSCAR</button>
	</div>	
	
</form>

	
</main>				
<%@ include file="../includes/footer.jsp"  %>