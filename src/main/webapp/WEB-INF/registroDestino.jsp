<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="template/navbar.jsp">
		<jsp:param value="Dirección" name="title" />
	</jsp:include>

	<c:if test="${Correcto!=null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${Correcto}"></c:out>
		</div>
	</c:if>

	<c:if test="${Error!=null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${Error}"></c:out>
		</div>
	</c:if>

	<form method="post" action="/destino/registrar" class="container w-50">
		
		<div class="mb-3">
			<label for="" name="ciudad" class="form-label">Ciudad</label>
			<input type="text" name="ciudad" class="form-control" id="" />

		</div>
		<div class="mb-3">
			<label for="" name="pais" class="form-label">País</label>
			<input type="text" name="pais" class="form-control" id="" />
		</div>
		<div class="mb-3">
			<label for="" name="fecha" class="form-label">Fecha</label>
			<input type="date" name="fecha" class="form-control" id=""/>
		</div>



	<div class="my-4">
			<select id="" name="pasajeroId" class="form-select">
				<option value="0"> Seleccione Pasajero</option>
				<c:forEach items="${listaPasajeros}" var="pasajero">
					
						<option value="${pasajero.id}">
							<c:out value="${pasajero.nombre} ${pasajero.apellido}"></c:out>
						</option>
					
				</c:forEach>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Agregar</button>
	</form>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>