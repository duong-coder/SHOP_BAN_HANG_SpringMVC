<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-main">
	<div class="header-left">
		<div class="logo-name">
			<a href="index.html">
				<h1>Shoppy</h1> <!--<img id="logo" src="" alt="Logo"/>-->
			</a>
		</div>
		<!--search-box-->
		<div class="search-box">
			<form>
				<input type="text" placeholder="Search..." required=""> 
				<input type="submit" value="">
			</form>
		</div>
		<!--//end-search-box-->
		<div class="clearfix"></div>
	</div>
	<div class="header-right">
		<div class="profile_details_left">
			<!--notifications of menu start -->
			<ul class="nofitications-dropdown">
				<li class="dropdown head-dpdn"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"><i class="fa fa-bell"></i><span
						class="badge blue">3</span></a>
					<ul class="dropdown-menu">
						<li>
							<div class="notification_header">
								<h3>You have 3 new notification</h3>
							</div>
						</li>
						<li><a href="#">
								<div class="user_img">
									<img src="<c:url value='/static/image/admin/p5.png'/>" alt="">
								</div>
								<div class="notification_desc">
									<p>Lorem ipsum dolor</p>
									<p>
										<span>1 hour ago</span>
									</p>
								</div>
								<div class="clearfix"></div>
						</a></li>
						<li class="odd"><a href="#">
								<div class="user_img">
									<img src="<c:url value='/static/image/admin/p6.png'/>" alt="">
								</div>
								<div class="notification_desc">
									<p>Lorem ipsum dolor</p>
									<p>
										<span>1 hour ago</span>
									</p>
								</div>
								<div class="clearfix"></div>
						</a></li>
						<li><a href="#">
								<div class="user_img">
									<img src="<c:url value='/static/image/admin/p7.png'/>" alt="">
								</div>
								<div class="notification_desc">
									<p>Lorem ipsum dolor</p>
									<p>
										<span>1 hour ago</span>
									</p>
								</div>
								<div class="clearfix"></div>
						</a></li>
						<li>
							<div class="notification_bottom">
								<a href="#">See all notifications</a>
							</div>
						</li>
					</ul></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<!--notification menu end -->
		<div class="profile_details">
			<ul>
				<li class="dropdown profile_details_drop"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false">
						<div class="profile_img">
							<span class="prfil-img"><img src="<c:url value='/static/image/admin/p1.png'/>" alt="">
							</span>
							<div class="user-name">
								<p>${ userLogin.getName()}</p>
								<span>Administrator</span>
							</div>
							<i class="fa fa-angle-down lnr"></i> <i
								class="fa fa-angle-up lnr"></i>
							<div class="clearfix"></div>
						</div>
				</a>
					<ul class="dropdown-menu drp-mnu">
						<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
						<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
						<li><a href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>