<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>productinfo update</h1>
<form action="ProductInfoServlet?action=update" method="post">
 <table>
   <tr>
      <td>物品编号</td> <td><input type="text" name="productId" value="${info.product_id }" readonly="readonly"/>
      
      </td>
   </tr>
    <tr>
      <td>物品名称</td> <td><input type="text" name="productName" value="${info.product_name }" /></td>
   </tr>
    <tr>
      <td>物品图片</td> <td><input type="text" name="productImg" value="${info.product_img }" /></td>
   </tr>
    <tr>
      <td>物品价格</td> <td><input type="text" name="price" value="${info.price }" /></td>
   </tr>
    <tr>
      <td>物品描述</td> <td><input type="text" name="descript" value="${info.descript }" /></td>
   </tr>
   <tr>
      <td colspan="2"><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
   </tr>
 </table>
</form>


</body>
</html>