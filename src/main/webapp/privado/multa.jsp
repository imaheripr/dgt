<%@ include file="../includes/cabecera.jsp" %> 	
<main role="main" class="container mt-5">	

<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<form action="privado/multa" method="post">	

	<input type="hidden" name="id_agente" value="${agente_logeado.id}">
	<input type="hidden" name="id_coche" value="${coche.id}">
	<input type="hidden" name="operacion" value="1">
	
	<div class="form-group">
	<label for="matricula">Matricula seleccionada</label>
	<input readonly  type="text" name="matricula" value="${coche.matricula }" class="form-control" >			    
	</div>
	
	<div class="form-group">
	<label for="importe">Importe</label>
	<input type="text" name="importe" placeholder="Introduce un valor numerico valido" value="${importe!=null ? importe : ''}" class="form-control" autofocus>			    
	</div>	
		
	                                                                          
	<div class="form-group">
	<label for="concepto">Concepto  <span id="contadorLabel">(0/250)</span></label>
	 <br>
	<textarea name="concepto"  class="form-control" placeholder="minimo 10 caracteres maximo 150"  id="concepto" cols="30" rows="10" >${concepto!=null ? concepto : ''}</textarea>		    
	</div>	
	

	<div  class="form-group">								
	<button type="submit" class="btn btn-primary btn-block">MULTAR</button>
	</div>	
	
</form>

	
</main>				
<%@ include file="../includes/footer.jsp"  %>



