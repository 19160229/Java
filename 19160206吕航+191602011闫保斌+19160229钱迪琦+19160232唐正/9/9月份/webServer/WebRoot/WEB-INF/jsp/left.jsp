<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="jessma-base.jsp" %>
<div class="order">
   	<ul id="ulMenu">
   	<!--  
   	<c:if test="${sessionScope.menuVO != null }">
   	<c:forEach items="${sessionScope.menuVO }" var="menu">
			<li class="title">
				<div class="icon"><img src="${basePath}/image/left/school.png"></div>
				<div>${menu.mname }</div>
			</li>
			<li class="chidren"><ul>
			<c:forEach items="${menu.subMenus }" var="m">
				 <li class="chidrenTitle" href="${basePath }${m.menuUrl }"  menuId="${m.mid}" operCode="SH8905010000">
				 		<div class="icon icon-caret-right">&nbsp;</div>
				 		${m.mname }
				 </li>
			</c:forEach>
			</ul></li>
	</c:forEach> 
	</c:if>-->
	   <li class="title" >
				<div class="icon"><img src="/image/left/school.png"></div>
				<div onclick="taskList();">任务管理</div>
		</li>
		<li class="title">
				<div class="icon"><img src="/image/left/school.png"></div>
				<div>用户管理</div>
		</li>
		<li class="title">
				<div class="icon"><img src="/image/left/school.png"></div>
				<div>任务统计</div>
		</li>
		<li class="title">
				<div class="icon"><img src="/image/left/school.png"></div>
				<div onclick="">任务统计</div>
		</li>
       <li class="space"></li>
   </ul>
</div>