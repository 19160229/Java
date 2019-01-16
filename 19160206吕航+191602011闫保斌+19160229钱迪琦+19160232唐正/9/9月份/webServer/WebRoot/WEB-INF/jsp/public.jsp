<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<%@page import="java.util.*" %>
<%@include file="jessma-base.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/public.css"/>
<link href="/css/font-awesome.css" rel="stylesheet">
<script src="../../../js/jquery-1.7.1.min.js"></script>
<script>
$(function(){
		$("#publicId").css("minHeight",$(window).height()-122+"px");
		$(window).resize(function(){
			$("#publicId").css("minHeight",$(window).height()-122+"px");	
		})
})
</script>
</head>
<body>
	<table  class="out" border="0" cellspacing="0" cellpadding="0">
		<tr class="top" valign="top">
			<td class="left">
				<div class="img">
					<img src="/image/top/logo.png" id="backIndex" width="40px"/>
					<div>后台管理系统</div>
				</div>
				
			</td>
			<td class="con">
				<img src="/image/top/top_center3.png"/>
			</td>
			<td class="right">
				<div class="icon">
					<div>
						欢迎： ${sessionScope.username} | <font id="close" >注销</font> 
					</div><br>
					<div>
						<font id="index">后台首页</font> | 
						<font id="user">个人中心</font>
					</div>
				</div>
			
			</td>
		</tr>
		<tr valign="top">
			<td class="orderBg_pt">
				<jsp:include page="left.jsp" flush="true"></jsp:include>
			</td>
			<td class="menu_con"></td>
			<td class="menu">
				<div class="menu_right">
	            	<div style="margin-left: 40px;margin-top:5px;margin-right: 40px;" id="publicId">
	            		
	            		<c:if test="${ __action.id != null}">
	            			<jsp:include page="${__action.id}" flush="true"></jsp:include>
	            		</c:if>
	            	</div>
           		</div> 
			</td>
		</tr>
	</table>
	
</body>
</html>
