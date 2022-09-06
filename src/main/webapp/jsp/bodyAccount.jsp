<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="table-wrapper">
	    <div class="table-title">
	        <div class="row">
	            <div class="col-sm-6">
	                <h2>Quản lý <b>tài khoản</b></h2>
	            </div>
	            <div class="col-sm-6">
	                <a href="#addModal" class="btn btn-success" data-toggle="modal">
		                <i class="material-icons">&#xE147;</i> 
		                <span>Thêm mới</span>
	                </a>
	                <a href="#deleteModal" class="btn btn-danger" data-toggle="modal">
		                <i class="material-icons">&#xE15C;</i> 
		                <span>Xoá</span>
	                </a>
	            </div>
	        </div>
	    </div>
	    <form action="${pageContext.request.contextPath}/DeleteAccount" id="DeleteAccount" method="POST">
	    	<table class="table table-striped table-hover">
	        	<thead>
	            	<tr>
	                	<th><span class="custom-checkbox">
	                        <input type="checkbox" id="selectAll" >
	                        <label for="selectAll"></label></span></th>
                        <th>Họ tên</th>
                        <th>Email</th>
                        <th>Vai trò</th>
                        <th>Sửa</th>
                        <th>Xoá</th></tr>
                </thead>
                <tbody>
                <c:forEach items="${listAccount}" var="account">
                    <tr>
                    	<td>
                            <span class="custom-checkbox">
	                            <input type="checkbox" id="checkbox1" name="idAccount" value="${account.id}">
	                            <label for="checkbox1"></label>
	                        </span>
                        </td>
                        <td>${account.hoTen }</td>
                        <c:if test="${account.isUser() == true}">
                        	<td><a href="${pageContext.request.contextPath}/HistoryU?email=${account.email}">${account.email}</a></td>
                        	<td>User</td>
                        	<td>
                        		<a href="${pageContext.request.contextPath}/EditAccount?id=${account.id}" class="edit" data-toggle="modal" onclick="return confirm('Bạn muốn đổi quyền truy cập của tài khoản này sang Admin?')">
								<i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i>
								</a>
                        	</td>
                        </c:if>
                        <c:if test="${account.isUser() == false}">
                        	<td>${account.email}</td>
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
			<h5 style="color:red">${errorDeleteA}</h5>
		</div>
		<div>
			<h5 style="color:red">${errorAddA1}</h5>
		</div>
		<div>
			<h5 style="color:red">${errorAddA2}</h5>
		</div>
		<div>
			<h5 style="color:green">${messageA}</h5>
		</div>
		<div>
			<h5 style="color:green">${messA}</h5>
		</div>
		<%session.invalidate(); %>
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
       			<a href="${pageContext.request.contextPath}/Logout" class="btn btn-info" role="button">Đăng xuất</a>
       		</div>
       </div>
        <div class="clearfix">
			<ul class="pagination">
				<c:forEach begin="1" end="${endPage}" var="i">
					<li class="page-item"><a href="AccountController?page=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</div>    
	</div>
</div>
