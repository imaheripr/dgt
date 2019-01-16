<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp"  %>
 <main role="main" class="container-fluid">


 <c:if test = "${mensaje!=null}">
<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>	

<h5>Multas Anuladas</h5>
		    

<table id="example" class="table tablaOrdenable" style="width:100%"> 
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Matricula</th>           
            </tr>
        </thead>
        <tbody>
	         <c:forEach items="${multas}" var="m">	        
	            <tr>
	               	<td>     		
				         	<fmt:formatDate pattern = "dd/MM/yy"  value = "${m.fecha}" />
				          	<fmt:formatDate pattern = "HH:mm"  value = "${m.hora}" />				     
			     	</td>
	               	<td>${m.coche.matricula}</td>        
	            </tr>           
	        </c:forEach>          
        </tbody>      
        <tfoot>
            <tr>
                <th>Fecha</th>
                <th>Matricula</th>                       
            </tr>
        </tfoot>
    </table>		
</main>				
<%@ include file="../includes/footer.jsp"  %>