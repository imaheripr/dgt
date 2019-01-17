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

<a class="btn btn-lg btn-info btn-block mb-3" href="privado/objetivo_agente?op=2&id=${sessionScope.agente_logeado.id}" role="button">OBJETIVOS ANUALES</a>
<a class="btn btn-lg btn-info btn-block  mb-3" href="#" role="button">OBJETIVOS MENSUALES</a>

</section>
</main>
<%@ include file="../includes/footer.jsp"  %>