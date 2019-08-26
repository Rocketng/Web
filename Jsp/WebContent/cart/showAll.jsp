<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>Shop Page</title>
		<style>
		      .flex-container {
			    display: -webkit-flex;
			    display: flex;    
				flex-flow: row wrap;
			  }
			
			.flex-item {
			    flex: 0 0 20%;
			    height: 170px;
			    margin: 10px;
			}
			.single-product-widget{
               margin-bottom: 60px;
            }
            .zigzag-bottom {
			  bottom: -50px;
			  height: 100px;
			}
			.single-wid-product h2 {
			    font-size: 14px;
			    margin-bottom: 12px;
			}
			.single-wid-product h2 a {
			    color: #222;
			}
			.single-wid-product h2 a:hover, .single-product h2 a:hover {
			    color: #5a88ca;
			}
			.single-product-widget {
			    position: relative;
			}
			.single-product-area .zigzag-bottom {background-color: #f4f4f4}
			.single-product-area {
			  padding: 80px 0 130px;
			}
		</style>

</head>
<body>
<div id="container" style="width:100%">

<div id="header" style="background:url('img/touwei.jpg')">
<h1 style="margin-bottom:20px;height:70px;line-height:100px" align="center"><span>购物车</span></h1>
<div float="right">
<c:if test="${u_session==null }">
<a href="login.jsp">登录</a>
</c:if>
<c:if test="${u_session!=null }">
 
${u_session.name },${u_session.id },欢迎！
</c:if>

</div>
</div>

<div id="menu" style="height:600px;width:20%;float:left;background:url('img/huise.jpg')">
<b>菜单</b><br>
<a href="ProductInfoServlet?action=showAll">首页</a><br>
<a href="shoppingInfoServlet?action=showAll">物流信息</a><br>
<a href=" ">用户信息</a><br>
<a href="OrderServlet?action=getAll">订单详情</a><br>
退出商城<br>
</div>

<div id="content" style="height:600px;width:80%;float:left;overflow:auto;background:url('img/feiji.jpg');" align="center">
	<h style="float:left">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp商品总价：${sum }</h>
	<h align="center"><a href="CartGodsServlet?action=deleteAll">删除所有物品</a></h>
	
    <div class="single-product-area">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                     <div class="flex-container">
                      <c:forEach items="${list}" var="u">
					  <div class="flex-item" style="background:url('img/baise.jpg')" align="center" >
					  <br>
					 	购物车id${u.cartId }<br>
					 	物品id:${u.goodsId}<br>
					 	物品数量：${u.goodsAccount }<br>
					 	物品单价：${u.price }<br>
					 	<a href="CartGoodsServlet?action=deleteOne&goodsId=${u.goodsId }&cartId=${u.cartId}">删除</a>
					 	<a href="。">更新</a>
					 	<a href="order/add.jsp?goodsId=${u.goodsId }&price=${u.price}">提交订单</a>
				      </div>
					  </c:forEach>
					   
				      </div> 
					 </div>
					</div>
				</div>
			</div>
	  </div>
</div>

<div id="footer" style="background:url('img/touwei.jpg');clear:both;text-align:center;">
版权 © bingxixi.com</div>

</div>

</body>
</html>