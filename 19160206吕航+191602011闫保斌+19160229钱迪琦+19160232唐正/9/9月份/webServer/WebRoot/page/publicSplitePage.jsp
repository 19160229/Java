<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<div class="ss" style="width:460px; float:left;height:25px;font-size: 16px;">			
	<div id="uppage" style="float:left;cursor: pointer;line-height: 25px;" onclick="upPage();">上一页</div> 
	<div style="float:left;line-height: 25px;">
		<span id="cpage">1</span>/<span id="totalPage">${__action.totalPage}</span>
	</div>		
	<div id="pagedown" style="float:left;cursor: pointer;line-height: 25px;margin-right: 10px;" onclick="downPage();">下一页</div> 
	<input type="text" id="skipPage" style="text-align:center; width:50px;  height:25px; border:#999 1px solid;margin-right: 10px;float: left;" />&nbsp;
	<div class="skippage" style="cursor:pointer;margin-top:-15px;" onclick="skipPage();">跳转</div>	
</div>