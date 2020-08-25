<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	
	<jsp:include page="../../layouts/head-home.jsp"/>
	
	<link rel="stylesheet" href="static/css/dang-ky.css">

</head>
<body>
    <div class="container d-flex justify-content-center  login-form ">
        <div id="form-login" class="">
            <p>Xin chào!</p>
            <h6><span style="color: gray;">Đăng nhập</span>/<span>Đăng ký</span></h6>
            <div id="logo-login" class="d-flex justify-content-center">
                <img src="./image/logo-shop.jpg" alt="" width="100px">
            </div>
            <c:url value="/sign-up" var="urlSignUp"/>
            <form:form action="${urlSignUp }" modelAttribute="userRegister" method="post" >
                <div class="form-group flex-nowrap">
                    <label for="fullname">Họ tên</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" ><i class="fa fa-address-card"></i></span>
                        </div>
                        <form:input path="name" type="text" class="form-control" id="fullname" aria-describedby="emailHelp" />
                    </div>
                </div>
                <div class="form-group flex-nowrap">
                    <label for="Email">Email</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" ><i class="fa fa-envelope"></i></span>
                        </div>
                        <form:input path="email" type="email" class="form-control" id="Email" aria-describedby="emailHelp" />
                    </div>
                </div>
                <div class="form-group flex-nowrap">
                    <label for="username">Tên đăng nhập</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" ><i class="fa fa-address-card"></i></span>
                        </div>
                        <form:input path="username" type="text" class="form-control" id="username" aria-describedby="emailHelp" />
                    </div>
                </div>
                <div class="form-group flex-nowrap">
                    <label for="password">Mật khẩu</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" style="font-size: 24px"><i class="fa fa-lock"></i></span>
                        </div>
                        <form:input path="pass" type="password" class="form-control" id="password"/>
                    </div>
                </div>
                <!-- <div class="form-group flex-nowrap">
                    <label for="confirmPassword">Xác nhận mật khẩu</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" style="font-size: 24px"><i class="fa fa-lock"></i></span>
                        </div>
                        <input type="password" class="form-control" id="confirmPassword">
                    </div>
                </div> -->
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">
                        <span style="color: green;">Chấp nhận điều khoản sử dụng của chúng tôi.</span>
                    </label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form:form>
        </div>
    </div>
</body>
</html>