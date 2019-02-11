<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/LOGMIEER PNG LOGO.png" />
<title>Logmieer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js-->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
<!--//js-->
<!--webfonts-->
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!--animate-->
<link
	href="${pageContext.request.contextPath}/resources/css/animate.css"
	rel="stylesheet" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script
	src="${pageContext.request.contextPath}/resources/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/custom.css"
	rel="stylesheet">
<!--//Metis Menu -->


<style type="text/css">

.image {
    position:relative;
    width:400px;
    height:400px;
}
.image img {
    width:100%;
    vertical-align:top;
}
.image:after {
    content:'\A';
    position:absolute;
    width:100%; height:100%;
    top:0; left:0;
    background:rgba(0,0,0,0.6);
    opacity:0;
    transition: all 0.5s;
    -webkit-transition: all 0.5s;
}
.image:hover:after {
    opacity:1;
}

</style>

</head>
<body class=" " style="background-image: url('${pageContext.request.contextPath}/resources/images/kvn.jpg'); background-size: cover;

top: 0;
left: 0;
width: 100%;
height:100vh;">

	<div class=" ">

		 






		<!-- main content start-->
		<div id="">
			<div class="  login-page" style="width: 30% !important;margin-top: 13%;">
			<!-- 	<h3 class="title1">Sign In</h3> -->
	 <p style="text-align: center; color: green;" id="messageAnimation">${msg}</p>
			
				<div class="widget-shadow" style="border-radius: 10px;">
					<div class="login-top" >
 						<h4>Sign in </h4>
 					</div>
					<div class="login-body">
						<form action="${pageContext.request.contextPath}/loginProcess" method="post">
							<input type="text" class="user" name="email" placeholder="Enter your email" required="">
							<input type="password" name="password" class="lock" placeholder="password">
							<input type="submit" name="Sign In" value="Sign In">
							<!-- <div class="forgot-grid">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Remember me</label>
								<div class="forgot">
									<a href="#">forgot password?</a>
								</div>
								<div class="clearfix"> </div>
							</div> -->
						</form>
					</div>
				</div>
				
				 <div class="login-page-bottom">
				 
					<div class="social-btn"></div>
					<div class="social-btn sb-two"><!-- <a href="#"><i class="fa fa-twitter"></i><i>Sign In with Twitter</i></a> --></div>
				</div>  
			</div>
		</div>



		<%--  <jsp:include page="include/footer.jsp" />  --%>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/js/classie.js"></script>

	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document
				.getElementById('showLeftPush'), body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};

		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>

	<!--scrolling js-->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js">
		
	</script>
	<!--validator js-->
	<script
		src="${pageContext.request.contextPath}/resources/js/validator.min.js"></script>
	<!--//validator js-->


	<script type="text/javascript">
		jQuery.fn.ForceNumericOnly = function() {
			return this
					.each(function() {
						$(this)
								.keydown(
										function(e) {
											var key = e.charCode || e.keyCode
													|| 0;
											// allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
											// home, end, period, and numpad decimal
											return (key == 8 || key == 9
													|| key == 13 || key == 46 ||
													// key == 110 ||
													// key == 190 ||
													(key >= 35 && key <= 40)
													|| (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
										});
					});
		};

		$(".cust-mobile").ForceNumericOnly();
	</script>
	<script>
                        setTimeout(function() {
    $('#messageAnimation').fadeOut('slow');
}, 5000);
                        </script>
</body>
</html>