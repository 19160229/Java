<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/jessma-base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="/css/login.css"/>
<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</head>
<script type="text/javascript">	

	function subbmit()
	{
		$("#login").submit();
	}
</script>
<body>
<form method="post" id="login" action="login.action">
  <div class="left">
	<div style="height:200px" ></div>
	<div class="side_bg"></div>
  </div>
  <div class="out">
	<div style="height:200px"></div>
	<div class="bg">
		<div class="login">
			<div class="title">
				<img src="${basePath}/image/login/index_logo.png">
				<div>后台管理系统</div>
			</div>
			<div class="login_bg">
				<div class="login_input">
				<input type="hidden" class="password skyBlue" name="password" value="">
					<input type="text" class="user skyBlue" name="userId" value="" >
					<input type="password" class="password1 skyBlue" name="pwd" value="">
					<div class="tip">登陆失败，密码账号不能为空</div>
				</div>
				<div class="login_btn">
					<div class="loginBtn" onclick="javascript:subbmit();">登陆</div>
					<div class="resetBtn">重置</div>
				</div>	
			</div>
		</div>
	</div>
	<div class="bg_phonoe"></div>
  </div>
   <div class="right">
   	 <div style="height:200px"></div>
   	 <div class="side_bg"></div>
   </div>
</form>
</body>
</html>
