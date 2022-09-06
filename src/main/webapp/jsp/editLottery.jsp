<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
crossorigin="anonymous">

</head>
<body>
       <div class="container">
           
              <form action="EditLottery" method="POST">
                  <div class="modal-header">
                      <h4 class="p-1 my-1 bg-dark text-white">Chỉnh sửa vé số</h4>
					  <h5 style="color:red">${errorEdit}</h5>
                  </div>
                  <div>
                  	
					<input name="id" type="hidden" class="form-control" value="${lottery.id }">
				
				<table class="table table-striped">
				<tr>
				
					<td><label>Thời gian</label></td>
					 <td><input type="date" name="thoiGian" min="1990-01-01" max="2023-12-31" required
					 value="${lottery.thoiGian }" ></td>
				</tr>
				<tr>
					<td><label>Tỉnh</label></td>
					
					<td><select name="tinh" class="form-control">
					<option selected>${lottery.tinh}</option>
						<c:forEach items = "${listCity}" var="i">
							<option>${i}</option>	
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label>Giải đặc biệt</label></td>
					<td><input name="giaiDacBiet" type="text" class="form-control" required
					value="${lottery.giaiDacBiet }"></td>
				</tr>
				<tr>
					<td><label>Giải nhất</label></td>
					<td><input name="giaiNhat" type="text" class="form-control" required
					value="${lottery.giaiNhat }"></td>
				</tr>
				<tr>
					<td><label>Giải nhì</label></td>
					<td><input name="giaiNhi" type="text" class="form-control" required
					value="${lottery.giaiNhi }"></td>
				</tr>
				<tr>
					<td><label>Giải ba</label></td>
					<td><input name="giaiBa" type="text" class="form-control" required
					value="${lottery.giaiBa }"></td>
				</tr>
				<tr>
					<td><label>Giải tư</label></td>
					<td><input name="giaiTu" type="text" class="form-control" required
					value="${lottery.giaiTu }"></td>
				</tr>
				<tr>
					<td><label>Giải năm</label></td>
					<td><input name="giaiNam" type="text" class="form-control" required
					value="${lottery.giaiNam }"></td>
				</tr>
				<tr>
					<td><label>Giải sáu</label></td>
					<td><input name="giaiSau" type="text" class="form-control" required
					value="${lottery.giaiSau }"></td>
				</tr>
				<tr>
					<td><label>Giải bảy</label></td>
					<td><input name="giaiBay" type="text" class="form-control" required
					value="${lottery.giaiBay }"></td>
				</tr>
				<tr>
					<td><label>Giải tám</label></td>
					<td><input name="giaiTam" type="text" class="form-control" required
					value="${lottery.giaiTam }"></td>
				</tr>
				</table>
			</div>
               <div class="modal-footer">
                   <a href="LotteryController"><input type="button" class="btn btn-default" data-dismiss="modal" value="Huỷ bỏ"></a>
                   <input type="submit" class="btn btn-info" value="Lưu">
               </div>
      		</form>
	</div>
</body>
</html> 