<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<!-- <li>
							<a href="index.html"><i class="fa fa-home nav_icon"></i>Dashboard</a>
						</li> -->
						
					
					<c:if test="${sessionScope.departmentDetails.deptId==1}">
						<li>
							<a href="${pageContext.request.contextPath}/showViewAnnouncement"><i class="fa fa-home nav_icon"></i>View Announcement</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/showViewNotice"><i class="fa fa-home nav_icon"></i>View Notice</a>
						</li>
						
							<li>
							<a href="${pageContext.request.contextPath}/showViewEvent"><i class="fa fa-home nav_icon"></i>View Event</a>
						</li>
						</c:if>
							<li>
							<a href="${pageContext.request.contextPath}/showPostAnnouncement"><i class="fa fa-home nav_icon"></i>Post Announcement</a>
						</li>
						
						<li>
							<a href="${pageContext.request.contextPath}/showPostEvent"><i class="fa fa-home nav_icon"></i>Post Notice on Board</a>
						</li>
						
							
						<li>
							<a href="${pageContext.request.contextPath}/showPostNotice"><i class="fa fa-home nav_icon"></i>Post Event on Board</a>
						</li>
						
						
						
						
						 
					 
						 
						 
						 
						 
					</ul>
					<div class="clearfix"> </div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->