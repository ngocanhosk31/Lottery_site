<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Add Modal HTML -->
	<div id="addModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="AddLottery" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Thêm mới</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Thời gian</label> 
							<input type="date" id="start" name="thoiGian" min="1990-01-01" max="2023-12-31" required>
						</div>
						<div class="form-group">
							<label>Tỉnh</label>
							
							<select name="tinh" class="form-control">
							
								<c:forEach items = "${listCity}" var="i"> 
									<option>${i}</option>
									
								</c:forEach>
							</select>

						</div>
						<div class="form-group">
							<label>Giải đặc biệt</label>
							<input name="giaiDacBiet" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải nhất</label> 
							<input name="giaiNhat" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải nhì</label>
							<input name="giaiNhi" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải ba</label>
							<input name="giaiBa" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải tư</label>
							<input name="giaiTu" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải năm</label>
							<input name="giaiNam" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải sáu</label>
							<input name="giaiSau" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải bảy</label>
							<input name="giaiBay" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Giải tám</label>
							<input name="giaiTam" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Huỷ bỏ">
						<input type="submit" class="btn btn-success" value="Thêm">
					</div>
				</form>
			</div>
		</div>
	</div>
    