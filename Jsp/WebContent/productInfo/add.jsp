<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>products add</h1>
<form action="../ProductInfoServlet?action=insert" method="post">
	<table>
		<tr>
			<td>名称</td>
			<td><input type="text" name="productName"/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="text" name="productImg"/></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" name="price"/></td>
		</tr>
		<tr>
			<td>描述</td>
			<td><input type="text" name="descript"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"/>
			<input type="reset" value="重置"/></td>
		</tr>
	</table>
</form>

</body>
</html>