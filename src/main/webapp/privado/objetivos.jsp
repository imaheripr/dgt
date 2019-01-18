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

 Este mes de 
 <fmt:formatDate pattern = "MMMM" value = "${objetivo.fecha }" />
 

 <hr>
 <h5>Historico</h5>
 ${objetivo }
 <form>
<label for="anio">Selecciona el año</label>
 <select>
 <c:forEach items="${multa}" var="m">
  <option value="${m}">${m}</option>
</c:forEach>
</select> 
<button>Seleccionar</button>
</form>


 
</section>
</main>
<%@ include file="../includes/footer.jsp"  %>