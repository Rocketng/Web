<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>shoppinginfo update</h1>
<form action="shoppingInfoServlet?action=update" method="post">
 <table>
   <tr>
      <td>编号</td> <td><input type="text" name="shopId" value="${info.shopId }" readonly="readonly"/>
      
      </td>
   </tr>
    <tr>
      <td>名称</td> <td><input type="text" name="shopName" value="${info.shopName }" /></td>
   </tr>
    <tr>
      <td>联系人</td> <td><input type="text" name="shopContact" value="${info.shopContact }" /></td>
   </tr>
    <tr>
      <td>电话</td> <td><input type="text" name="telephone" value="${info.telephone }" /></td>
   </tr>
    <tr>
      <td>价格</td> <td><input type="text" name="price" value="${info.price }" /></td>
   </tr>
   <tr>
      <td colspan="2"><input type="submit" /><input type="reset" /></td>
   </tr>
 </table>
</form>

</body>
</html>