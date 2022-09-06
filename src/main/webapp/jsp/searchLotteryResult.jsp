<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý vé số</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/manager/css/styleManager.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Quản lý <b>vé số</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm
								mới</span></a> <a href="#deleteEmployeeModal" class="btn btn-danger"
							data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Xoá</span></a>
					</div>
				</div>
			</div>
			<form action="${pageContext.request.contextPath}/DeleteLottery" id="DeleteLottery" method="POST">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>Thời gian</th>
						<th>Tỉnh</th>
						<th>Giải đặc biệt</th>
						<th>Giải nhất</th>
						<th>Giải nhì</th>
						<th>Giải ba</th>
						<th>Giải tư</th>
						<th>Giải năm</th>
						<th>Giải sáu</th>
						<th>Giải bảy</th>
						<th>Giải tám</th>
						<th>Sửa</th>
						<th>Xoá</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listSLottery }" var="lottery">
						<tr>
							<td>
								<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="idLottery" value="${lottery.id}">
								<label for="checkbox1"></label>
							</span>
							</td>
							<td>${lottery.thoiGian}</td>
							<td>${lottery.tinh}</td>
							<td>${lottery.giaiDacBiet}</td>
							<td>${lottery.giaiNhat}</td>
							<td>${lottery.giaiNhi}</td>
							<td>${lottery.giaiBa}</td>
							<td>${lottery.giaiTu}</td>
							<td>${lottery.giaiNam}</td>
							<td>${lottery.giaiSau}</td>
							<td>${lottery.giaiBay}</td>
							<td>${lottery.giaiTam}</td>
						<td>
							<a href="LoadLottery?id=${ lottery.id}" class="edit" data-toggle="modal">
							<i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
							</a>
						</td>
							<td>
								<a href="DeleteLottery?id=${lottery.id}" class="delete" data-toggle="modal" 
								onclick="return confirm('Bạn có chắc chắn xoá không?')">
								<i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
							</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
			<c:if test="${empty listSLottery}">
				<h2>Không tìm thấy kết quả</h2>
			</c:if>
			<div class="menuFooter">
				<div>
					<h4>
						<a href="AccountController">Quản lý tài khoản</a>
					</h4>
				</div>
				<div>
				<form action="SearchController?page=1" id="formSearch">
					<input type="hidden" name="page" value="1" />
					<table>
                    <tr>
                    <td><label>Thời gian</label></td>
					<td><input type="date" id="start" name="thoiGian" min="1990-01-01" max="2023-12-31"></td>
					</tr>
					<tr>
					<td> <label>Tỉnh</label> </td>
					<td><select name="tinh" class="form-control">
							<option selected></option>
								<c:forEach items = "${listCity}" var="i"> 
									<option>${i}</option>						
								</c:forEach>
							</select></td>
							</tr>
					<tr><td><button>Tìm kiếm</button></td></tr>
					</table>
				</form>
			</div>
			<div>
       			<a href="${pageContext.request.contextPath}/Logout" class="btn btn-info" role="button">Đăng xuất</a>
       </div>
			</div>
			<div class="clearfix">

				<ul class="pagination">
					<c:forEach begin="1" end="${endPage }" var="i"> 
						<li class="page-item">
							<a href="SearchController?page=${i}&thoiGian=${thoiGianS}&tinh=${tinhS}">${i}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<%@include file = "addLottery.jsp" %>
	<%@include file = "deleteLottery.jsp" %>
</body>
<script src="${pageContext.request.contextPath}/manager/js/manager.js"></script>

</html>