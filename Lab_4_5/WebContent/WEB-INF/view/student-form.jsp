<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>
<f:form action="processForm" modelAttribute="student">
First name: <f:input path="firstName"/>
<br><br>
Last name: <f:input path="lastName"/>
<br><br>
Country: 
<f:select path="country">
<f:options items="${student.countryOptions }"/>
</f:select>
<br><br>
Favorite Language: 
Java <f:radiobutton path="favoriteLanguage" value="java"/>
C# <f:radiobutton path="favoriteLanguage" value="c#"/>
PHP <f:radiobutton path="favoriteLanguage" value="php"/>
Ruby <f:radiobutton path="favoriteLanguage" value="ruby"/>
<br><br>
Operating system:
Linux <f:checkbox path="os" value="linux"/>
Windows <f:checkbox path="os" value="windows"/>
Mac os <f:checkbox path="os" value="max os"/>
<br><br>

<input type="submit" value="Submit" />
</f:form>
</body>
</html>