<%@ include file="../includes/cabecera.jsp" %> 	
<main role="main" class="container mt-5">	
<%--INSERT INTO multa (importe, concepto, id_coche, id_agente) VALUES ('200', 'velocidad', '4', '4'); --%>
<form action="privado/buscar" method="post">	
	<%-- 
	<input type="hidden" name="id_agente" value="">
	<input type="hidden" name="id_coche" value="">
	--%>
	
	<div class="form-group">
	<label for="importe">Importe</label>
	<input type="text" name="importe" placeholder="800" class="form-control">			    
	</div>	
	
	<div class="form-group">
	<label for="concepto">concepto</label>
	<input type="text" name="concepto" placeholder="800" class="form-control">			    
	</div>	
	
	<div class="form-group">
	<label for="id_coche">Coche ID</label>
	<input readonly type="text" name="concepto" value="${coche.id }" class="form-control">			    
	</div>	
	
	<div class="form-group">
	<label for="id_coche">Agente ID</label>
	<input readonly type="text" name="concepto" value="${sessionScope.agente_logeado.id}" class="form-control">			    
	</div>
	
	
	<div  class="form-group">								
	<button type="submit" class="btn btn-primary btn-block">BUSCAR</button>
	</div>	
	
</form>

	
</main>				
<%@ include file="../includes/footer.jsp"  %>



