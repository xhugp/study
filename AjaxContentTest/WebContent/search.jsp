<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#div1{
		position: absolute;
		left: 50%;
		top: 50%;
		margin-top: -50px;
		margin-left: -160px;
	
	}
	#moreContents{
		position: absolute;
	}
	.mouseover{
		background-color: #fffafa;
		color: #000000;
	}
	
</style>
<script type="text/javascript">
	var xmlHttp;
	function getMoreContens(){		
		var content = document.getElementById("search_id");
		if(content==""){
			clearNode();
			return;
		}
		//使用ajax异步传输数据，需要创建一个XMLHttpRequest对象
		xmlHttp = getXmlHttp();
		//请求的url地址以及传入参数
		var url = "search?search_text="+ content.value;
		//发送请求
		xmlHttp.open("GET",url,true);
		//绑定回调函数，接受响应的函数
		xmlHttp.onreadystatechange=callback;
		xmlHttp.send();
	}
	//获得xmHttp对象，考虑浏览器的兼容性
	function getXmlHttp(){
		var xmlHttp;
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}
		else if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			if(!xmlHttp){
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
		}
		return xmlHttp;
	}

	function callback(){

		if(xmlHttp.status==200 && xmlHttp.readyState==4){
			//接收响应文本信息
			var result = xmlHttp.responseText;
			//解析数据
			var json = eval("("+result+")");
			setContents(json);
		}
		
	}
	//设置显示区域信息（将从服务器收到的json数据进行动态展示
	function setContents(contents) {
		clearNode();
		var size = contents.length;
		for(var i = 0 ; i < size ; i++){
			var nextNode = contents[i];
			var li = document.createElement("li");
			li.onmouseover=function(){				
				this.className="mouseover";
			};
			li.onmouseout=function(){
				this.className="";
			};
			
			var content = document.getElementById("search_id");
			var width = content.offsetWidth;
			li.style.width=width+"px";
			var text = document.createTextNode(nextNode);
			li.appendChild(text);
			document.getElementById("more_ul").appendChild(li);
			
		}
	}

	function clearNode(){
		var ulNode = document.getElementById("more_ul");
		var length = ulNode.childNodes.length;
		for(var i = length-1;i>=0;i--){
			ulNode.removeChild(ulNode.childNodes[i]);
		}
		
	}
	function keyblur(){
		clearNode();
	}


</script>
</head>
<body>
	<div id="div1">
		<input type="text" id="search_id" name="searchText" onkeyup="getMoreContens()" 
		onblur="keyblur()" onfocus="getMoreContens()"  size="50">
		<input type="button" value="搜索">
		<div id="moreContents">
			<ul id="more_ul" style="list-style: none; float: left;margin-left: -40px;margin-top: 0px;">
				
			</ul>
		</div>
	</div>
</body>
</html>