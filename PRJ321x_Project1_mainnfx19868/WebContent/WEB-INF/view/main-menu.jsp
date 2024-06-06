<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	cursor: pointer;
}
</style>
</head>
<body>
<f:form action="${pageContext.request.contextPath }/admin">
	<input type="submit" value="Đăng nhập" />
</f:form>
	<h2>Các đợt quyên góp</h2>
	<c:if test="${not empty message }">
		<div style="color:green;">
			${message }
		</div>
	</c:if>
	<table>
		<c:forEach var="d" items="${donations }" varStatus="loop">
			<tr>
				<td><b><a
						href="${pageContext.request.contextPath }/detailDonation?donationId=${d.id }">${d.name }</a>
				</b> <br> ${status.getStatusString(d.status) }</td>
				<td>Ngày bắt đầu <br> ${d.startDate }
				</td>
				<td>Ngày kết thúc <br> ${d.endDate }
				</td>
				<td>${d.organizationName }<br> ${d.phoneNumber }
				</td>
				<td><input type="button" value="Quyên góp"
					${d.status != 1 ? "hidden = 'hidden'":"" } class="donateButton"
					data-modal-target="#donateModal${loop.index }" />
					<div id="donateModal${loop.index }" class="modal"
						style="display: none;">
						<div class="modal-content">
							<span class="close">&times;</span>
							<p>Quyên góp: ${d.name }</p>
							<f:form modelAttribute="donate" action="${pageContext.request.contextPath }/addDonate">
								<table>
									<tr>
										<td>Họ tên <br> <input type="text"
											 value="${user.fullName }" readonly/>
										</td>
									</tr>
									<tr>
										<td>Số tiền quyên góp<br> <input type="text"
											name="money" />
										</td>
									</tr>
									<tr>
										<td>Lời nhắn<br> <input type="text" name="text" />
										</td>
									</tr>
									<tr>
										<td><input type="hidden" name="userId"
											value="${user.id }" /> <br> 
											<input type="hidden"
											name="donationId" value="${ d.id}" />
										</td>
									</tr>
									<tr>
										<td><input type="button" value="Đóng" class="close" /> <input
											type="submit" value="Quyên góp" /></td>
									</tr>
								</table>
							</f:form>
						</div>
					</div></td>
			</tr>

		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a
			href="${pageContext.request.contextPath }/main?pageSize=${pageSize}&pageNumber=${i}">${i }</a>
	</c:forEach>
	<script>
		var btns = document.getElementsByClassName("donateButton");
		var closeButtons = document.getElementsByClassName("close");
		var modal;
		for (var i = 0; i < btns.length; i++) {
			btns[i].onclick = function() {
				modal = document.querySelector(this
						.getAttribute("data-modal-target"));
				modal.style.display = "block";
				}
				closeButtons[i].onclick = function() {
					modal.style.display = "none";
				}
				window.onclick = function(event) {
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
		}
	</script>
</body>
</html>