<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Swastik Truckage</title>
<meta name="viewport" content="width=device-width">
<meta name="mobile-web-app-capable" content="yes">

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
<link
	href="${pageContext.request.contextPath}/resources/css/lightbox.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

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
<body>

	<div class="limiter">


		<div class="container-login100"
			style=" background-image: url('${pageContext.request.contextPath}/resources/images/login_back.jpg'); background-size: cover;

top: 0;
left: 0;
width: 100%;
height: 100%;
z-index: -2;
">
			<div class="wrap-login100">
				<span style="color: red;" id="messageAnimation">${message}</span>
				<form class="login100-form validate-form"
					action="${pageContext.request.contextPath}/staffLoginProcess"
					method="post">


					<img alt=""
						src="${pageContext.request.contextPath}/resources/images/swastik_logo.png"
						style="display: block; margin-left: auto; margin-right: auto; width: 35%; height: 40%">

					<br> <span class="login100-form-title p-b-26">Login </span>


					<div class="wrap-input100 validate-input"
						data-validate="Enter Mobile No">
						<input class="input100" type="text" name="contactNo"
							autocomplete="off"> <span class="focus-input100"
							data-placeholder="Mobile No"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<span class="btn-show-pass"> <i class="zmdi zmdi-eye"></i>
						</span> <input class="input100" type="password" name="password"
							autocomplete="off"> <span class="focus-input100"
							data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Sign In</button>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>

 

	<script type="text/javascript">
		if ($("#userName").val().length !== 0
				&& $.trim($('#userName').val()) !== ''
				&& $("#password").val().length !== 0
				&& $.trim($('#password').val()) !== '') {

			$('#submitLogin').removeAttr('disabled');
		} else {
			$('#submitLogin').attr('disabled', "");
		}
	</script>


</body>
</html>