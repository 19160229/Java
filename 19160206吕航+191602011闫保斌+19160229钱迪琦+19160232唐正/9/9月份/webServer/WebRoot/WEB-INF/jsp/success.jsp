<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <head>
    <title>
  		机构列表 
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link  rel="stylesheet"  type="text/css" href="${basePath }/css/complaints.css" />
	<link  rel="stylesheet"  type="text/css" href="/css/allStyle.css" />
	<script type="text/javascript" src="${basePath}/js/school.js"></script>
	<script type="text/javascript" src="/js/plgin/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/complaints.js"></script>
	<script type="text/javascript">
		var basePath = '${basePath}';
		var imagePath='${imagePath}';
		var domainUrl='${domainUrl}';
	</script>
	<script type="text/javascript">

			function fanhui(url)
			{
				location.href=basePath+url;
			}
			 		
	</script>
	<style type="text/css">
		.tableId{border:0px}
	</style>
  </head>
 
  <body >   
  
  	<div class="couponBase main">
  		<table class="tableId">
			<tr>
				<td  style="align:center"><font style="font-size:20px;color:green;">操作成功</font></td>
			</tr>			
		</table>
		<div class="first" align="center">
			
			<div class="remind">
				<div  class="addBtn"  onclick="fanhui('${url}')">返回</div>
			</div>
			<div class="grayLine"></div>
		</div>
								       
    </div>
    	
  </body>
</html>
