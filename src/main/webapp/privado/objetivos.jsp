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

<h5>Actual</h5>
 <ul>
<li>Mes Actual: 300/1000</li>
<li>Año Actual: 3000/12000</li>
 </ul>
 
 
 <hr>
 <h5>Historico</h5>
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
<li>TOTAL:</li>
<li>Enero</li>
 </ul>
 
 
</section>
</main>
<%@ include file="../includes/footer.jsp"  %>