<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName"/><br><br>
Last name: <form:input path="lastName"/><br><br>
Country: <form:select path="country">
<form:options items="${student.optionCountry}"/>
</form:select>
<br><br>
Favorite language:
<br><br>
Java <form:radiobutton path="favoriteLanguage" value = "Java"/>
C# <form:radiobutton path="favoriteLanguage" value = "C#"/>
PHP <form:radiobutton path="favoriteLanguage" value = "PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value = "Ruby"/>

<br><br>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>