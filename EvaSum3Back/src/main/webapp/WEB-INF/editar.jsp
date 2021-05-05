<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar carro</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
</head>
<body>



<div class="container col-md-4" style="margin-top: 50px">
		<h4 style="text-align: center;">Modifica un producto del carro</h4>
		
		
	<form:form action="/carro-compra/actualizar" method="post" class="px-2" modelAttribute="carrito">
	
	<form:hidden path="id"/>
			
			
			
			
	
		
	<div class="form-group">
			<form:label path="cantidad">Cantidad </form:label>
			<form:input path="cantidad" class="form-control" />
	</div>
			<br>
		<div class="container">
				<div class="row">
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="submit" class="btn btn-success">Actualizar</button>
					</div>
				</div>
			</div>
		
		
	</form:form>

</div>



</body>
</html>