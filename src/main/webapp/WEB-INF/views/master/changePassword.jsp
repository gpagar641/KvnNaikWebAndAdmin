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




</head>
<body class="cbp-spmenu-push">

	<div class="main-content">

		<jsp:include page="../include/left.jsp" />
		<jsp:include page="../include/header.jsp" />






		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
								 <p style="text-align: center; color: green;" id="messageAnimation">${msg}</p>
			
				<div class="forms validation">
					<!-- <h3 class="title1">Validation Forms :</h3> -->
					<!-- <div class="form-three widget-shadow">
						<div data-example-id="form-validation-states"> 
							<form> <div class="form-group has-success"> <label class="control-label" for="inputSuccess1">Input with success</label> <input type="text" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2"> <span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span> </div> <div class="form-group has-warning"> <label class="control-label" for="inputWarning1">Input with warning</label> <input type="text" class="form-control" id="inputWarning1"> </div> <div class="form-group has-error"> <label class="control-label" for="inputError1">Input with error</label> <input type="text" class="form-control" id="inputError1"> </div> <div class="has-success"> <div class="checkbox"> <label> <input type="checkbox" id="checkboxSuccess" value="option1"> Checkbox with success </label> </div> </div> <div class="has-warning"> <div class="checkbox"> <label> <input type="checkbox" id="checkboxWarning" value="option1"> Checkbox with warning </label> </div> </div> <div class="has-error"> <div class="checkbox"> <label> <input type="checkbox" id="checkboxError" value="option1"> Checkbox with error </label> </div> </div> </form> 
						</div>
					</div> -->
					<div class="row">

						<div class="col-md-3 validation-grids" style="width: 25%;">
						</div>

						<div class="col-md-6 validation-grids widget-shadow"
							data-example-id="basic-forms">
							<div class="form-title">
								<h4>Department Registration Form :</h4>
							</div>
							<div class="form-body">
							
								<form data-toggle="validator" method="post" action="${pageContext.request.contextPath}/submitChangePassword">
									 
									 
									<div class="form-group">
										<input type="password" data-toggle="validator"
											data-minlength="6" class="form-control" id="inputPassword" name="password"
											placeholder="Password" required> <span
											class="help-block">Minimum of 6 characters</span>
									</div>
									<div class="form-group">
										<input type="password" class="form-control"
											id="inputPasswordConfirm" data-match="#inputPassword"
											data-match-error="Whoops, these don't match"
											placeholder="Confirm password" required>
										<div class="help-block with-errors"></div>
									</div>
									 
									
									<!-- <div class="form-group">
										<div class="radio">
											<label> <input type="radio" name="gender" required>
												Female
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="gender" required>
												Male
											</label>
										</div>
									</div> -->
									<!-- <div class="form-group">
										<div class="checkbox">
											<label>
												<input type="checkbox" id="terms" data-error="Before you wreck yourself" required>
												I have read and accept terms of use.
											</label>
											<div class="help-block with-errors"></div>
										</div>
									</div> -->
									<div class="form-group">
										<button type="submit"  class=" btn-primary" >Submit</button>
									</div>
								</form>
							</div>
						</div>

						<div class="col-md-3 validation-grids validation-grids-right">
						</div>
						<!-- <div class="col-md-6 validation-grids validation-grids-right">
						 
							<div class="widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
									<h4>Login form :</h4>
								</div>
								<div class="form-body">
									<form data-toggle="validator">
										<div class="form-group has-feedback">
											<input type="email" class="form-control" id="inputEmail" placeholder="Enter Your Email" data-error="Bruh, that email address is invalid" required>
											<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
										</div>
										<div class="form-group">
											<input type="password" data-toggle="validator" data-minlength="6" class="form-control" id="inputPassword" placeholder="Password" required>
										</div>
										<div class="bottom">
											<div class="form-group">
												<div class="checkbox">
													<label>
														<input type="checkbox" id="terms" data-error="Before you wreck yourself" required>
														Remember me
													</label>
													<div class="help-block with-errors"></div>
												</div>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary disabled">Login</button>
											</div>
											<div class="clearfix"> </div>
										</div>
									</form>
								</div>
							</div>
							<div class="inline-form widget-shadow">
								<div class="form-title">
									<h4>Recover form :</h4>
								</div>
								<div class="form-body">
									<form data-toggle="validator">
										<div class="form-group has-feedback">
											<input type="email" class="form-control" id="inputEmail" placeholder="Email" data-error="Bruh, that email address is invalid" required>
											<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
										</div>
										<div class="form-group">
											<input type="text" data-toggle="validator" data-minlength="6" class="form-control" id="inputPassword" placeholder="Enter your phone number" required>
										</div>
										<div class="bottom">
											<div class="form-group">
												<button type="submit" class="btn btn-primary disabled">Login</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div> -->
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>


		<jsp:include page="../include/footer.jsp" />
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
	 
	 jQuery.fn.ForceNumericOnly =
		 function()
		 {
		     return this.each(function()
		     {
		         $(this).keydown(function(e)
		         {
		             var key = e.charCode || e.keyCode || 0;
		             // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
		             // home, end, period, and numpad decimal
		             return (
		                 key == 8 || 
		                 key == 9 ||
		                 key == 13 ||
		                 key == 46 ||
		                // key == 110 ||
		                // key == 190 ||
		                 (key >= 35 && key <= 40) ||
		                 (key >= 48 && key <= 57) ||
		                 (key >= 96 && key <= 105));
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