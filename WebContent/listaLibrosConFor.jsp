<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Ejemplos PIT CIBERTEC - Jorge Jacinto </title>
</head>
<body> 

 <div class="container">
 <h1>Consulta de Libros por Tema</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaLibros">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<select id="id_tema" class='form-control' multiple="multiple">
   
							     </select>
							</div>
						</div>
					</div>			
					
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="id_table" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Titulo</th>
												<th>Precio</th>
												<th>Tema</th>											
											</tr>
										</thead>
										<tbody>
												   

										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  


</div>

<script type="text/javascript">
$('#id_tema').on("change", function(){ 
	   console.log("Se pulsa el boton");
	    $("#id_table tbody").empty(); 
	   
	    var sel = $("#id_tema").val();
	    console.log(sel);
	    
	    var cad ="";
	    if (sel != null){
			for (var i = 0; i < sel.length; i++) {
				cad += sel[i];
				if(i != sel.length-1)cad += ",";
			}		
		}
	    console.log(cad);
	    
	 	$.getJSON("consultaLibrosMultiple", {"filtro.temas":cad}, function(data){
			$.each(data.lstLibros, function(index,item){
				$("#id_table").append("<tr><td>"+ item.idLibros +"</td><td>"+ item.titulo +"</td><td>"+ item.precio +"</td><td>"+ item.tema.nombre +"</td></tr>");
			});
		});
});


$.getJSON("cargaTema", {}, function(data){
	$.each(data.lstTema, function(index,item){
		$("#id_tema").append("<option value="+item.idTema +">"+ item.nombre +"</option>");
	});
});
</script>
    
</body>
</html> 