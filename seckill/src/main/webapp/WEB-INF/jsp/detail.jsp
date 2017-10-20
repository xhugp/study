<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/tags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>秒杀详情页</title>
<!-- Required meta tags -->
<!-- 静态包含：一个页面。动态包含：两个页面 -->
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="panel-heading">
				<h1>${seckill.name }</h1>
			</div>
			<div class="panel-body">
				<h2 class="text-danger">
					<span class="glyphicon glyphicon-time"></span>
					<span class="glyphicon" id="seckill-box"></span>
				</h2>
			</div>
		</div>
	</div>
	
<!-- 模态框 -->	
<div  id="killmodel" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title text-center">
        	<span class="glyphicon glyphicon-phone"></span>
        	秒杀手机号
        </h3>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-xs-8 col-xs-offset-2">
        		<input type="text" name="userPhone" id="killPhoneKey"
        			placeholder="填写手机号" class="form-control"/>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <span id="killPhoneMessage" class="glyphicon"></span>
        <button type="button" id="killPhoneBtn" class="btn btn-success">
        	<span class="glyphicon glyphicon-phone"></span>
        	Submit
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<!-- 加载cookie.js -->
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>

<!--  加载自己的js -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/myscript/seckill.js"></script>

<script type="text/javascript">
	$(function(){
		seckill.detail.init({
			seckillId : "${seckill.seckillId }",
			startTime : "${seckill.startTime.time}",
			endTime : "${seckill.endTime.time}"
		});
	});
</script>
</html>