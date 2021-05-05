  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de inicio</title>
<!-- CSS only -->
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
		<h4 style="text-align: center;">Formulario de login</h4>
		<br>
		<form class="px-2" action="/usuario/login" method="POST">

			<div class="form-group">
				<label>Correo</label> <input type="text" placeholder="Ingresa el correo"
					class="form-control" name="correo" value="${correo}" required>
				
				<br>
			</div>

			<div class="form-group">
				<label>Clave</label> <input type="password" placeholder="ingresa tu clave"
					class="form-control" name="clave" value="${clave}" required>
				
			</div>
			<br>


			
			<br>


			<div class="container">
				<div class="row">
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="submit" class="btn btn-success">Ingresar</button>
					</div>
				</div>
			</div>
			<br>
			
			
		

		</form>


	

		<div class="btn-group" role="group" aria-label="Basic mixed styles example">
				<form action="/usuario" class="btn-group" method="POST">
					<button type="submit" class="btn btn-warning btn-lg">registrar</button>
				</form>
		</div>

</body>
</html>