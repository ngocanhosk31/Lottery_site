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
							Quản lý <b>tài khoản</b>
						</h2>
					</div>
					 <div class="col-sm-6">
	                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
		                <i class="material-icons">&#xE147;</i> 
		                <span>Thêm mới</span>
	                </a>
	                <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">
		                <i class="material-icons">&#xE15C;</i> 
		                <span>Xoá</span>
	                </a>
	            </div>
	        </div>
	    </div>
	    
	    <form action="${pageContext.request.contextPath}/DeleteAccount" id="DeleteLottery">
	    	<table class="table table-striped table-hover">
	        	<thead>
	            	<tr>
	                	<th>
	                       <span class="custom-checkbox">
		                        <input type="checkbox" id="selectAll" >
		                        <label for="selectAll"></label>
	                   		</span>
                    	</th>
                        <th>Họ tên</th>
                        <th>Email</th>
                        <th>Vai trò</th>
                        <th>Sửa</th>
                        <th>Xoá</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSAccount}" var="account">
                    <tr>
                    	<td>
                            <span class="custom-checkbox">
	                            <input type="checkbox" id="checkbox1" name="idAccount" value="${account.id}">
	                            <label for="checkbox1"></label>
	                        </span>
                        </td>
                        <td>${account.hoTen }</td>
                        <td><a>${account.email}</a></td>
                        <c:if test="${account.isUser() == true}">
                        	<td>User</td>
                        	<td>
                        		<a href="${pageContext.request.contextPath}/EditAccount?id=${account.id}" class="edit" data-toggle="modal" onclick="return confirm('Bạn muốn đổi quyền truy cập của tài khoản này sang Admin?')">
								<i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i>
								</a>
                        	</td>
                        </c:if>
                        <c:if test="${account.isUser() == false}">
                        	<td>Admin</td>
                        	<td></td>
                        </c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/DeleteAccount?id=${account.id}" class="delete" data-toggle="modal"
                            onclick="return confirm('Bạn có chắc chắn xoá không?')">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>	
                </tbody>
            </table>
       	</form>
       	<div>
			<h5 style="color:red">${errorDelete}</h5>
		</div>
		<div>
			<h5 style="color:red">${errorAdd}</h5>
		</div>
		<div>
			<h5 style="color:green">${message}</h5>
		</div>
		<c:if test="${empty listSAccount}">
				<h3>Không tìm thấy kết quả</h3>
			</c:if>
       <div class="menuFooter">
			<div>
				<h4>
					<a href="${pageContext.request.contextPath}/LotteryController">Quản lý vé số</a>
				</h4>
			</div>
					<div>
				<form action="SearchAccountController?page=1" method="POST">
					<input type="hidden" name="page" value="1" />
					<input type="text" id="searchName" name="ten" placeholder="Tên" />
					<input type="text" id="searchName" name="email" placeholder="Email" />
					<button>Tìm kiếm</button>
				</form>
			</div>
			<div>
       			<a href="${pageContext.request.contextPath}/Login" class="btn btn-info" role="button">Đăng xuất</a>
       </div>
       </div>
			<div class="clearfix">

				<ul class="pagination">
					<c:forEach begin="1" end="${endPage }" var="i"> 
						<li class="page-item">
							<a href="SearchAccountController?page=${i}&ten=${tenS}&email=${emailS}">${i}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<%@include file = "addAccount.jsp" %>
	<%@include file = "deleteAccount.jsp" %>
</body>
<script src="${pageContext.request.contextPath}/manager/js/manager.js"></script>
<script src="${pageContext.request.contextPath}/manager/js/password.js"></script>
</html>