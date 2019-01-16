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
	<script type="text/javascript" src="${basePath}/js/complaints.js"></script>
	<script type="text/javascript">
		var basePath = '${basePath}';
		var imagePath='${imagePath}';
		var domainUrl='${domainUrl}';
	</script>
	<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/js/publicSplitePage.js"></script>
	<script type="text/javascript">
			$(function(){
				orgList.init();
			});
					
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
			
			
			function nextPage()
			{
				location.href="orgList.action?index=2";
			}
			function dels(age)
			{
				alert("这是年龄，哈哈"+age);
			}
			
			function page(index)
			{				
				$.ajax({
					url:"orgListPage.action",
					type:"post",
					data:"index="+index,
					success:function(obj)
					{						
						var data=[{name:"a",age:12},{name:"b",age:11},{name:"c",age:13},{name:"d",age:14}];
						$("#fisrtTrId").nextAll().remove();
						for(var o in data)
						{
							 $("#tableId").append('<tr name="content" id="dd"><td >'+data[o].name+'</td><td >'+data[o].age+'</td><td >'+
							 '<a href="#" style="display:none" name="xiangQingId" class="aa detail" onclick="updates();">详情</a>	&nbsp;'+						
							 '<a href="#" name="updateId" class="aa detail" onclick="update();">修改</a>&nbsp;'+
				             '<a href="#" name="delId" class="aa detail" onclick="javascript:dels('+data[o].age+');">删除</a>&nbsp;'+
				             '<a href="#" name="notice" class="aa detail" onclick="javascript:addNotice();">发布内容</a></td></tr>');
						}
					},
					error:function(){
						//alert("error");
					}
				});
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
        <form action="${basePath}/org/orgInfo.do" method="post">
        	企业名称：<input type="text" id="org_namesd" name="org_name" value="${orgName}" style="width:175px;height:25px;font-size:14px;"/>
        	&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询" style="width:55px;height:25px;font-size:14px;cursor:pointer;">
        </form><br/>
        <div id="table">
        	
        <table width="100%" id="tableId">
				  
				<tr class="fisrtTr" id="fisrtTrId">
                	<th width="10%">组织名称</th>
					<th width="30%">组织标签</th>
					<th width="30%">操作</th>					
				</tr>
				
					<tr id="dd">
						<td >${__action.org.orgName}</td>
						<td >${__action.org.orgTag}</td>
						<td >
							<a href="#" style="display:none" name="xiangQingId" class="aa detail" onclick="updates();">详情</a>							
							<a href="#" name="updateId" class="aa detail" onclick="update();">修改</a>
		                    <a href="#" name="delId" class="aa detail" onclick="javascript:del();">删除</a>
		                    <a href="#" name="notice" class="aa detail" onclick="javascript:addNotice();">发布内容</a>
						</td>
					</tr>
				
			</table>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			<div style="height:180px;width:33%;border:1px solid red;float:left;">
				<div style="height:100px;width:200px;border:1px solid red;margin: 5% auto;"></div>
				<div style="height:20px;width:200px;border:1px solid red;margin: 0 auto;margin-top:-25px;">
					<font style="align:center;margin: 0 auto;">delete&nbsp;update</font>
				</div>
			</div>
			
			<br clear="left">
			
			        	
        </div>       
		<div  style=" padding:10px" ></div>
		
     	<%@ include file="/page/publicSplitePage.jsp"%>
       	 
		
    </div>
  </body>
</html>
