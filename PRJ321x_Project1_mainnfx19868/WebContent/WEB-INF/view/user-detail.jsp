<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết người dùng</title>
</head>
<body>
<h2>Chi tiết người dùng</h2>
<f:form modelAttribute="user">
<table>
	<tr>
		<td>Họ tên: </td>
		<td>${user.fullName }</td>
	</tr>
	<tr>
		<td>Tài khoản: </td>
		<td>${user.userName }</td>
	</tr>
	<tr>
		<td>Mật khẩu: </td>
		<td>${user.password }</td>
	</tr>
	<tr>
		<td>Email: </td>
		<td>${user.email }</td>
	</tr>
	<tr>
		<td>Số điện thoại: </td>
		<td>${user.phoneNumber }</td>
	</tr>
	<tr>
		<td>Vai trò: </td>
		<td>${user.role.roleName }</td>
	</tr>
	<tr>
		<td>Trạng thái: </td>
		<td>${user.status == 1 ? 'Hoạt động' : 'Đã Khóa'}</td>
	</tr>
</table>
</f:form>
<h3>Danh sách những đợt quyên góp</h3>
<f:form modelAttribute="paginationForm" method="get" id="userDetailForm">
<input type="hidden" name="userId" value="${user.id }"/>
<f:select path="pageSize" id="pageSize">
	<f:options items="${pageSizes }"/>
</f:select> entries per page
<br><br>
<input type="text" placeholder="Search...." value="${keyword }" name="keyword"/>
<br><br>
<table>
	<tr>
		<th>Tên đợt quyên góp</th>
		<th>Tiền quyên góp</th>
		<th>Ngày quyên góp</th>
		<th>Nội dung</th>
		<th>Trạng thái</th>
		<th>Hành động</th>
	</tr>
	<c:forEach var="ud" items="${userDonations }">
	<c:url var="changeStatus" value="changeStatusUD">
		<c:param name="udId" value="${ud.id }"/>
	</c:url>
	<tr>
		<td>${ud.name}</td>
		<td>${ud.money }</td>
		<td>${ud.created }</td>
		<td>${ud.donation.description }</td>
		<td>${ud.status }</td>
		<td><input type="button" onclick="window.location.href='${changeStatus}'" value="${ud.status==0? 'Xác nhận':'Hủy xác nhận' }"/></td>
	</tr>
	</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${totalPages }">
	<a href="${pageContext.request.contextPath}/admin/detailUser?pageSize=${pageSize}&pageNumber=${i}&userId=${user.id}">${i }</a>
</c:forEach>
</f:form>
<br>
<input type="submit" value="Quay lại" onclick="window.location.href='listUser'"/>
<script>
	window.onload = function(){
		var pageSize = document.getElementById("pageSize");
		var form = document.getElementById("userDetailForm");
		var keyword = document.querySelector("input[name='keyword']");
		keyword.addEventListener('keydown',function(event){
			if(event.key === 'Enter'){
				event.preventDefault;
				form.submit();
			}
		});
		pageSize.addEventListener('change', function(){
			form.submit();
		});
	};
</script>
<br><br>
</body>
</html>