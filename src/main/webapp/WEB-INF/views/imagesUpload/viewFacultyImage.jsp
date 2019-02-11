<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/images/LOGMIEER PNG LOGO.png" />
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
<link
	href="${pageContext.request.contextPath}/resources/css/lightbox.css"
	rel="stylesheet">
<!--//Metis Menu -->




</head>

<c:url var="deleteFacultyImagesByForSite" value="/deleteFacultyImagesByForSite"></c:url>



<body class="cbp-spmenu-push">

	<div class="main-content">

		<jsp:include page="../include/left.jsp" />
		<jsp:include page="../include/header.jsp" />






		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="tables">
					<!-- <h3 class="title1">Tables</h3> -->


					<div class="bs-example widget-shadow"
						data-example-id="contextual-table">
						<h4>Faculty Photo</h4>

						<%-- <div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Select
								Department</label>
							<div class="col-sm-8">
								<select id="deptId" name="deptId" onchange="getAnnouncement()"
									class="form-control1">
									<option value="" disabled="disabled" selected="selected">Select
										Department</option>
									<c:forEach var="departmentDetails"
										items="${departmentDetailslist}" varStatus="count">
										<option value="${departmentDetails.deptId}">${departmentDetails.deptName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>

						<hr>
 --%>
						<table class="table" id="table1">
							<thead>
								<tr>
									<th>#</th>

									<th>Name</th>
									<th>Post</th>
									<th>Photo</th>
									<th>File</th>
									<!-- <th>Order By</th> -->

									<th>Delete</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="facultyImages" items="${facultyImagesList}"
									varStatus="count">

									<tr class="active">
										<td scope="row">${count.index+1}</td>
										<td>${facultyImages.name}</td>
										<td>${facultyImages.post}</td>

										<td><a class="demo" href="${facultyImages.photo}" data-lightbox="example-1"> ${facultyImages.photo}
										</a>


										</td>
									<td><a
											href="${pageContext.request.contextPath}/kvnimages/${facultyImages.file}"
											download>${announcement.file}</a></td>
										 
										 
										<c:choose>
											<c:when test="${facultyImages.delStatus==0}">


												<td><a href='#' onclick='deleteCall(${facultyImages.id})'
													class='action_btn'> Delete</a></td>

											</c:when>
											 
											<c:otherwise>
												<td>Deleted</td>
											</c:otherwise>
										</c:choose>
										 

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="exampleModalLabel"></h4>
								</div>
								<div class="modal-body">
									<p id="fullDesc"></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<!-- <button type="button" class="btn btn-primary">Send message</button> -->
								</div>
							</div>
						</div>
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
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/lightbox.js">
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

	<script type="text/javascript">
                      
                        
                       
          
        function deleteCall(id) {
        	 
        	$.getJSON('${deleteFacultyImagesByForSite}', {

				id : id,

				 

				ajax : 'true'

			}, function(data) {
				 
				 
					location.reload();
					 
			})
		}
        
        
                        </script>
</body>
</html>