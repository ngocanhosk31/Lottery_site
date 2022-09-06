<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý lịch sử</title>
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

<script src="https://cdn.bootcdn.net/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div class="container">
	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-4">
					<h2>
						Quản lý <b>lịch sử dò</b>
					</h2>
				</div>
				<c:if test="${listHistory != null} ">
				<div class="col-sm-4">
					<h2>Tên người dùng: ${listHistory.get(0).hoTen}</h2>
				</div>
				</c:if>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Thời gian</th>
					<th>Tỉnh</th>
					<th>Vé số</th>
					<th>Giải thưởng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listHistory }" var="history">
					<tr>
					<td></td>
						<td>${history.thoiGian}</td>
						<td>${history.tinh}</td>
						<td>${history.veSo}</td>
						<td>${history.giaiThuong}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
		<div class="col-sm-6">
				<h4>
					<a href="${pageContext.request.contextPath}/AccountController">Quản lý tài khoản</a>
				</h4>
		</div>
		<div class="clearfix col-sm-6">
			<ul class="pagination">
				<c:forEach begin="1" end="${endPage}" var="i">
					<li class="page-item">
						<a href="HistoryU?page=${i}&email=${listHistory.get(0).email}">${i}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	</div>
</div>
	<script src="${pageContext.request.contextPath}/manager/js/manager.js"></script>
	<script src="${pageContext.request.contextPath}/manager/js/submit.js"></script> 
</body>

</html>