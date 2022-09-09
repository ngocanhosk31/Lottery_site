<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				
				<form action="LoadCity">
					<a href="#addModal" class="btn btn-success" data-toggle="modal">
						<i class="material-icons">&#xE147;</i> 
						<span >Thêm mới</span>
					</a> 
				</form>
					<a href="#deleteModal" class="btn btn-danger" data-toggle="modal">
						<i class="material-icons">&#xE15C;</i> 
						<span>Xoá</span>
					</a>
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
				<c:forEach items="${listLottery}" var="lottery">
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
							<a href="DeleteLottery?id=${lottery.id }" class="delete"data-toggle="modal" 
							onclick="return confirm('Bạn có chắc chắn xoá không?')">
							<i class="material-icons"data-toggle="tooltip" title="Delete">&#xE872;</i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</form>
<div>
	<h5 style="color:red">${errorAddL}</h5>
</div>
<div>
	<h5 style="color:red">${errorDeleteL}</h5>
</div>
<div>
	<h5 style="color:green">${messageL}</h5>
</div>
<%session.invalidate(); %>
			<c:if test="${empty listLottery}">
				<h2>Không tìm thấy kết quả</h2>
			</c:if>
		<div class="menuFooter">
			<div>
				<h4>
					<a href="${pageContext.request.contextPath}/AccountController">Quản lý tài khoản</a>
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
				<c:forEach begin="1" end="${endPage}" var="i">
					<li class="page-item">
					<c:if test="${thoiGianS == null && tinhS == null}">
						<a href="LotteryController?page=${i}">${i}</a>
					</c:if>
					<c:if test="${thoiGianS != null || tinhS != null}">
						<a href="SearchController?page=${i}&thoiGian=${thoiGianS}&tinh=${tinhS}">${i}</a>
					</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>

