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
			<div class="navbar-nav me-auto mb-2 mb-lg-0"></div>
			<a href="/logout" class="btn btn-primary m-2">Logout</a>
		</div>
	</div>
</nav>

<div class="container">
<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
	<form class="form" method="post" action="/devs/skills/frameworks">
    <div class="border row">
    	<h1 class="display-4 col">Add Your Skills</h1>
    	<div class="border m-4 col row p-0">
    		<div class="bg-secondary border col-sm-8 m-0"></div>
    		<div class="col"></div>
    	</div>
    </div>
    <div class="row mt-4">
	    <div class="col">
	    	<div class="row">
	    		<h4 class="display-6">Pick Your Top 5 Frameworks</h4>
	    	</div>
	    	<div class="row">
	    		<select class="form-select" name="skills" multiple>
	    			<c:forEach var="skill" items="${skills}">
	    				<c:if test="${skill.getSkillType().equals('framework')}">
	    					<option value="${skill}"><c:out value="${skill.getSkillName()}"/></option>
	    				</c:if>
	    			</c:forEach>
	    		</select>
	    	</div>
	    </div>
    </div>
    <div class="row mt-4">
    	<div class="col"></div>
    	<input type="submit" class="btn btn-primary col-sm-4" value="COMPLETE PROFILE"/>
    </div>
    </form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>