<%@ include file="../../includes/cabecera.jsp"  %>


    <main role="main" class="container">
	
		<p>Listado Multas</p>
		
		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">id</th>
		      <th scope="col">importe</th>
		      <th scope="col">concepto</th>
		      <th scope="col">fecha</th>
		    </tr>
		  </thead>
		  <tbody>
		 	 <c:forEach items="${multas}" var="v">
			    <tr>		    	
			      <th scope="row">${v.id}</
			      <th scope="row">${v.importe}</th>
			  	  <th scope="row">${v.concepto}</
			      <th scope="row">${v.fecha}</th>
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


