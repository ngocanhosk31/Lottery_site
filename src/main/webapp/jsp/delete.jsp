<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="deleteModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Xoá</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>Bạn có chắc muốn xoá những bản ghi này?</p>
						<p class="text-warning">
							<small>Hành động này không thể hoàn tác</small>
						</p>
					</div>
					<div class="modal-footer">
					
						<input type="button" class="btn btn-default" data-dismiss="modal"value="Huỷ bỏ">
						<input type="button" id="btndelete" class="btn btn-danger" value="Xoá">
					
					</div>
			</div>
		</div>
	</div>
