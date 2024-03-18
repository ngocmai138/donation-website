<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName } ${student.lastName }
<br><br>
Country: ${student.country }
<br><br>
Favorite language: ${student.favoriteLanguage }
<br><br>
Operating system: 
<br><br>
<ul>
<c:forEach var="opS" items="${student.os}">
<li>${opS }</li>
</c:forEach>
</ul>
</body>
</html>