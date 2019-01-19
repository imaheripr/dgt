
<!-- Bootstrap  JavaScript================================================== -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>

<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>

<!-- datatable -->	
 	<script>
	
 	$(document).ready(function() {
    	$('.tablaOrdenable').DataTable( {
    		"order": [[ 0, "desc" ]],
    		responsive: true,
    		"pageLength": 25,
    		 "language": {
                 "url": "datatables/spanish.lang"
    				
    				
    			}
    		}
    	);
	});
 	function cambiaranio(a){
 		console.log("Cambiando año "+a.value);
 		location.href="privado/objetivos?id_agente="+${sessionScope.agente_logeado.id}+"&a="+a.value;
 		}
	</script>

<!-- contador caracteres -->	
   
     
   <script>
         
       let label;
       let concepto; //textarea
       
       const MAX_CARARCTERES = 250; 
       const MIN_CARARCTERES = 10;
       
       window.addEventListener('load', function() {
           
           console.log('el DOM cargado y listo');
           label   = document.getElementById('contadorLabel');
           concepto = document.getElementById('concepto');
            
           label.textContent = `0/`+ MAX_CARARCTERES;
           label.style.color = 'orange';
           
           concepto.addEventListener("keyup", function(){
               
               let caracteres = concepto.value.length;                             
               
               if( caracteres < MIN_CARARCTERES ){
                    label.style.color = 'orange';   
               }else if ( caracteres  > MAX_CARARCTERES ){
                   concepto.value = concepto.value.substr(0,MAX_CARARCTERES);
               }else{
                    label.style.color = 'green';
               }
               
               caracteres = concepto.value.length;
               label.textContent = caracteres + `/`+ MAX_CARARCTERES;
               
           });
           
           
       });
    
   </script>
   
   
</body>
</html>