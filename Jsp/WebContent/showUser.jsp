<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<!-- c:forEach表示循环    items表示从这里取值放到var中 -->
<table border="1px solide">
	<tr>
	<td>用户编号</td>
	<td>用户名</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="u">
	<tr>
	<td>${u.id}</td>
	<td>${u.name }</td>
	<td><a href="UserServlet?id=${u.id }&action=delete">删除</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="UserServlet?id=${u.id}&action=showOne">修改</a>
	</td>
	
	</tr>
	</c:forEach>
</table>


</body>
</html>