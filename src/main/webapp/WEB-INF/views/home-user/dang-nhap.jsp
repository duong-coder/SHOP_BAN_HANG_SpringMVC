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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/dang-nhap.css">

</head>
<body>
    <div class="container justify-content-center login-form ">
        <div id="image-login" class="col-6 text-center">
            <p class="text-intro"><Span>Hãy chọn điện thoại theo phong cách của bạn</Span></p>
        </div>
        <div id="form-login" class="col-5">
            <p>Xin chào!</p>
            <h6>
            	<a href="<c:url value='/sign-in'/>"><span>Đăng nhập</span></a>/
            	<a href="<c:url value='/sign-up'/>"><span style="color: gray;">Đăng ký</span></a>
            </h6>
            <div id="logo-login" class="d-flex justify-content-center">
                <img src="static/image/image-app/logo-shop.jpg" alt="" width="100px">
            </div>
            <c:url value="/sign-in" var="urlSignIn"/>
            <form:form action="${urlSignIn }" method="post">
                <div class="form-group flex-nowrap">
                    <label for="exampleInputEmail1">Email address</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" ><i class="fa fa-envelope"></i></span>
                        </div>
                        <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    
                </div>
                <div class="form-group flex-nowrap">
                    <label for="exampleInputPassword1">Password</label>
                    <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="addon-wrapping" style="font-size: 24px"><i class="fa fa-lock"></i></span>
                        </div>
                        <input type="password" class="form-control" name="password" id="exampleInputPassword1">
                    </div>
                    
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form:form>
        </div>
    </div>
</body>
</html>