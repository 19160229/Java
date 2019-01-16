<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> --%>
<%@include file="../jessma-base.jsp" %>
<head>
<title>部门列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="../../../css/cmi.css" type="text/css" />
<script type="text/javascript" src="../../../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">

	function back()
	{
		var url = $("#url").val();
// 		alert(url);
		location.href=url;
	}

</script>
</head>

<body>
	<form action="departList.action" name="n1" method="post">
		<input type="hidden" id="url" value="${__action.url} " ></input>
<%-- 		<input type="hidden" id="url" value="${url}"/> --%>
		<div class="bar">
			<span class="search"><strong></strong></span>

		</div>
		<div class="inputDiv">
			<table width="100%" border="0" cellpadding="2" cellspacing="1">
				<tr>					
					<td width="50%" align="center">
						<font style="font-size:25px;color:rgba(11, 165, 251, 0.9)">成功</font>
					</td>
				</tr>
				<tr>					
					<td width="50%" align="center">
					<a id="query11" name="query1" class="btn2" href="javascript:back()">返回</a>
					</td>
				</tr>
			</table>

		</div>

	</form>
</body>
</html>

