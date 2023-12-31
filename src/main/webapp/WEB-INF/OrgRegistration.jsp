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
<title>Welcome to DevsOnDeck</title>
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
					<a class="nav-link active" aria-current="page" href="/devs/login">Dev Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="/orgs/login">Org Login</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<div class="container">
<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
    <h1 class="display-4">Organization Sign Up</h1>
    <form:form method="POST" action="/orgs/register" modelAttribute="newOrg">
    	<div class="mt-2">
            <form:label path="orgName" class="form-label">Org Name:</form:label>
            <form:input path="orgName" class="form-control"/>
           	<form:errors path="orgName" class="text-danger"/>
        </div>
        <div class="mt-2 row">
        	<div class="col">
	            <form:label path="firstName" class="form-label">First Name:</form:label>
	            <form:input path="firstName" class="form-control"/>
	            <form:errors path="firstName" class="text-danger"/>
            </div>
            <div class="col">
	            <form:label path="lastName" class="form-label">Last Name:</form:label>
	            <form:input path="lastName" class="form-control"/>
	            <form:errors path="lastName" class="text-danger"/>
            </div>
        </div>
        <div class="mt-2">
            <form:label path="email" class="form-label">Contact Email:</form:label>
            <form:input path="email" class="form-control"/>
           	<form:errors path="email" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="orgAddress" class="form-label">Address:</form:label>
            <form:input path="orgAddress" class="form-control"/>
           	<form:errors path="orgAddress" class="text-danger"/>
        </div>
        <div class="mt-2 row">
        	<div class="col">
	            <form:label path="orgCity" class="form-label">City:</form:label>
	            <form:input path="orgCity" class="form-control"/>
	            <form:errors path="orgCity" class="text-danger"/>
            </div>
            <div class="col-sm-1">
	            <form:label path="state" class="form-label">State:</form:label>
	            <form:select path="state" class="form-select">
	            	<c:forEach var="OneState" items="${usaStates}">
	            		<option value="${OneState}"><c:out value="${OneState}"/></option>
	            	</c:forEach>
	            </form:select>
	            <form:errors path="state" class="text-danger"/>
            </div>
        </div>
        <div class="mt-2">
            <form:label path="password" class="form-label">Password:</form:label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password" class="text-danger"/>
            <form:errors path="confirmPassword" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="confirmPassword" class="form-label">Password Confirmation:</form:label>
            <form:password path="confirmPassword" class="form-control"/>
            <form:errors path="confirmPassword" class="text-danger"/>
        </div>
        <div class="mt-2">
	        <input type="submit" value="Register!" class="btn btn-primary mb-2"/>
	        <a class="btn btn-secondary mb-2" href="/devs/register">Sign Up as Developer</a>
	    </div>
    </form:form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>