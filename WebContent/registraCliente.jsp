<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Registra Cliente</title>
</head>
<body>

<div class="container">
<h1>Registra Cliente</h1>
	
	<c:if test="${sessionScope.MENSAJE != null }">
			<div class="alert alert-success" id="success-alert">
	 		   <button type="button" class="close" data-dismiss="alert">x</button>
				${sessionScope.MENSAJE}				
			</div>
	</c:if>
	<c:remove var="MENSAJE"/>

	<form action="registraCliente" id="id_form"> 
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="id_nombre">Nombres</label>
				<input class="form-control" type="text" id="id_nombre" name="cliente.nombre" placeholder="Ingrese el nombre">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_dni">DNI</label>
				<input class="form-control" type="text" id="id_dni" name="cliente.dni" placeholder="Ingrese el precio">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_fecha">Fecha de Nacimiento</label>
				<input class="form-control" type="date" id="id_fecha" name="cliente.fechaNacimiento" placeholder="Ingrese la fecha">
			</div>
			<div class="form-group">
		            <label class="control-label" for="id_reg_categoria">Categoría</label>
		           	<select class='form-control' id="id_reg_categoria" name="cliente.categoria.idCategoria">
						<option value=" ">[Seleccione]</option>    
					</select>
		    </div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" >Crea Cliente</button>
			</div>
	</form>
</div>

<script type="text/javascript">
$("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
});
</script>


	
<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	
          
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>

<script type="text/javascript">
$.getJSON("cargaCategoria", {}, function(data, q,t){
	$.each(data.lstCategoria, function(index,item){
		$("#id_reg_categoria").append("<option value="+item.idCategoria +">"+ item.nombre +"</option>");
	});
});
</script>

</body>
</html>




