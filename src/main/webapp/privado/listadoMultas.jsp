<%@ include file="../../includes/cabecera.jsp"  %>


    <main role="main" class="container">
	
		<a href="privado/videos?op=2&id=-1" class="btn btn-outline-success mb-2">Crear Nuevo Registro</a>
		
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
		 
		 	 <c:forEach items="${multas}" var="m">
			    <tr>		    	
			      <td scope="row">${m.id}</td>
			      <td scope="row">${m.importe}</td>
			      <td scope="col">${m.concepto}</td>
		     	<td scope="col">${m.fecha}</td>
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>


	</main>				


