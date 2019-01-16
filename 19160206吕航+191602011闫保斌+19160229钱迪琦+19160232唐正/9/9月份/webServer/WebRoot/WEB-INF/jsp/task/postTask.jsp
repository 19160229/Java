<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布任务</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
	<form role="form" method = "post" action="postTask!addTask.action">
	  <input type="hidden" name="publisherID" value="563c9e78cdd106028cc39ec7"/>
	  <input type="hidden" name="createTime" value="2015-11-06 08:56:00"/>
	  <input type = "hidden" name="latitude" value="133.1"/>
	  <input type = "hidden" name="longitude" value="32.2"/>
	  <div class="form-group">
	    <label for="description">描述：</label>
	    <input type="text" class="form-control" name="description" placeholder="">
	  </div>
	  <div class="form-group">
	    <label for="address">地点：</label>
	    <input type="text" class="form-control" name="address" placeholder="">
	  </div>
	  <div class="form-group">
	    <label for="timeLength">时长：</label>
	    <input type="text" class="form-control" name="timeLength" placeholder="">
	  </div>
	  <div class="form-group">
	  	<label for="taskType">请选择任务类型（数据库读取）：</label>
	    <select class="form-control" name="taskTypeID"> 
	      <option value="1">1</option> 
	      <option value="2">2</option> 
	      <option value="3">3</option> 
	      <option value="4">4</option> 
	      <option value="5">5</option> 
	      </select>
  	  </div>
	  <button type="submit" class="btn btn-default">发布</button>
	</form>	
</body>
</html>