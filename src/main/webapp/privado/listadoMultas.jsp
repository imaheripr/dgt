<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid mt-5">	
		<table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">IMPORTE</th>
		      <th scope="col">CONCEPTO</th>
		      <th scope="col">FECHA</th>
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
<%@ include file="../includes/footer.jsp"  %>

