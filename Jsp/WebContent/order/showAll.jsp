<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
        	.order_main{
        		background-color: white;
        	}
        	.order_main_item{
        		float: left;
        		/*height: 15%;*/
        		width: 100%;
        		background-color: wheat;
        		border: 3px burlywood  solid;
        	}
        	.order_main_item_goodsId{
        		/*float: left;*/
        		/*width: 8%;*/
        		border-right: 2px white  solid ;
        		margin-top:5px ;
        		align-content: center;
        	}
        	.order_main_item_goodsId div{
        		/*float: left;*/
        		padding-left: 2px;
        		align-content: center;
        		/*border: white 1px solid;*/
        		/*background-color: white;*/
        	}
        	
        	
        	.order_main_item_shopId{
        		/*float: left;*/
        		/*width: 15%;*/
        	}
        	.order_main_item_shopId div{
        		/*float: left;*/
        		align-content: center;
        		
        	}
        	
        	
        	.order_main_item_customerName{
        		/*float: left;*/
        		/*width: 12%;*/
        	}
        	.order_main_item_customerName div{
        		/*float: left;*/
        		
        	}
        	
        	.order_main_item_orderMoney{
        		/*float: left;*/
        		/*width: 10%;*/
        	}
        	.order_main_item_orderMoney div{
        		/*float: left;*/
        	
        	}
        	
        	.order_main_item_payWay{
    			/*float: left;*/
    			/*width: 20%;*/
        	}
        	.order_main_item_payWay div{
    			/*float: left;*/
    
        	}
        	
        	
        	.order_main_item_payTime{
        		/*float: left;*/
        		/*width: 25%;*/
        	}
        	.order_main_item_payTime div{
        		/*float: left;*/
        	
        	}
        	
        	。order_main_item_update{
        		/*width: 10%;*/
        	}
        	
        	td{
        		text-align: center;
        	}
        	table{
        		width: 70%;
        		margin-left: 15%;
        	}
        </style>
</head>
<body>
<div id="container" style="width:100%">

<div id="header" style="background:url('img/touwei.jpg')">
<h1 style="margin-bottom:20px;height:70px;line-height:100px" align="center"><span>订单详情</span></h1>
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
<a href="CartGoodsServlet?action=getAll">购物车</a><br>
<a href="shoppingInfoServlet?action=showAll">物流信息</a><br>
<a href=" ">用户信息</a><br>
退出商城<br>
</div>

<div id="content" style="height:600px;width:80%;float:left;overflow:auto;background:url('img/feiji.jpg');" align="center">
	
	<div class="order_main">
	 		
    		<div class="order_main_item">
    		<table>
    			<tr class="table_head">
    					<!--<div class="order_main_item_goodsId">-->
		    					<td >
		    						<div>货物编号</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				<!--快递单号-->
		    				
		    				<!--<div class="order_main_item_shopId">-->
		    					<td >
		    						<div>快递单号</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_customerName">-->
		    					<td >
		    						<div>用户姓名</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_orderMoney">-->
		    					<td >
		    						<div>订单金额</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				<!--<div  style="width: 50% ;float: left;">-->
		    					<td >
		    						<div >
		    							支付方式
		    						</div>
		    						
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_payTime">-->
		    					<td>
		    						<div>付款时间</div>
		    					</td>
		    					
		    					<td >
		    						<div>
		    							操作
		    						</div>
		    					</td>
		    				
    					
    			</tr>
    			
    		<c:forEach items="${list}" var="u">
		    			<tr>
		    				
		    				<!--<div class="order_main_item_goodsId">-->
		    					<td class="order_main_item_goodsId">
		    						<div>${u.goodsId}</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				<!--快递单号-->
		    				
		    				<!--<div class="order_main_item_shopId">-->
		    					<td class="order_main_item_shopId">
		    						<div>${u.shopId}</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_customerName">-->
		    					<td class="order_main_item_customerName">
		    						<div>${u.customerName}</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_orderMoney">-->
		    					<td class="order_main_item_orderMoney">
		    						<div>${u.orderMoney}</div>
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				<!--<div  style="width: 50% ;float: left;">-->
		    					<td class="order_main_item_payWay">
		    						<div>
		    							
		    							<c:if test="${u.payWay==1}">
		    							<img src="img2/zfb.jpg" style="width: 100px;height: 80px;"/>
		    							</c:if>
		    							<c:if test="${u.payWay==2}">
		    							<img src="img2/wx.jpg" style="width: 100px;height: 80px;"/>
		    							</c:if>	
		    							<c:if test="${u.payWay==3}">
		    							<img src="img2/zgyh.jpg" style="width: 100px;height: 80px;"/>
		    							</c:if>	
		    							<c:if test="${u.payWay==4}">
		    							<img src="img2/zggsyh.jpg" style="width: 100px;height: 80px;"/>
		    							</c:if>		
		    						</div>
		    						
		    					</td>
		    				<!--</div>-->
		    				
		    				
		    				
		    				<!--<div class="order_main_item_payTime">-->
		    					<td class="order_main_item_payTime">
		    						<div>${u.payTime }</div>
		    					</td>
		    					
		    					
		    					<td class="order_main_item_update">
		    						<div>
		    							<input type="button" onclick="" name="update" value="修改"  style="background-color:white;border:2px wheat solid; font-size:18px;"/>
		    						</div>
		    					</td>
		    				
		    			</tr>
		    			</c:forEach>
    				</table>
    			</div>
    		
    	</div>
    
</div>

<div id="footer" style="background:url('img/touwei.jpg');clear:both;text-align:center;">
版权 © bingxixi.com</div>

</body>
</html>