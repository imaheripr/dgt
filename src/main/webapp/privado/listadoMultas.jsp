<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid mt-5">


 <c:if test = "${mensaje!=null}">
<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>	

<h1>Multas Activas</h1>


		  
		    
<c:forEach items="${multas}" var="m">			
<!-- Modal -->
	<div class="modal fade" id="anular${m.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Atención</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					¿ Estas serguro que deseas anular la multa ?
					<ul class="list-unstyled mt-3 mb-4">			         	
					<li>Fecha: ${m.fecha}</li>
					<li>Importe: ${m.importe} €</li>
					<li>Concepto: ${m.concepto}</li>
					<li>Matricula: ${m.coche.matricula}</li>		     
					</ul>			   
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
					<a href="privado/multa?operacion=2&id=${m.id}" class="btn btn-danger">ANULAR</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<table id="example" class="table tablaOrdenable" style="width:100%"> 
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Matricula</th>
                <th>Anular</th>             
            </tr>
        </thead>
        <tbody>
	         <c:forEach items="${multas}" var="m">	        
	            <tr>
	               	<td scope="col" data-target="#collapse${m.id}">
			     		<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${m.id}" aria-expanded="false" aria-controls="collapseTwo">
				         	<fmt:formatDate pattern = "dd/MM/yy"  value = "${m.fecha}" />
				          	<fmt:formatDate pattern = "HH:mm"  value = "${m.hora}" />
				     	</button>
			     	</td>
	               	<td scope="col">
			     		<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${m.id}" aria-expanded="false" aria-controls="collapseTwo">
				          	${m.coche.matricula}
				     	</button>
				   	</td>
	               	<td scope="col">
			     		<button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#anular${m.id}" >
							ANULAR
						</button>
				   	</td>         
	            </tr>           
	        </c:forEach>          
        </tbody>      
        <tfoot>
            <tr>
                <th>Fecha</th>
                <th>Matricula</th>
                <th>Anular</th>          
            </tr>
        </tfoot>
    </table>		
</main>				
<%@ include file="../includes/footer.jsp"  %>

