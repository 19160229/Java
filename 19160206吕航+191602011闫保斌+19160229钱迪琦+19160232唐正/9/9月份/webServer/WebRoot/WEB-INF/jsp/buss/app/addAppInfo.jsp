<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/cmi.css" type="text/css" />
<title>Insert title here</title>
<script >
function save()
{
	var productId = $("#productId").val();
	var appName = $("#appName").val();
	var appType = $("#appType").val();
	var about = $("#about").val();
	var companyName = $("#companyName").val();
// 	alert("appAdd!addApp.action?productId="+productId+"&appName="+appName+"&appType="+appType+"&about="+about+"&companyName="+companyName);
	location.href="appAdd!addApp.action?productId="+productId+"&appName="+appName+"&appType="+appType+"&about="+about+"&companyName="+companyName;
}

function next()
{
	var productId = $("#productId").val();
	var appName = $("#appName").val();
	var appType = $("#appType").val();
	var about = $("#about").val();
	var companyName = $("#companyName").val();
	
	location.href="appAdd!saveAndAddImg.action?productId="+productId+"&appName="+appName+"&appType="+appType+"&about="+about+"&companyName="+companyName;
}
</script>
</head>
<body>
	<div class="inputDiv">
		<table>
			<tr>
				<td width="15%">产品ID：</td>
				<td><input class="box" id="productId" name="productId"></input></td>
			</tr>
			<tr>
				<td width="15%">app名称：</td>
				<td><input class="box" id="appName" name="appName"></input></td>
			</tr>
			<tr>
				<td width="15%">app类型:</td>
				<td><select id="appType" name="appType" type="select">
					<option value=0> 类型A</option>
					<option value=1> 类型B</option>
					<option value=2> 类型C</option></input></td>
			</tr>
			<tr>
				<td width="15%">关于：</td>
				<td><input class="box" id="about" name="about"></input></td>
			</tr>
			<tr>
				<td width="15%">发布对象名称：</td>
				<td><input class="box" id="companyName" name="companyName"></input></td>
			</tr>
			<tr>
				<td><a href="javascript:save();">保存</a></td>
				<td><a href="javascript:next();">下一步</a></td>
			</tr>
		</table>
	</div>
</body>
</html>