<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function showImage(src) {
		src = $("#img" + src)[0].src;
		window.open(src, "newwindow","toolbar= no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	}
	function imgupload(obj) {
		var file = $("#image" + obj).val();
		if (file == "") {
			alert("请选择上传的图片");
			return;
		} else {
			//判断上传的文件的格式是否正确
			var fileType = file.substring(file.lastIndexOf(".") + 1);
			alert(fileType);
			if (fileType != "png") {
				alert("上传图片格式错误");
				return;
			} else {
				var url = "imgAdd!imgUploadAjax.action?index=" + obj;
				var formData = new FormData($("#postForm")[0]);
				$.ajax({
					url : url,
					type : "post",
					// 					data:$( '#postForm').serialize(),
					data : formData,

					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data, status) {
						path = eval("[" + data + "]");
						error = path[0].error;
						alert(error);
						if(error == 1)
						{
							$("#image" + obj).val("")
							alert("像素不对");
							return ;
						}
						if(error == 2)
						{
							alert("上传失败");
							return ;
						}
						if(error == 3)
						{
							alert("写入数据库失败");
							return ;
						}
						path = path[0].imgPath;
						
						$("#img" + obj).attr("src",
								path + "?v=" + (new Date()).valueOf());
						$("#image" + obj).val("");
					}
				});
			}
		}
	}
</script>
</head>
<body>
<div >
<img  src="" id="tmp" />
</div>
<form action="imgAdd.action" method="post" id="postForm"  enctype="multipart/form-data">
<!-- Photo 1.1:<input type="file" name="image" id="image"> -->
<table>
<tr>
	<td>
		<table>
		<tr>80x80<br><input type="file" name="image1" id="image1"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(1)"/></tr>
		<tr id="firstTr1"><br/><img src="/upload/1_1.png" name="img1" id="img1" height="170px" onclick="showImage(1);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>640x226<br><input type="file" name="image2" id="image2"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(2)"/></tr>
		<tr id="firstTr2"><br/><img src="/upload/1_2.png" name="img2" id="img2" height="170px" onclick="showImage(2);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>640x960<br><input type="file" name="image3" id="image3"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(3)"/></tr>
		<tr id="firstTr3"><br/><img src="/upload/1_3.png" name="img3" id="img3" height="170px" onclick="showImage(3);"></tr>
		</table>
	</td>
</tr>


<tr>
	<td>
		<table>
		<tr>96x96<br><input type="file" name="image4" id="image4"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(4)"/></tr>
		<tr id="firstTr4"><br/><img src="/upload/1_4.png" name="img4" id="img4" height="170px" onclick="showImage(4);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>720x254<br><input type="file" name="image5" id="image5"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(5)"/></tr>
		<tr id="firstTr5"><br/><img src="/upload/1_5.png" name="img5" id="img5" height="170px" onclick="showImage(5);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>640x1136<br><input type="file" name="image6" id="image6"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(6)"/></tr>
		<tr id="firstTr6"><br/><img src="/upload/1_6.png" name="img6" id="img6" height="170px" onclick="showImage(6);"></tr>
		</table>
	</td>
</tr>


<tr>
	<td>
		<table>
		<tr>120x120<br><input type="file" name="image7" id="image7"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(7)"/></tr>
		<tr id="firstTr7"><br/><img src="/upload/1_7.png" name="img7" id="img7" height="170px" onclick="showImage(7);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>750x265<br><input type="file" name="image8" id="image8"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(8)"/></tr>
		<tr id="firstTr8"><br/><img src="/upload/1_8.png" name="img8" id="img8" height="170px" onclick="showImage(8);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>720x1280<br><input type="file" name="image9" id="image9"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(9)"/></tr>
		<tr id="firstTr9"><br/><img src="/upload/1_9.png" name="img9" id="img9" height="170px" onclick="showImage(9);"></tr>
		</table>
	</td>
</tr>


<tr>
	<td>
		<table>
		<tr>144x144<br><input type="file" name="image10" id="image10"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(10)"/></tr>
		<tr id="firstTr10"><br/><img src="/upload/1_10.png" name="img10" id="img10" height="170px" onclick="showImage(10);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>1080x382<br><input type="file" name="image11" id="image11"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(11)"/></tr>
		<tr id="firstTr11"><br/><img src="/upload/1_11.png" name="img11" id="img11" height="170px" onclick="showImage(11);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>750x1334<br><input type="file" name="image12" id="image12"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(12)"/></tr>
		<tr id="firstTr12"><br/><img src="/upload/1_12.png" name="img12" id="img12" height="170px" onclick="showImage(12);"></tr>
		</table>
	</td>
</tr>


<tr>
	<td>
		<table>
		<tr>180x180<br><input type="file" name="image13" id="image13"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(13)"/></tr>
		<tr id="firstTr13"><br/><img src="/upload/1_13.png" name="img13" id="img13" height="170px" onclick="showImage(13);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>1242x439<br><input type="file" name="image14" id="image14"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(14)"/></tr>
		<tr id="firstTr14"><br/><img src="/upload/1_14.png" name="img14" id="img14" height="170px" onclick="showImage(14);"></tr>
		</table>
	</td>
	<td>
		<table>
		<tr>1080x1920<br><input type="file" name="image15" id="image15"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(15)"/></tr>
		<tr id="firstTr15"><br/><img src="/upload/1_15.png" name="img15" id="img15" height="170px" onclick="showImage(15);"></tr>
		</table>
	</td>
</tr>

<tr>
	<td>
	</td>
	<td>
	</td>
	<td>
		<table>
		<tr>1242x2208<br><input type="file" name="image16" id="image16"/>
			<input type="button" name="shangchuan" id="shangchuan" value="上传" onclick="imgupload(16)"/></tr>
		<tr id="firstTr16"><br/><img src="/upload/1_16.png" name="img16" id="img16" height="170px" onclick="showImage(16);"></tr>
		</table>
	</td>
</tr>

</table>
<input type="hidden" name="imgId" value=1 />
<!-- <input type="submit" value="提交"/> -->
</form>
</body>
</html>