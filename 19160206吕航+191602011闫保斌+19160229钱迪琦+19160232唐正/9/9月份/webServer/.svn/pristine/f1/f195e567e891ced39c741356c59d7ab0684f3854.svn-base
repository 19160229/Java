<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="../../jessma-base.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

  <head>
  <base href="${__base}">
    <title>
  		机构列表 
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link  rel="stylesheet"  type="text/css" href="/css/allStyle.css" />
	
  </head>
 
  <body >   
  
  	<div class="couponBase main" height="1000px">
		<div class="first">
			<div class="first1">
				<div class="first_title">
					<span class="thems">APP信息</span>
				</div>
				<div class="first_content">
					 <div  class="addBtn" onclick="fanhui()">返回</div>
				</div>
			</div>
			<div class="remind">

			</div>
			<div class="grayLine"></div>
		</div>						
        <form id="mainForm" action="addCon.action" method="post">
        	
            <div class="couponInfo">
                	<div class="gz1 fisrtTr"></div>
                	<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" class="couponTab">
            		<tbody>
						<tr>
							<td width="10%" class="fl_right">组织名称：</td>
							<td width="50%"><input type="text"  class="btn" name="orgName" id="org_name" onblur="checkName()"/></td>
							<td width="40%" style="text-align:left;"><span >不能重复</span><span id="sdp" style="display:none;font-size: 28px;;" class="red">组织名称重复</span></td>
						
						</tr>
						
						<tr>
							<td class="fl_right">组织标签：</td>
							<td width="10%"><input type="text" name="orgTag" class="btn" id="allow_join" /></td>
							<td style="text-align:left;"><span class="red">*</span></td>
						</tr>
												
						<tr>
							<td class="fl_right">组织信息：</td>
							<td width="10%"><textarea rows="10" cols="66" name="orgTxt" id="txtInfo" onblur="checkTxtInfo()"></textarea></td>
							<td ><span class="red" style="text-align:center;">不能超过500字</span><span id="sdps" style="display:none;font-size: 28px;text-align:right;" class="red">已超过500字</span></td>
						</tr>
						
						
						<tr style="height:52px;" valign="bottom">
							<td colspan="3">
								<div class="couponBtn">
									<input type="submit" value="tijiao"/>
									<div class="addBtn" id="addBtnId" onclick="save()" style="margin-left: auto;margin-right: auto;">完成</div>
								</div>
								
							</td>
						</tr>
					</tbody>
				</table>
             </div>
        </form>
    </div>
  </body>
</html>
