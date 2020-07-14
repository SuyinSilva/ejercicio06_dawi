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
 <h1>Lista Modalidad con Deporte</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaModalidad">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<select id="id_deporte" class='form-control' multiple="multiple">
   
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
												<th>Nombre</th>
												<th>#Hombres</th>
												<th>#Mujeres</th>
												<th>Edad M�nima</th>
												<th>Edad M�xima</th>
												<th>Sede</th>
												<th>Deporte</th>
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
$('#id_deporte').on("change", function(){ 
	   console.log("Se pulsa el boton");
	    $("#id_table tbody").empty(); 
	   
	    var sel = $("#id_deporte").val();
	    console.log(sel);
	    
	    var cad ="";
	    if (sel != null){
			for (var i = 0; i < sel.length; i++) {
				cad += sel[i];
				if(i != sel.length-1)cad += ",";
			}		
		}
	    console.log(cad);
	    
	 	$.getJSON("consultaModalidadMultiple", {"filtro.deportes":cad}, function(data){
			$.each(data.lstModalidad, function(index,item){
				$("#id_table").append("<tr><td>"+ item.idModalidad +"</td><td>"+ item.nombre +"</td><td>"+ item.numHombres +"</td><td>"+ item.numMujeres +"</td><td>"+ item.edadMinima +"</td><td>"+ item.edadMaxima +"</td><td>"+ item.sede +"</td><td>"+ item.deporte.nombre +"</td></tr>");
			});
		});
});


$.getJSON("cargaDeporte", {}, function(data){
	$.each(data.lstDeporte, function(index,item){
		$("#id_deporte").append("<option value="+item.idDeporte +">"+ item.nombre +"</option>");
	});
});
</script>
    
</body>
</html> 