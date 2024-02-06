<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirmation</title>
</head>
<body>
Customer is confirmed: ${customer.firstName } ${customer.lastName }
<br><br>
Free Passes: ${customer.freePasses }
<br><br>
Post code: ${customer.postCode }
<br><br>
Course code: ${customer.courseCode }
<br><br>
</body>
</html>