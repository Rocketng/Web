<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="CartGoodsServlet?action=update" method=post>

 <table>
   <tr>
      <td>购物车编号</td> <td><input type="text" name="cartId" value="${cartID}" readonly="readonly"/>
      
      </td>
   </tr>
    <tr>
      <td>物品编号</td> <td><input type="text" name="goodsId" value="${goodsId }" /></td>
   </tr>
    <tr>
      <td>物品数量</td> <td><input type="text" name="goodsAccount" value="${goodsAccount}"/></td>
   </tr>
    <tr>
      <td>物品单格</td> <td><input type="text" name="price" value="${price }" /></td>
   </tr>
   <tr>
      <td colspan="2"><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
   </tr>
 </table>
</form>

</body>
</html>