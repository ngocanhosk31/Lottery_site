<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-4">
					<a href="jsp/home.jsp" style="text-decoration:none;"><h2 style="color:white;">
						<b>Trang chủ</b>
					</h2></a>
				</div>
				<div class="col-sm-3">
					<h2>Xin chào ${accountU.getHoTen() }</h2>
				</div>
				<div class="col-sm-3">
				<a href="#editModal" class="btn btn-success" data-toggle="modal">
		             <span>Chỉnh sửa họ tên</span>
	             </a>
				</div>
				<div class="col-sm-2">
					<a href="#deleteModal" class="btn btn-danger" data-toggle="modal">
						<i class="material-icons">&#xE15C;</i> 
						<span>Xoá</span>
					</a>
				</div>
			</div>
		</div>
		<form action="${pageContext.request.contextPath}/DeleteHistory" id="DeleteLottery" method="POST">
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
					<th>Vé số</th>
					<th>Giải thưởng</th>
					<th>Xoá</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listHistory }" var="history">
					<tr>
						<td>
						<span class="custom-checkbox">
							<input type="checkbox" id="checkbox1" name="idHistory" value="${history.id}">
							<label for="checkbox1"></label>
						</span>
						</td>
						<td>${history.thoiGian}</td>
						<td>${history.tinh}</td>
						<td>${history.veSo}</td>
						<td>${history.giaiThuong}</td>
						<td>
							<a href="DeleteHistory?id=${history.id}" class="delete"data-toggle="modal" 
							onclick="return confirm('Bạn có chắc chắn xoá không?')">
							<i class="material-icons"data-toggle="tooltip" title="Delete">&#xE872;</i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</form>
<c:if test="${empty listHistory}">
	<h2>Không tìm thấy kết quả</h2>
</c:if>
<div>
	<h5 style="color:green">${delMess}</h5>
</div>
<div>
	<h5 style="color:green">${EditMess}</h5>
</div>
<div>
	<h5 style="color:red">${delMessErr}</h5>
</div>
		<div class="menuFooter">
			
				<form action="SearchHistory?page=1" id="formSearch">
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
		<div class="clearfix">
			<ul class="pagination">
				<c:forEach begin="1" end="${endPage}" var="i">
					<li class="page-item">
					<c:if test="${thoiGianH == null && tinhH == null}">
						<a href="HistoryController?page=${i}">${i}</a>
					</c:if>
					<c:if test="${thoiGianH != null || tinhH != null}">
						<a href="SearchHistory?page=${i}&thoiGian=${thoiGianH}&tinh=${tinhH}">${i}</a>
					</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>

