<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;">${msg}</h1>

<form action="UserServlet?action=update" method="post">
	<input type="text" name="id" value="${u.id}" readonly="readonly"/><br>
	<input type="text" name="name" value="${u.name}"/><br>
	<input type="submit">
</form>

</body>
</html>