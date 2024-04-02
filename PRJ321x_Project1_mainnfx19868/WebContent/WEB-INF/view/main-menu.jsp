<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main menu</title>
<style>
	/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}
.close{
	cursor:pointer;
}
</style>
</head>
<body>
<h2>Các đợt quyên góp</h2>
<table>
	<c:forEach var="d" items="${donations }">
	<tr>
		<td>
			<b><a href="${pageContext.request.contextPath }/detailDonation?donationId=${d.id }">${d.name }</a> </b> <br>
			${status.getStatusString(d.status) }
		</td>
		<td>
			Ngày bắt đầu <br>
			${d.startDate }
		</td>
		<td>
			Ngày kết thúc <br>
			${d.endDate }
		</td>
		<td>
			${d.organizationName }<br>
			${d.phoneNumber }
		</td>
		<td>
			<input type="button" value="Quyên góp" ${d.status != 1 ? "hidden = 'hidden'":"" } class="donateButton" />
		</td>
	</tr>
<div id="donateModal" class = "modal" style="display:none;">
	<div class="modal-content">
		<span class = "close">&times;</span>
		<p>Thông tin quyên góp</p>
		<form>Form for donate</form>
	</div>
</div>
	</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${totalPage }">
	<a href="${pageContext.request.contextPath }/main?pageSize=${pageSize}&pageNumber=${i}">${i }</a>
</c:forEach>
<script>
	var modal = document.getElementById("donateModal");
	var btns = document.getElementsByClassName("donateButton");
	var span = document.getElementsByClassName("close")[0];
	for(var i = 0; i < btns.length; i++){		
		btns[i].onclick = function(){
			modal.style.display = "block";
		}
	}
	span.onclick = function(){
		modal.style.display = "none";
	}
	window.onclick = function(event){
		if(event.target == modal){
			modal.style.display = "none";
		}
	}
</script>
</body>
</html>