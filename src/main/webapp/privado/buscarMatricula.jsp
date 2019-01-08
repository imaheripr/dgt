<%@ include file="../includes/cabecera.jsp" %> 	


    <main role="main" class="container">
	
	<div class="row">
	
		<div class="col-6">
	
			<form action="privado/comprobacion" method="post">		
				<div class="form-group">
				    <label for="id">Buscar Matricula</label>
				    <input type="text" name="id" value="por defecto" class="form-control">			    
				</div>	

				<div>									
				<input type="hidden" name="op" value="3">
				<button type="submit" class="btn btn-primary btn-block">BUSCAR</button>
				</div>	
			</form>			
		</div>
		
	</div>	
	
	</main>	