<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Order add</title>
</head>
<body>

<form action="../OrderServlet?action=add" method="post">
	<table align="center">
	<%
		request.setCharacterEncoding("utf-8");
		String goodsId=request.getParameter("goodsId");
		String price=request.getParameter("price");
	%>
	<tr>
		<td>物品编号</td>
		<td><input type="text" name="goodsId" value="<%=goodsId %>" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>支付金额</td>
		<td><input type="text" name="price" value="<%=price %>" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>支付方式</td>
		<td><input type="text" name="payWay" /></td>
	</tr>
	<tr>
		<td>用户地址</td>
		<td><input type="text" name="customerAddress" /></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="支付"/>
			<input type="reset" value="重置"/>
		</td>
	</tr>
	</table>	
</form>

</body>
</html>