<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="../jessma-base.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <head>
    <title>
  		机构列表 
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link  rel="stylesheet"  type="text/css" href="${basePath }/css/complaints.css" />
	<script type="text/javascript" src="${basePath}/js/complaints.js"></script>
	<script type="text/javascript">
		var basePath = '${basePath}';
		var imagePath='${imagePath}';
		var domainUrl='${domainUrl}';
	</script>
	<script type="text/javascript" src="${basePath}/js/org.js"></script>
	<script type="text/javascript">
			$(function(){
				orgList.init();
			});
			window.onload=hideAddButton;
			function hideAddButton()
			{
				
			}
					
			function del(id,name)
			{
				$("#"+id).css({"background": " #C1FFC1" });
				var r = window.confirm("确定要删除吗？删除后不可恢复");
				$("#"+id).css({"background": "" });
				if(r)
				{
					location.href=basePath+"/org/delOrgInfo.do?id="+id+"&title="+name;
				}
			}			
			function update(id)
			{
				$("#"+id).css({"background": " #C1FFC1" });
				var r = window.confirm("确定要修改吗？");
				$("#"+id).css({"background": "" });
				if(r)
				{			
					location.href=basePath+"/org/findById.do?id="+id;
				}
			}
			//查看详情
			function updates(id)
			{					
				location.href=basePath+"/org/findById.do?id="+id;
			}
			
			function add()
			{
				location.href=basePath+"/org/toAdd.do";
			}
			function showImage(src)
			{
				window.open(src, "newwindow", "toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
			}
			
			function addNotice(id,name)
			{				
				location.href=basePath+"/content/findList.do?orgId="+id+"&orgName="+name;
			}
	</script>
	
  </head>
  
  <body>
  	<div class="main">
    	<div class="first">
        	<div class="first1"> 
        		<div style="width:300px; height:35px; float:left">
                	<span class="thems">组织管理</span>
                </div>
                <div style=" float:right;height:35px; ">
                	<div class="addBtn" id="addIds" onclick="add()"><p style="font-size: 20px;">增加</div>
                </div>
        	</div>
            <div class="remind">
            	<p class="remind1"></p>
            </div>
            <div class="grayLine"></div>
        </div>        
        <form action="/org/orgInfo.do" method="post">
        	企业名称：<input type="text" id="org_namesd" name="org_name" value="" style="width:175px;height:20px"/>
        	<input type="submit" value="查询" >
        </form><br/>
        <div id="table">
        	
        	<table width="100%">
        		<tr>
        			<td>
        				Hello, The time now is这是组织主页 <fmt:formatDate value="${__action.now}" pattern="yyyy-MM-dd HH:mm" />
					<input type="text" value="${__action.str}"/>
        			</td>
        		</tr>								
			</table>        	
        </div>       
		<div  style=" padding:10px" ></div>
     <!--  
       	 <div class="ss" style=" width:460px; float:left;height:25px">
			<input type="hidden" id="uppages" value="${pm.upPage }" />
			<input type="hidden" id="nextPage" value="${pm.nextPage}" />  
			<input type="hidden" id="totalpage" value="${pm.totalPages }" /> 
			<div id="uppage" style="float:left;cursor: pointer;line-height: 25px;">上一页</div> 
			<div style="float:left;line-height: 25px;">
				<span id="cpage">${pm.currentPage}</span>/<span>${pm.totalPages}</span>
			</div>
			
			<input type="hidden" id="dindex" value="" /> 
			<div id="pagedown" style="float:left;cursor: pointer;line-height: 25px;margin-right: 10px;">下一页</div> 
			<input type="text" id="index_page" style="text-align:center; width:50px;  height:25px; border:#999 1px solid;margin-right: 10px;float: left;" />&nbsp;
			<div class="skippage" style="cursor: pointer;" >跳转</div>
	
		</div>
		-->
    </div>
  </body>
</html>
