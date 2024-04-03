<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donation form</title>
</head>
<script>
	function quayLai(){
		var edit=${edit};
		if(edit && !confirm('Bạn muốn quay lại?')) return false;
		else window.location.href='listDonation';
	}
</script>
<body>
<h2>${!edit ? 'Thêm mới' : 'Cập nhật' }</h2>
<f:form modelAttribute="donation" action="${pageContext.request.contextPath }/admin/addDonation">
	<table>
		<tr>
			<td>Mã đợt quyên góp: </td>
			<td><input type="text" name="code" value="${donation.code }" ${edit? 'readonly':'' }/></td>
		</tr>
		<tr>
			<td>Tên đợt quyên góp: </td>
			<td><f:input type="text" path="name"/></td>
		</tr>
		<tr>
			<td>Ngày bắt đầu: </td>
			<td><f:input type="date" path="startDate" /> </td>
		</tr>
		<tr>
			<td>Ngày kết thúc: </td>
			<td><f:input type="date" path="endDate"/></td>
		</tr>
		<tr>
			<td>Tổ chức: </td>
			<td><f:input type="text" path="organizationName"/></td>
		</tr>
		<tr>
			<td>Số điện thoại: </td>
			<td><f:input type="text" path="phoneNumber" /></td>
		</tr>
		<tr>
			<td>Nội dung: </td>
			<td><f:textarea placeholder="Nhập nội dung" path="description"/></td>
		</tr>
		<tr>
			<td>
				<input type="button" onclick="quayLai()" value="Đóng"/> 
				<input type="submit" value="${edit ? 'Lưu':'Thêm' }"/>
			</td>
		</tr>
	</table>
</f:form>
</body>
</html>