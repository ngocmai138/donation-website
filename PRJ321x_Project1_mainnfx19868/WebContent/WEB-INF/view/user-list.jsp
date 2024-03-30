<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User list</title>
</head>
<body>
<h2>Danh sách người dùng</h2>
<input type="button" value="Thêm mới" onclick="window.location.href='formToAddUser'"/>
<br>
<br>
<f:form modelAttribute="pagination" action="${pageContext.request.contextPath }/admin/listUser" method = "get" id="paginationForm">
	<f:hidden path="pageNumber" value="${pagination.pageNumber }" id="pageNumber"/>
	<f:select path="pageSize" id="pageSize">
		<option value="" selected="selected" hidden="true">${numSize }</option>
		<f:options items="${pageSizes }"/>
	</f:select>
	entries per page
	<br>
	<br>
	
	<input type="text" placeholder="Search...." name="keyword" value="${keyword }"/>
</f:form>
<br>
<table>
<tr>
	<th>Họ tên</th>
	<th>Email</th>
	<th>Số điện thoại</th>
	<th>Tài khoản</th>
	<th>Vai trò</th>
	<th>Trạng thái</th>
	<th>Hành động</th>
</tr>
<c:forEach var="u" items="${users}">
<c:url var="deleteLink" value="deleteUser">
	<c:param name="userId" value="${u.id}"/>
</c:url>
<c:url var="editLink" value="editForm">
	<c:param name="userId" value="${u.id }"/>
</c:url>
<c:url var="changeStatusLink" value="changeStatusUser">
	<c:param name="userId" value="${u.id }"/>
</c:url>
<c:url var="detailLink" value="detailUser">
	<c:param name="userId" value="${u.id }"/>
</c:url>
<tr>
	<td>${u.fullName }</td>
	<td>${u.email }</td>
	<td>${u.phoneNumber }</td>
	<td>${u.userName }</td>
	<td>${u.role.roleName }</td>
	<td>${u.status == 1 ? 'Hoạt động' : 'Đã Khóa'}</td>
	<td>
		<input type = "button" value=" Sửa " onclick ="window.location.href='${editLink}'"/>
		<input type = "button" value=" Chi tiết " onclick ="window.location.href='${detailLink}'"/>
		<input type = "button" value=" Xóa " onclick ="if(!confirm('Bạn chắc chắn  muốn xóa?')) return false; else window.location.href='${deleteLink}'" />
		<input type = "button" value=" ${u.status=='1'?'Khóa':'Mở' } " onclick ="window.location.href='${changeStatusLink}'"/>
	</td>
</tr>
</c:forEach>
</table>
<div>
<c:forEach var="i" begin="1" end="${totalPages }">
	<a href="${pageContext.request.contextPath }/admin/listUser?pageSize=${numSize }&pageNumber=${i }&keyword=${keyword}">${i }</a>
</c:forEach>
<br><br>
<div>Showing ${ firstResult} to ${lastResult } of ${totalUsers } entries</div>
</div>
<br>
<input type="button" value="Quay lại" onclick="window.location.href='${pageContext.request.contextPath }/admin'"/>
<script>
window.onload= function(){
		var pageSizeSelect = document.getElementById('pageSize');
		var keywordInput = document.querySelector('input[name="keyword"]');
		var form = document.getElementById('paginationForm')
		pageSizeSelect.addEventListener('change', function(){		
			document.getElementById('pageNumber').value = '1';
			form.submit();
		});
		keywordInput.addEventListener('keydown', function(event){
			if(event.key === 'Enter'){
				event.preventDefault();
				document.getElementById('pageNumber').value ='1';
				form.submit();
			}
		});
};
</script>
</body>
</html>