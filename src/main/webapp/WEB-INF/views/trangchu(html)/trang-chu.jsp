<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <link rel="stylesheet" href="static/css/trangchu.css">

</head>

<body>
	
    <div class="container-fluid">
        <div class="header ">
            <nav class="navbar sticky-top navbar-expand-lg navbar-light u-nav-bar">
                <a class="navbar-brand" href="#">
                    <img src="<c:url value="static/image/image-app/logo-shop.jpg" />" alt="" width="80px" height="80px">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto u-nav-bar-center">
                        <li class="nav-item active ">
                            <a class="nav-link u-word-color" href="#">TRANG CHỦ <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link u-word-color" href="#">SẢN PHẨM</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link u-word-color" href="#">DỊCH VỤ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link u-word-color" href="#">LIÊN HỆ</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item active ">
                            <a class="nav-link u-word-color" href="#">ĐĂNG NHẬP</a>
                        </li>
                        <li class="nav-item active ">
                            <a class="nav-link u-word-color" href="#">ĐĂNG XUẤT</a>
                        </li>
                    </ul>
                    <a class="navbar-brand" href="#">
                        <img src="<c:url value="static/image/image-app/icons8-shopping-cart-64.png" />"alt="" width="50px" height="50px">
                    </a>
                </div>
            </nav>
            <div class="container h-90 ">
                <div class="row align-items-center h-100 ">
                    <div class="col-6 mx-auto">
                        <div class="jumbotron text-center u-card-content">
                            <div class="card-body ">
                                <p class="card-text u-word-color">Ngày 23/07 - 01/08/2020</p>
                                <h1 class="card-title u-word-color">MUA 1 TẶNG 1</h1>
                                <a href="#" class="btn bg-success u-word-color">XEM NGAY</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <div class="text-center u-margin-card-group">
            <div class="card-group ">
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-gold-medal-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">CHẤT LƯỢNG</h3>
                        <p class="card-text">Chúng tôi cam kết mang sẽ đến cho các bạn chất lượng sản phẩm tốt nhất</p>
                    </div>
                </div>
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-money-box-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">TIẾT KIỆM CHI PHÍ</h3>
                        <p class="card-text">Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản
                            phẩm</p>
                    </div>
                </div>
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-car-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">GIAO HÀNG</h3>
                        <p class="card-text">Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho
                            quý khách nhanh nhất</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container text-center u-box-san-pham">
            <h2 class="u-title-sanpham">SẢN PHẨM HOT</h2>
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card h-100">
                        <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" class="card-img-top u-image-san-pham"
                            alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Iphone 12</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">10.000.000 VND</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class=" container-fluid footer">
            <div class="text-center u-word-color">
                <div class="card-group ">
                    <div class="card u-border-card u-card-content">
                        <div class="card-body">
                            <h3 class="card-title">THÔNG TIN SHOP</h3>
                            <p class="card-text text-left">Online Shop là một cửa hàng điện thoại đầy uy tín
                                đảm bảo chất lượng tốt nhất cho khách hàng
                            </p>
                        </div>
                    </div>
                    <div class="card u-border-card u-card-content ">
                        <div class="card-body">
                            <h3 class="card-title">LIÊN HỆ</h3>
                            <div class="card-text text-left">
                                <p>137/10/5 Tô Hiệu, phường Hòa Minh, quận Liên Chiểu, TP. Đà Nẵng</p>
                                <p>duongakvip1@gmail.com</p>
                                <p>0397250138</p>
                                <p>0773314448</p>
                            </div>
                        </div>
                    </div>
                    <div class="card u-border-card u-card-content">
                        <div class="card-body">
                            <h3 class="card-title">GÓP Ý</h3>
                            <form class="card-text text-left">
                                <input class="form-control" type="email" placeholder="Email">
                                <div class="form-group u-text-area">
                                    <textarea class="form-control" id="exampleFormControlTextarea1"
                                        placeholder="Nội dung" rows="3"></textarea>
                                </div>
                                <button type="button" class="btn btn-success btn-lg btn-block">Đồng ý</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>