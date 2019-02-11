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

  <c:url var="getNotice" value="/getNotice"></c:url>
  <c:url var="approveNotice" value="/approveNotice"></c:url>
  <c:url var="getNoticeById" value="/getNoticeById"></c:url>


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
						<h4>Notice Board</h4>
						
					 
						 
						<table class="table" id="table1">
							<thead>
								<tr>
									<th>#</th>
									<th>Title</th>
									<th>Date</th>
									<th width="400px">Short Description</th>
									<th>Full Description</th>
									<th>Attachment</th>
									 <th>Approval</th>
								</tr>
							</thead>
							<tbody>
							 <c:forEach var="announcement" items="${announcementList}" varStatus="count">
						 
								<tr class="active">
									<td scope="row">${count.index+1}</td>
									<td>${announcement.title}</td>
									<td>${announcement.date}</td>
									<td>${announcement.shortDesc}</td>
									<td><a href="#" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" onclick="setFullDesc(${announcement.id})">View Full Details</a></td>
<td><a href="${pageContext.request.contextPath}/kvnimages/${announcement.file}" download>${announcement.file}</a></td>								 
								
								<c:choose>
								<c:when test="${announcement.status==0}">
								<td>Not Approve</td>
								</c:when>
								<c:otherwise>
								<td>Approved</td>
								</c:otherwise>
								
								</c:choose>
								</tr>
								 </c:forEach>  
							<%-- <c:forEach var="deptList" items="${deptList}" varStatus="count">
						 
								<tr class="active">
									<th scope="row">${count.index+1}</th>
									<td>${deptList.deptName}</td>
									<td>${deptList.email}</td>
									<td>${deptList.contactNo}</td>
								</tr>
								 </c:forEach> --%>
							</tbody>
						</table>
					</div>
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										<h4 class="modal-title" id="exampleModalLabel"></h4>
									</div>
									<div class="modal-body">
										<p id="fullDesc"></p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                        
                        <script type="text/javascript">
                        function getAnnouncement() {
							 
                        	var deptId=document.getElementById("deptId").value;

                        	$('#table1 td').remove();
                        	
    						$.getJSON('${getNotice}', {

    							deptId : deptId,

    							 

    							ajax : 'true'

    						}, function(data) {
    							console.log(data);
    							  $.each( data,
											function(key, list) {
    							
    							var tr = $('<tr></tr>');
							  	tr.append($('<td></td>').html(key+1));

							  	tr.append($('<td></td>').html(list.title));
							  	tr.append($('<td></td>').html(list.date));
								tr.append($('<td></td>').html(list.shortDesc));
								
								tr.append($('<td></td>').html('<a href="#" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" onclick="setFullDesc('+list.id+')">View Full Details</a>'));
								tr.append($('<td></td>').html('<a href="${pageContext.request.contextPath}/kvnimages/'+list.file+'" download>'+list.file+'</a>'));

								if(list.status==0){
			 	tr.append($('<td ></td>').html("<a href='#' onclick='aprove("+list.id+")' class='action_btn'>  Approve</a> "));
								}
								else{
									tr.append($('<td></td>').html('Approved'));
								}
								$('#table1 tbody').append(tr);
    							  });
    						})
						}
                        
                        
                        
                        function setFullDesc(id) {
                            
                          	 
                          	 
                          	 $("#exampleModalLabel").text('');
                          	 
                           
                          	 		document.getElementById('fullDesc').innerHTML = '';

                          	 	 
                          	 	  			$.getJSON('${getNoticeById}', {
                          	 	  			id : id,
                          	 	  			ajax : 'true',
                          	 	  		},function(result){
                          	 	  			
                          	 	  		 $("#exampleModalLabel").text(result.title);
                          	 	  			document.getElementById('fullDesc').innerHTML = result.fullDesc;
                          	 	  			 
                          	 	  			 
                          	 	  		})
                          	 	 
                          	 			
                          	 	}
        function aprove(id) {
							
                        	$.getJSON('${approveNotice}', {

    							id : id,

    							 

    							ajax : 'true'

    						}, function(data) {
    							getAnnouncement();
    						})
						}
                        </script>
</body>
</html>