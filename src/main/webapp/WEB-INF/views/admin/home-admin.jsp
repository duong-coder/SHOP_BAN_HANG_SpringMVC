<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../layouts/head-home.jsp"></jsp:include>
<link rel="stylesheet" href="<c:url value='/static/css/admin/style.css'/>">
<style>
        body {
            height: 1000px;
        }
        
        .copyrights {
            margin-top: 565px;
        } 
        
    </style>
</head>
<body>
	<div class="page-container">
        <div class="left-content">
            <div class="mother-grid-inner">
                <!--header start here-->
				<jsp:include page="../../layouts/admin/header.jsp"></jsp:include>
				<!--heder end here-->
                <!-- script-for sticky-nav -->
                <script>
                    $(document).ready(function() {
                        var navoffeset = $(".header-main").offset().top;
                        $(window).scroll(function() {
                            var scrollpos = $(window).scrollTop();
                            if (scrollpos >= navoffeset) {
                                $(".header-main").addClass("fixed");
                            } else {
                                $(".header-main").removeClass("fixed");
                            }
                        });

                    });
                </script>
                <!-- /script-for sticky-nav -->
                <!--inner block start here-->
                <div class="inner-block">
                    <!--market updates updates-->
                    <div class="market-updates">
                        <div class="col-md-4 market-update-gd">
                            <div class="market-update-block clr-block-1">
                                <div class="col-md-8 market-update-left">
                                    <h3>${amountUser }</h3>
                                    <h4>Registered User</h4>
                                    <p>Other hand, we denounce</p>
                                </div>
                                <div class="col-md-4 market-update-right">
                                    <i class="fa fa-file-text-o"> </i>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="col-md-4 market-update-gd">
                            <div class="market-update-block clr-block-2">
                                <div class="col-md-8 market-update-left">
                                    <h3>${amountProduct }</h3>
                                    <h4>Product in shop</h4>
                                    <p>Other hand, we denounce</p>
                                </div>
                                <div class="col-md-4 market-update-right">
                                    <i class="fa fa-cubes"> </i>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="col-md-4 market-update-gd">
                            <div class="market-update-block clr-block-3">
                                <div class="col-md-8 market-update-left">
                                    <h3>${amountOrderShipping }</h3>
                                    <h4>New Messages</h4>
                                    <p>Other hand, we denounce</p>
                                </div>
                                <div class="col-md-4 market-update-right">
                                    <i class="fa fa-envelope-o"> </i>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <!--climate end here-->
                </div>
                <!--inner block end here-->
                <!--copy rights start here-->
                <jsp:include page="../../layouts/admin/footer.jsp"></jsp:include>
                <!--COPY rights end here-->
            </div>
        </div>
        <!--slider menu-->
        <jsp:include page="../../layouts/admin/slidebar-menu.jsp"></jsp:include>
        <div class="clearfix"> </div>
    </div>
    <script type="text/javascript" src="<c:url value='/static/js/admin/scripts.js'/>"></script>
</body>
</html>