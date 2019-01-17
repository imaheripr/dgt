<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/cabecera.jsp" %> 	

 <main role="main" class="container-fluid ">

<c:if test = "${mensaje!=null}">
<div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong> ${mensaje }</strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

</c:if>

<h5>Objetivos anuales</h5>

<form>
<label for="anio">Selecciona el año</label>
 <select>
 <c:forEach items="${anios}" var="a">
  <option value="${a}">${a}</option>
</c:forEach>
</select> 
<button>Seleccionar</button>
</form>



 
 <ul>
<li>Total de multas</<li>
<li>Total de multas activas</<li>
<li>Total de multas anuladas</<li>
<li>Total recaudado</<li>
 </ul>



</main>
<%@ include file="../includes/footer.jsp"  %>