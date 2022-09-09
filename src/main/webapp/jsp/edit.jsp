<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <div id="editModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="EditName">
                        <div class="modal-header">
                            <h4 class="modal-title">Chỉnh sửa họ tên</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Họ và tên</label>
                                <input type="text" class="form-control" name="hoTen" required>
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="email" value=${accountU.email }>
                            </div>
                           </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Huỷ bỏ">
                            <input type="submit" class="btn btn-success" value="Thay đổi">
                        </div>
                    </form>
                </div>
            </div>
        </div>