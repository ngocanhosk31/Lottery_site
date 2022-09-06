<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <title>Login 10</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/styleLogin.css"> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/styleLogin1.css">

</head>

<%-- <body class="img js-fullheight" style="background-image: url(${pageContext.request.contextPath}/login/images/bg.jpg);">
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Xổ Số Kiến Thiết</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <div class="login-wrap p-0">
                        <h3 class="mb-4 text-center">Mời bạn điền email để nhận mật khẩu</h3>
                        <h5 style="color:red">${errorEmail}</h5>
                        <form action="${pageContext.request.contextPath}/ForgotPassword" method="POST" class="signin-form">
                        	
                            <div class="form-group">
                                <input type="text" value="${email}" class="form-control" name="email" placeholder="Email" required>
                            </div>
                            
                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary submit px-3">Đi đến đăng nhập</button>
                            </div>
                            
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="${pageContext.request.contextPath}/login/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/main.js"></script>

</body>
 --%>
 <body>
  <div id="wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <form action="${pageContext.request.contextPath}/ForgotPassword" method="POST"  class="col-md-6 p-3 my-3">
                    <h2 class="text-center text-uppercase py-2">Xổ số kiến thiết</h2>
                    <h3 class="text-center py-2">Mời bạn điền email để nhận mã</h3>
                    <h5 style="color:red">${errorEmail}</h5>
                    <div class="form-group">
                        <input type="text" value="${email}" class="form-control" name="email" placeholder="Email" required>
                    </div>
            
            <div class="form-group mt-3">
                <button type="submit" class="form-control btn btn-primary text-uppercase">Gửi mã</button>
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