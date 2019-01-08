<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid mt-5">	


<div class="accordion" id="accordionExample">		
	<table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">FECHA </th>
		      <th scope="col">MATRICULA</th>
		       <th></th>
		    </tr>
		  </thead>
		  <tbody>
		    
		 <c:forEach items="${multas}" var="m">
			    <tr>
			 	<td scope="col" data-target="#collapse${m.id}">
		     		
		     		<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${m.id}" aria-expanded="false" aria-controls="collapseTwo">
			         <fmt:formatDate pattern = "dd/MM/yy"  value = "${m.fecha}" />
			     </button>
		     	</td>
		     	<td scope="col">
		     	<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${m.id}" aria-expanded="false" aria-controls="collapseTwo">
			          ${m.coche.matricula}
			     </button>
			   </td>
			   	<th scope="col">
		     	<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${m.id}" aria-expanded="false" aria-controls="collapseTwo">
			         +
			     </button>
			   </th>
		     	
		     	</tr>  
		     	<tr id="collapse${m.id}" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
		     	<td colspan="3">
		     	<ul>
		     	<li>Fecha: ${m.fecha}</li>
		     	<li>Importe: ${m.importe} €</li>
			    <li>Concept: ${m.concepto}</li>
		     	<li>Matricula: ${m.coche.matricula}</li>
		     	<li>Modelo: ${m.coche.modelo}</li>
		     	<li>Kilometraje: ${m.coche.km}</li>
		     	
		     	</ul>
		     	</td>
		     	
		     	</tr>  
		    </c:forEach>
		  </tbody>
		</table>		
</div>	
			
</main>				
<%@ include file="../includes/footer.jsp"  %>

