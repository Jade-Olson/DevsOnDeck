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
<title>Welcome Back</title>
</head>
<body>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid bg-secondary">
		<h1 class="navbar-brand">DevsOnDeck</h1>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/devs/register">Dev Registration</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="/orgs/register">Org Registration</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<div class="container">
<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
    <h1 class="display-4">Welcome Back!</h1>
    <h2 class="lead">Let's find you some candidates!</h2>
    <form:form method="POST" action="/orgs/login" modelAttribute="newLogin">
        <div class="mt-2">
            <form:label path="email" class="form-label">Email:</form:label>
            <form:input path="email" class="form-control"/>
           	<form:errors path="email" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="password" class="form-label">Password:</form:label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password" class="text-danger"/>
        </div>
        <div class="mt-2">
	        <input type="submit" value="Login!" class="btn btn-primary mb-2"/>
	        <a class="btn btn-secondary mb-2" href="/devs/login">Login as Developer</a>
	    </div>
    </form:form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>