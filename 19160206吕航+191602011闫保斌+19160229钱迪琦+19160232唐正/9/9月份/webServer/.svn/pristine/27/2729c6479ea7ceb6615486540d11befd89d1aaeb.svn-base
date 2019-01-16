			//上一页
			function upPage()
			{
				var cpage = $("#cpage").text();
				if(parseInt(cpage)>1)
				{
					page(parseInt(cpage)-1);
					$("#cpage").text(parseInt(cpage)-1);
				}else{
					alert("已经是首页了");
				}
			}
			
			//下一页
			function downPage()
			{
				var cpage = $("#cpage").text();
				var totalPage = $("#totalPage").text();
				if(parseInt(cpage)<parseInt(totalPage))
				{
					page(parseInt(cpage)+1);
					$("#cpage").text(parseInt(cpage)+1);
				}else{
					alert("已经是尾页了");
				}
			}
			
			//跳转页
			function skipPage()
			{
				var cpage = $("#cpage").text();
				var totalPage = $("#totalPage").text();
				var skipPage = $("#skipPage").val();
				var reg = /^[1-9]+[0-9]*$/;
				if(reg.test(skipPage) && parseInt(skipPage)>0 && skipPage<(parseInt(totalPage)+1)&& parseInt(cpage)!=parseInt(skipPage))
				{
					page(parseInt(skipPage));
					$("#cpage").text(parseInt(skipPage));
				}else{
					alert("请输入正确的跳转页");
				}
			}