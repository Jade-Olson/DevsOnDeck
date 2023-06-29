

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${user.skills}" var="user">
    <c:out value="${user.skills.skillName}"/><br>
</c:forEach>

<c:forEach items="${skills}" var="skill">

<c:if test="${skill.skillType == 'language'}">

<form action ="/skills/addLanguage/${skill.id}" method ="get">
 <button><c:out value="${skill.skillName}"/></button>
 
</form>
 </c:if>
 </c:forEach>
</body>
</html>