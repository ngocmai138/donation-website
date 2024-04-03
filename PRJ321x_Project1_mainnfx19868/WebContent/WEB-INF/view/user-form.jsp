<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
		function quayLai(){
			var edit = ${edit};
			if(edit && !confirm('Bạn muốn quay lại ?')){return false;}
			else {
				window.location.href='${pageContext.request.contextPath}/admin/listUser';
			}
		}
		</script>
	
<title>User form</title>
</head>
<body>
<h2>Add new user</h2>
<f:form modelAttribute="user" action="${pageContext.request.contextPath }/admin/addUser" method="POST">
	<table>
	<tr>
		<td><f:hidden path="id" /></td>
		<td><f:hidden path="status"/>
	</tr>
	<tr>
		<td>Họ tên:</td>
		<td><f:input path="fullName" /> </td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="email" value="${user.email }" ${edit? 'readonly':'' }/> </td>
	</tr>
	<tr>
		<td>Số điện thoại:</td>
		<td><f:input path="phoneNumber" /> </td>
	</tr>
	<tr>
		<td>Tài khoản:</td>
		<td><input type="text" name="userName" value="${user.userName }" ${edit?'readonly':''} /> </td>
	</tr>
	<tr>
		<td>Mật khẩu:</td>
		<td><f:input path="password" /> </td>
	</tr>
	<tr>
		<td>Vai trò:</td>
		<td><f:select path="role">
				<f:options items="${roles}" itemValue="id" itemLabel="roleName"/>
			</f:select> 
		</td>
	</tr>
	<tr>
		<td> 
			<input type="button" onclick="quayLai()" value="Đóng" />
			<input type="submit" value="${edit? 'Lưu':'Thêm' }"/>
		</td>
	</tr>
	</table>
</f:form>
</body>
</html>