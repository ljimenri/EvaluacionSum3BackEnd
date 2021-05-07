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


 <div id="navbarSupportedContent" class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">  
        
        <li class="nav-item">
            <a class="nav-link" href="/producto">Producto</a>
          </li>
          
          
          <li class="nav-item">
            <a class="nav-link" href="/carro-compra">Carro compra</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="/categoria">Categorias</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="/usuario/log-aout">Cerrar Sesión</a>
          </li>

        
      </ul>
 </div>
    
    </div>
  </nav>

</header>
	<div>
		
		<div class="container col-md-4" style="margin-top: 50px">
		<h4 style="text-align: center;">Registro de categorías</h4>
		<br>
		<form class="px-2" action="/categoria/insertar" method="POST">

			<div class="form-group">
				<label>Nombre categoría</label> 
				<input type="text" placeholder="Ingresa la categoria"
					class="form-control" name="nombre" value="${nombre}" required>
				
			</div>

			<br>

			<div class="container">
				<div class="row">
					<div class="btn-group" role="group"
						aria-label="Basic mixed styles example">
						<button type="submit" class="btn btn-success">Guardar categoria</button>
					</div>
				</div>
			</div>
			
			
			

		</form>
		<br>
		<hr>
		
		
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre categoría</th>
      <th scope="col">Acción</th>
    </tr>
  </thead>
  <tbody>
  
  
    <c:forEach var="categoria"  items="${categorias}">
					<tr>
						<td><c:out value="${categoria.id}" /> </td>
						<td><c:out value="${categoria.nombre}" /> </td>
						
						
				<td>			
    		<Form action="/categoria/eliminar?id=${categoria.id}"  method="POST">
                <button type="submit" class="btn btn-danger">
               	 Eliminar
                </button>
            </Form>
            
            
            <br>
            <Form action="/categoria/editar?id=${categoria.id}"  method="POST">
                <button type="submit" class="btn btn-success">
               	 Modificar
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