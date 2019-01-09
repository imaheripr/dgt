<%@ include file="../includes/cabecera.jsp" %> 	
<main role="main" class="container mt-5">	



<h1></h1>
<form action="privado/multa" method="post">	

	<input type="hidden" name="id_agente" value="${agente_logeado.id}">
	<input type="hidden" name="id_coche" value="${coche.id}">
	<input type="hidden" name="operacion" value="1">
	
	<div class="form-group">
	<label for="matricula">Matricula</label>
	<input disabled readonly type="text" name="matricula" value="${coche.matricula }" class="form-control">			    
	</div>
	
	<div class="form-group">
	<label for="importe">Importe</label>
	<input type="text" name="importe" placeholder="Introduce un valor numerico valido" class="form-control">			    
	</div>	
	
	<div class="form-group">
	<label for="concepto">Concepto</label>
	<textarea name="concepto" placeholder="800" class="form-control">minimo 10 caracteres</textarea>		    
	</div>	
	${mensaje }
	
	
	<div  class="form-group">								
	<button type="submit" class="btn btn-primary btn-block">INSERTAR</button>
	</div>	
	
</form>

	
</main>				
<%@ include file="../includes/footer.jsp"  %>



