<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/6be531c36f.js" crossorigin="anonymous"></script>
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/styleHome.css">
</head>

<body>

    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <div class="container-fluid">
            <a href="#" class="navbar-branch">
                <img src="${pageContext.request.contextPath}/home/img/download.png" height="80px" class="logo">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                <c:if test="${sessionScope.accountU != null}">
                    <li class="nav-item nav-link active">Xin chào ${sessionScope.accountU.hoTen }</li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/HistoryController" class="nav-link">Lịch sử dò</a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/Logout" class="nav-link">Đăng xuất</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountU == null}">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/Login" class="nav-link">Đăng nhập</a>
                    </li>
                </c:if>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <h2 class="my-2 text-center">Tra cứu xổ số</h2>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6 row-container">
                <p><b>Để dò vé số xổ số 3 Miền</b> bạn làm theo các bước sau:</p>
                <p>- <b class="text-danger">Chọn ngày</b> và <b class="text-danger">chọn tỉnh</b> muốn dò vé số</p>
                <p>- <b class="text-danger">Nhập số</b> trên tờ vé số</p>
                <p>- Click vào nút "<b class="text-danger">Dò vé</b>" để xem kết quả dò số trúng thưởng xổ số 3 Miền</p>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6 row-container">
                <form action="${pageContext.request.contextPath}/CheckLottery" method="POST">
                    <table>
                        <tr>
                            <td><label>Tỉnh</label></td>
                            <td>
                            <select name="tinh" class="form-control">
                            	<option selected></option>
	                            <c:forEach items = "${listCity}" var="i">
									<option>${i}</option>	
								</c:forEach>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td> <label>Thời gian</label> </td>
                            <td><input type="date" id="start" name="thoiGian" min="1990-01-01" max="2023-12-31" required></td>
                        </tr>
                        <tr>
                            <td> <label>Mã số</label> </td>
                            <td><input name="maSo" type="text" class="form-control" placeholder="Mã số" required>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button>Dò vé</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row justify-content-center">
            <h3 class="my-2 text-center" style="color:green;">${result}</h3>
        </div>
    </div>
</body>

</html>