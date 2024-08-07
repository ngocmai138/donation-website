<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản trị</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/admin1/assets/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/static/admin1/assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
	crossorigin="anonymous"></script>

<script
	src="${pageContext.request.contextPath}/static/admin1/assets/js/datatables-simple-demo.js"></script>

<script
	src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<nav th:fragment="html_nav"
			class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
			<!-- Navbar Brand-->
			<a class="navbar-brand ps-3"
				href="${pageContext.request.contextPath}/admin">QUẢN TRỊ</a>
			<!-- Sidebar Toggle-->
			<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
				id="sidebarToggle" href="#!">
				<i class="fas fa-bars"></i>
			</button>
			<!-- Navbar Search-->
			<form
				class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

			</form>
			<!-- Navbar-->
			<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle"
					href="${pageContext.request.contextPath}/main" role="button"><i
						class="fas fa-user fa-fw"></i><span> Trang chủ</span></a></li>
			</ul>
		</nav>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<div th:fragment="html_menu" id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<a class="nav-link"
								href="${pageContext.request.contextPath}/admin/listUser">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý người dùng
							</a> <a class="nav-link"
								href="${pageContext.request.contextPath}/admin/listDonation">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý đợt quyên góp
							</a>
						</div>
					</div>

				</nav>
			</div>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Chi tiết đợt quyên góp</h1>
					<div class="card mb-4">

						<div class="card-body">
							<!--Detail-->
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Mã đợt
										quyên góp:</label> <input type="text" class="form-control"
										id="addname" name="code" value="${donation.code }"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Tên đợt
										quyên góp:</label> <input type="text" class="form-control"
										id="addcost" name="name" value="${donation.name }"
										readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Ngày bắt
										đầu:</label> <input type="date" class="form-control" id="addname"
										name="startDate" value="${donation.startDate }"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Ngày kết
										thúc:</label> <input type="date" class="form-control" id="addcost"
										name="endDate" value="${donation.endDate }"
										readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Tổng tiền
										quyên góp:</label> <input type="text" class="form-control"
										id="addname" name="money" value="${donation.money } VND"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Trạng thái:</label>
									<input type="text" class="form-control" id="addcost"
										name="status"
										value="${statusDonation.getStatusString(donation.status)}"
										readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Tổ chức:</label> <input
										type="text" class="form-control" id="addname"
										name="organizationName" value="${donation.organizationName }"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Số điện
										thoại:</label> <input type="number" class="form-control" id="addcost"
										name="phoneNumber" value="${donation. phoneNumber}"
										readonly="readonly">
								</div>
								<div class="col-12">
									<label for="ct_id" class="col-form-label">Nội dung:</label>
									<textarea name="description" class="form-control" cols="50"
										readonly="readonly">${donation.description }</textarea>
								</div>
							</div>
							<!--Detail-->
							<h3 class="mt-4">Danh sách những người quyên góp</h3>
							<c:if test="${not empty message }">
								<div style="color: green">${message }</div>
							</c:if>
							<table id="datatablesSimple">
								<thead>
									<tr style="background-color: gray !important;">
										<th>Họ Tên</th>
										<th>Tiền quyên góp</th>
										<th>Ngày quyên góp</th>
										<th>Nội dung</th>
										<th>Trạng thái</th>
										<th>Hành động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>

									</tr>
								</tfoot>
								<tbody>
									<input type="hidden" value="${userDonations.size()}" id="dodai" />
									<c:forEach var="u" items="${userDonations }">
										<tr>
											<td>${u.user.fullName }</td>
											<td>${u.money }</td>
											<td>${u.created }</td>
											<td>${u.text }</td>
											<td>${u.status == 0 ? "Chờ xác nhận": u.status == 1 ? "Đã xác nhận" : "Đã hủy xác nhận"}</td>
											<td style="display: flex; justify-content: space-between">
												<c:if test="${u.status==0 }">
													<f:form
														action="${pageContext.request.contextPath }/admin/changeStatusUD">
														<input type="hidden" name="udId" value="${u.id }">
														<input type="hidden" name="action" value="confirm" />
														<input type="submit" style="width: 105px"
															onclick="window.location.href='${changeStatus}'"
															class="btn btn-success" value="Xác nhận" />
													</f:form>
													<f:form
														action="${pageContext.request.contextPath }/admin/changeStatusUD">
														<input type="hidden" name="udId" value="${u.id }">
														<input type="hidden" name="action" value="cancel" />
														<input type="submit" style="width: 150px"
															onclick="window.location.href='${cancelStatus}'"
															class="btn btn-danger" value="Hủy xác nhận" />
													</f:form>
												</c:if>
											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</main>

			<script>

      ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
      })
              .catch(error => {
                console.error(error);
              });

    </script>
			<script>

      var dodai = document.getElementById("dodai").value;
      var a = parseInt(dodai);
      for(var i = 1;i<=a+10;i++){
        var name = "#editor"  + i
        ClassicEditor.create(document.querySelector(name)).then(eidt => {
          console.log("da" + eidt);
        })
                .catch(error => {
                  console.error(error);
                });
      }


    </script>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4"></div>
			</footer>
		</div>
	</div>

	<script src="js/JQuery3.3.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>

</html>
