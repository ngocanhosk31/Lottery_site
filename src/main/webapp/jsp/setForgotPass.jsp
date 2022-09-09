<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <title>Set Forgot Password</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/styleLogin.css"> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/styleLogin1.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>

    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <form action="${pageContext.request.contextPath}/ForgotPasswordController" class="col-md-6 p-3 my-3" method="POST">
                    <h2 class="text-center text-uppercase py-2">Xổ số kiến thiết</h2>
                    <h3 class="text-center py-2">Mời bạn nhập mã xác nhận và đặt lại mật khẩu</h3>
                    <h5 style="color:red">${error }</h5>
                    <h5 style="color:red" id='message'></h5>
                    <div class="form-group">
                         <input type="hidden" class="form-control" value="${maXacNhan}" name="maXacNhan1">
                    </div>
                            
                    <div class="form-group">
                        <input type="hidden" class="form-control" value="${email}" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="maXacNhan2" placeholder="Mã xác nhận" required>
                    </div>
                    <div class="form-group">
                        
                        <div class="input-icons">
                            <input id="password-field2" type="password" class="form-control my-3" name="matKhauMoi" 
                                placeholder="Mật khẩu mới (ít nhất 6 kí tự)" onkeyup='check();' required>
                            <span toggle="#password-field2" class="fa fa-fw fa-eye field-icon toggle-password newPass"></span>
                        </div>
                        <div class="input-icons">
                            <input id="password-field3" type="password" class="form-control my-3" name="matKhauXacNhan" 
                                placeholder="Nhập lại mật khẩu" onkeyup='check();' required>
                            <span toggle="#password-field3" class="fa fa-fw fa-eye field-icon  toggle-password confirmPass"></span>
                        </div>



                    </div>
                    <div class="form-group mt-3">
                        <button type="submit" class="form-control btn btn-primary text-uppercase">đi đến đăng nhập</button>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
    <script>
var check = function() {
	  if (document.getElementById('password-field2').value ==
	    document.getElementById('password-field3').value) {
	    
	    document.getElementById('message').innerHTML = 'Mật khẩu mới hợp lệ';
	  } else {
	    
	    document.getElementById('message').innerHTML = 'Mật khẩu mới không khớp';
	  }
	}
</script>

    <script src="${pageContext.request.contextPath}/login/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/main.js"></script>
 	

</body>

</html>