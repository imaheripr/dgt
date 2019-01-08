<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid mt-5">	
		<table class="table">
		  <thead class="thead-light">
		    <tr>
		    <%-- 
		      <th scope="col">ID</th>
		      <th scope="col">ID</th>
		    --%>
		      <th scope="col">FECHA</th>
		      <th scope="col">IMPORTE</th>
		      <th scope="col">CONCEPTO</th>
		      <th scope="col">MATRICULA</th>
		      <th scope="col">MODELO</th>
		      <th scope="col">KM</th>
		    </tr>
		  </thead>
		  <tbody>
		    
		 <c:forEach items="${multas}" var="m">
			    <tr>
			 <%-- 		    	
			    <td scope="row">${m.id}</td>
			    <td scope="row">${m.coche.id}</td>
			 --%>
			    <td scope="col">
		     		<fmt:formatDate pattern = "dd/MM/yy"  value = "${m.fecha}" />
		     	</td>
			    <td scope="row">${m.importe}</td>
			    <td scope="col">${m.concepto}</td>
		     	<td scope="col">${m.coche.matricula}</td>
		     	<td scope="col">${m.coche.modelo}</td>
		     	<td scope="col">${m.coche.km}</td>
		     	
			    </tr>    
		    </c:forEach>
		  </tbody>
		</table>
</main>				
<%@ include file="../includes/footer.jsp"  %>

