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

	<form:form method="post" action="/pasajero/agregar"
		class="container w-50" modelAttribute="pasajero">
		<div class="mb-3">
			<form:label for="" path="nombre" class="form-label">Nombre</form:label>
			<form:input type="text" path="nombre" class="form-control" id="" />

		</div>
		<div class="mb-3">
			<form:label for="" path="apellido" class="form-label">Apellido</form:label>
			<form:input type="text" path="apellido" class="form-control" id="" />
		</div>
		<div class="mb-3">
			<form:label for="" path="rut" class="form-label">Rut</form:label>
			<form:input type="text" path="rut" class="form-control" id="" />
		</div>

		<div class="mb-3">
			<form:label for="" path="edad" class="form-label">Edad</form:label>
			<form:input type="text" path="edad" class="form-control" id="" />
		</div>
		<div class="mb-3">
			<form:label for="" path="ciudadNatal" class="form-label">Ciudad Natal</form:label>
			<form:input type="text" path="ciudadNatal" class="form-control" id="" />
		</div>


		<button type="submit" class="btn btn-primary">Agregar</button>
	</form:form>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>