<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style>
.flex-container {
	display: -webkit-flex;
	display: flex;
	background-color: lightgrey;
	flex-flow: row wrap;
}

.flex-item {
	background-color: cornflowerblue;
	height: 30px;
	width: 141px;
	margin: 10px;
}
</style>

</head>
<body>

<div id="container" style="width:100%">

<div id="header" style="background:url('img/touwei.jpg')">
<h1 style="margin-bottom:20px;height:70px;line-height:100px" align="center"><span>物流信息</span></h1>
<div float="right">
<c:if test="${u_session==null }">
<a href="login.jsp">登录</a>
<a href="register.jsp">注册</a>
</c:if>
<c:if test="${u_session!=null }">
 
${u_session.name },${u_session.id },欢迎！
</c:if>

</div>
</div>

<div id="menu" style="height:600px;width:20%;float:left;background:url('img/huise.jpg')">
<b>菜单</b><br>
<a href="ProductInfoServlet?action=showAll">首页</a><br>
<a href="CartGoodsServlet?action=getAll">购物车</a><br>
<a href=" ">用户信息</a><br>
<a href="OrderServlet?action=getAll">订单详情</a><br>
退出商城<br>
</div>

<div id="content" style="height:600px;width:80%;float:left;overflow:auto;background:url('img/feiji.jpg');" align="center">
   <h1 align="center">全部货运信息</h1>

	<h1>
		<a href="shoppingInfo/add.jsp">添加货运信息</a>
	</h1>
	<hr>

	<div class="flex-container">
		<c:forEach items="${list}" var="info">
			<div class="flex-item">
			 ${info.shopId }&nbsp;${info.shopName }&nbsp;${info.shopContact }
			</div>
		</c:forEach>
	</div>
	<hr>
	<table border="1px solid">
		<tr>
			<td>编号</td>
			<td>公司名称</td>
			<td>联系人</td>
			<td>电话</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="info">
			<tr>
				<td>${info.shopId }</td>
				<td>${info.shopName }</td>
				<td>${info.shopContact }</td>
				<td>${info.telephone }</td>
				<td>${info.price }</td>
				<td><a
					href="shoppingInfoServlet?action=delete&shopId=${info.shopId }">删除</a>
					&nbsp;&nbsp; <a
					href="shoppingInfoServlet?action=showOne&shopId=${info.shopId }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
   
</div>

<div id="footer" style="background:url('img/touwei.jpg');clear:both;text-align:center;">
版权 © bingxixi.com</div>

</div>

<h1 align="center">全部货运信息</h1>

	<h1>
		<a href="shoppingInfo/add.jsp">添加货运信息</a>
	</h1>
	<hr>

	<div class="flex-container">
		<c:forEach items="${list}" var="info">
			<div class="flex-item">
			 ${info.shopId }&nbsp;${info.shopName }&nbsp;${info.shopContact }
			</div>
		</c:forEach>
	</div>
	<hr>
	<table border="1px solid">
		<tr>
			<td>编号</td>
			<td>公司名称</td>
			<td>联系人</td>
			<td>电话</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="info">
			<tr>
				<td>${info.shopId }</td>
				<td>${info.shopName }</td>
				<td>${info.shopContact }</td>
				<td>${info.telephone }</td>
				<td>${info.price }</td>
				<td><a
					href="shoppingInfoServlet?action=delete&shopId=${info.shopId }">删除</a>
					&nbsp;&nbsp; <a
					href="shoppingInfoServlet?action=showOne&shopId=${info.shopId }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>