<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp" %> 	

<main>
<section class="container-fluid mt-5 ">
<c:if test = "${mensaje!=null}">
	<div class="alert alert-info alert-dismissible fade show" role="alert">
	  <strong> ${mensaje }</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>


<div class="card-deck mb-3 text-center">
<div class="card mb-4 box-shadow">
<div class="card-header">
<h4 class="my-0 font-weight-normal">Mes  <fmt:formatDate pattern = "MMMM" value = "${objetivo.fecha }" /></h4>
</div>
<div class="card-body">
<h1 class="card-title pricing-card-title">${objetivo.importe!=null ? objetivo.importe : '0'}€ <small class="text-muted">/1000€</small></h1>
								
</div>
</div>    
<div class="card mb-4 box-shadow">
<div class="card-header">
<h4 class="my-0 font-weight-normal">Año <fmt:formatDate pattern = "yyyy" value = "${objetivo2.fecha }" /></h4>
</div>
<div class="card-body">
<h1 class="card-title pricing-card-title">${objetivo2.importe>0 ? objetivo2.importe : '0'}€ <small class="text-muted">/12000€</small></h1>
</div>
</div>      
</div>


 <hr>



 <h5>Historico </h5>
<c:choose>
    <c:when test="${ not empty historico }">
<form>
<select class="form-control" onchange="cambiaranio(this)">
<c:forEach items="${anios}" var="anio">
<option value="${anio }" <c:if test="${anio == a }">selected</c:if> >${anio }</option>
</c:forEach>
</select> 
</form>
<script>
function cambiaranio(a){
console.log("Cambiando año "+a.value);
location.href="privado/objetivos?id_agente="+${sessionScope.agente_logeado.id}+"&a="+a.value;
}
</script>


<table class="table"> 
<thead>
<tr>
<th>Mes</th> 
<th>Recaudado</th>           
<th>Total de Multas</th>                                             
</tr>
</thead>
<tbody>
<c:forEach items="${historico }" var="h">	                    
 <tr>
<td><fmt:formatDate pattern = "MMMM" value = "${h.fecha }" /></td>
<td>${h.importe }</<td>
<td>${h.num_multas }</<td> 
</tr>                                                   
</c:forEach>                  
</tbody>      
</table>  
    </c:when>    
    <c:otherwise>
       <h5>NO HAY DATOS DISPONIBLES</h5>
      <a href="privado/principal"> Volver a Inicio</a>
    </c:otherwise>
</c:choose>





 
</section>
</main>
<%@ include file="../includes/footer.jsp"  %>