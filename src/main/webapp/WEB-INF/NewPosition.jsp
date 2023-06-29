

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<%@ page isELIgnored="false" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>New Position</title>
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
    <h1 class="display-4">Add a Position</h1>
    <form:form method="POST" action="add/position" modelAttribute="newPos">
        <div class="mt-2">
            <form:label path="name" class="form-label">Name:</form:label>
            <form:input path="name" class="form-control"/>
           	<form:errors path="name" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="description" class="form-label">Description:</form:label>
            <form:textarea path="description" class="form-control"/>
            <form:errors path="description" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="skills" class="form-label">Skills:</form:label>
            <form:select path="skills" class="form-control">
            	
            		<form:options items="${skills}" itemValue="id" itemLabel="skillName" />
          
            	
            </form:select>
            <form:errors path="skills" class="text-danger"/>
        </div>
        <div class="mt-2">
	        <input type="submit" value="Add Position" class="btn btn-primary mb-2"/>
	        <a class="btn btn-secondary mb-2" href="/orgs/dashboard">Go Back</a>
	    </div>
    </form:form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>