<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/tags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>秒杀商品页</title>
<!-- Required meta tags -->
<!-- 静态包含：一个页面。动态包含：两个页面 -->
<!-- Required meta tags -->
<%@ include file="common/head.jsp" %>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>秒杀列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>名称</th>
							<th>库存</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>创建时间</th>
							<th>查看详情</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${seckills }">
						<tr>
							<td>${sk.name }</td>
							<td>${sk.number }</td>
							<td>
								<fmt:formatDate value="${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<a class="btn btn-info" href="${pageContext.request.contextPath }/seckill/${sk.seckillId }/detail">Link</a>	
							</td>
						</tr>
						</c:forEach>
					</tbody>
                </table>
			</div>
		</div>
	</div>

</body>
</html>