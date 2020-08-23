<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="static/css/gio-hang.css">
</head>
<body>
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
                    <img src="<c:url value="static/image/image-app/icons8-shopping-cart-64.png" />" alt="" width="50px" height="50px">
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
    <div class="container body-carts">
        <p class="my-cart">Đơn hàng của tôi</p>
        <div class="select-amount-cart">
            <label for="amount-cart">Hiển thị:</label>
            <select name="amount-cart" id="amount-cart">
                <option value="5">5 đơn hàng gần nhất</option>
                <option value="10">10 đơn hàng gần nhất</option>
                <option value="15">15 đơn hàng gần nhất</option>
            </select>
        </div>
        <div class="cart">
            <div class="row title-cart">
                <div class="col-10 id-date-cart">
                    <p class="id-cart">Đơn hàng:#251026803831791</p>
                    <p class="date-cart">Đặt ngày 20 thg 7 2020 19:48:22</p>
                </div>
                <p class="col-2 text-center detail-cart">Chi tiết</p>
            </div>
            <hr>
            <div class="row content-cart">
                <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" alt="" width="100px">
                <p class="col">Iphone 12 Pro Max</p>
                <p class="col">Số lượng: 1</p>
                <div class="col status-item-cart">
                    Đã giao hàng
                </div>
                <p class="col">Đã giao ngày 25 thg 6 2020</p>
            </div>
            <div class="row content-cart">
                <img src="<c:url value="static/image/image-products/iphone-12-pro-max-600x600.jpg" />" alt="" width="100px">
                <p class="col">Iphone 12 Pro Max</p>
                <p class="col">Số lượng: 1</p>
                <p class="col status-item-cart">Đã giao hàng</p>
                <p class="col">Đã giao ngày 25 thg 6 2020</p>
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