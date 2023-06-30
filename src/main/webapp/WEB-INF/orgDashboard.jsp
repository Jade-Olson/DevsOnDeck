<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Dev Dashboard</title>
</head>
<body>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid bg-secondary">
		<h1 class="navbar-brand">DevsOnDeck</h1>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<div class="navbar-nav me-auto mb-2 mb-lg-0"></div>
			<a href="/logout" class="btn btn-primary m-2">Logout</a>
		</div>
	</div>
</nav>

<div class="container">
	<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
		<div class="col">
			<div class="row">
				<div class="col"></div>
				<a class="col btn btn-primary" href="/orgs/jobs/new">List a New Position</a>
				<div class="col"></div>
			</div>
			<div class="border p-1 mt-4">
				<h4 class="display-5">Positions to Fill</h4>
				<div>
					<c:forEach var="position" items="${allPositions}">
						<a class="lead" href="/orgs/${position.id}/edit" ><c:out value="${position.name}"/></a>
							<form action="/orgs/delete/${position.id}" method="post">
	                    <input type="hidden" name="_method" value="delete">
	                    <input type="submit" value="Delete">
                   </form>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col border pb-3">
			<div class="row border bg-secondary">
				<h2 class="display-5">Available Devs</h2>
			</div>
			<c:forEach var="dev" items="${devs}">
				<div class="border mt-3">
					<p class="lead"><c:out value="${dev.getFirstName()}"/> <c:out value="${dev.getLastName()}"/></p>
				
					<div class="row">
						
						<!-- TO-DO: ADD SKILLS HERE -->
						
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>