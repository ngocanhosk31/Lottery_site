<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/styleLogin1.css">
</head>
<body>

    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <form action="${pageContext.request.contextPath}/Login" method="POST" class="col-md-6 p-3 my-3">
                    <h2 class="text-center text-uppercase py-2">Xổ số kiến thiết</h2>
                    <h3 class="text-center py-2">Bạn đã có tài khoản?</h3>
                    <h5 style="color:red">${errorLogin}</h5>
                    <div class="form-group">
                        <input type="text" value="${email}" class="form-control" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group input-icons-login">
                        <input class="form-control" id="password-field1" type="password" value="${password}"  name="password" placeholder="Mật khẩu" required>
                        <span toggle="#password-field1" class="fa fa-fw fa-eye field-icon toggle-password password"></span>
                    </div>
                    <div class="form-group d-flex flex-row">
                        <div class="mr-auto ">
                            <label class="checkbox-wrap checkbox-primary">Ghi nhớ Tài khoản
								<input type="checkbox">
								<span class="checkmark"></span>
							</label>
                        </div>
                        <div>
                            <a href="${pageContext.request.contextPath}/jsp/forgotPassword.jsp">Quên mật khẩu</a>
                        </div>
                    </div>
                    <div class="form-group mt-3">
                        <button type="submit" class="form-control btn btn-primary text-uppercase">Đăng
							nhập</button>
                    </div>
                    <div class="form-group">
                        <p class="w-100 text-center">&mdash; Nếu chưa có tài khoản, mời bạn ấn vào Đăng kí &mdash;</p>
                        <div class="text-center">
                            <a href="jsp/signUp.jsp" class="text-uppercase">Đăng kí</a>
                        </div>
                    </div>
                </form>
            </div>
            </div>
    </div>
    <script src="${pageContext.request.contextPath}/login/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/main.js"></script>
</body> 

</html>