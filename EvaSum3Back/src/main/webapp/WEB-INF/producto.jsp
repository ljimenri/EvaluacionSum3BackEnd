<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
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

<header>
  <nav class="navbar navbar-expand-sm navbar-dark bg-success">
    <div class="container-fluid">


      <h4 style="color: white">Compras!</h4>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Tooggle navigation">

        <span class="navbar-toggler-icon"></span>
      </button>

    
    </div>
  </nav>

</header>
	<div>
		
		<div class="container col-md-4" style="margin-top: 50px">
		<h4 style="text-align: center;">Registro de productos</h4>
		<br>
		<form class="px-2" action="/producto/insertar" method="POST">

			<div class="form-group">
				<label>Nombre producto</label> 
				<input type="text" placeholder="Ingresa el nombre del producto"
					class="form-control" name="nombre" value="${nombre}" required>
				
				<br>
			</div>

			<div class="form-group">
				<label>Precio</label> <input type="text" placeholder="Ingresa el precio"
					class="form-control" name="precio" value="${precio}" required>
				
			</div>
			<br>


		<div class="form-group">
				<label>Caracteristicas</label> <input type="text" placeholder="Ingresa las características"
					class="form-control" name="caracteristica" value="${caracteristica}" required>
				
			</div>
			<br>


			
			<br>


			<div class="container">
				<div class="row">
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="submit" class="btn btn-success">Guardar</button>
					</div>
				</div>
			</div>
			<br>

		</form>

	<form action="/carro-compra" class="btn-group" method="POST">
					<button type="submit" class="btn btn-warning btn-lg">Ver carro</button>
		</form>
		
	
		<br>
		<hr>
		
		
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Descripción</th>
      <th scope="col">Acción</th>
    </tr>
  </thead>
  <tbody>
  
  
    <c:forEach var="producto"  items="${productos}">
					<tr>
						<td><c:out value="${producto.id}" /> </td>
						<td><c:out value="${producto.nombre}" /> </td>
						<td><c:out value="${producto.precio}" /> </td>
						<td><c:out value="${producto.caracteristicas}" /> </td>
						
				<td>			
    		<Form action="/producto/eliminar?id=${producto.id}"  method="POST">
                <button type="submit" class="btn btn-danger">
               	 Eliminar
                </button>
            </Form>
             </td>    
						
					</tr>
	</c:forEach>
   
  
  </tbody>
</table>	
		
	</div>
	
	
	 <footer class="bg-light text-center text-lg-start">
  <!-- Grid container -->
  <div class="container p-4">
    <!--Grid row-->
    <div class="row">



      <!--Grid column-->
      <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
        <h5 class="text-uppercase">Información de contacto</h5>

        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo modi esse deserunt voluptas, incidunt ab
          ad minus dignissimos ut debitis non perferendis. Optio illum, iure dicta nam itaque laboriosam sunt!

        </p>
      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">



      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-lg-3">
        <h5 class="text-uppercase mb-0">Redes sociales</h5>

        <ul class="list-unstyled">
          <li>
            <a href="#!" class="text-dark">Facebook</a>
          </li>
          <li>
            <a href="#!" class="text-dark">Intagram</a>
          </li>
          <li>
            <a href="#!" class="text-dark">Twitter</a>
          </li>
          <li>
            <a href="#!" class="text-dark">Whatsapp</a>
          </li>
        </ul>
      </div>
      <!--Grid column-->

      <!--Grid column-->
    </div>
    <!--Grid row-->
  </div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2021 Copyright:
    <a class="text-dark" href="https://mdbootstrap.com/">compras.com</a>
  </div>
  <!-- Copyright -->
</footer>
	
</body>
</html>