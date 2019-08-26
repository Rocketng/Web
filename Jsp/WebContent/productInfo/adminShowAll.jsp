<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

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
			    height: 150px;
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

<!-- c:forEach表示循环   items表示从这里取值 放在var中-->
 <c:forEach items="${list}" var="u">
 </c:forEach>
    <div class="single-product-area">
        <!-- <div class="zigzag-bottom"></div> -->
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                     <div class="flex-container">
                      <c:forEach items="${list}" var="u">
					  <div class="flex-item">
					  <img src="${u.product_img}" height=50px><br>
					  ${u.descript }<br>${u.price }元<br>${u.product_id }<br>${u.product_name }<br>
	                         <a href="ProductInfoServlet?action=delete&productId=${u.product_id}">删除</a>
						     &nbsp;&nbsp;
				             <a href="ProductInfoServlet?action=showOne&productId=${u.product_id }">修改</a>
				      </div>
					  </c:forEach>
					   
				      </div> 
					 </div>
					</div>
				</div>
			</div>
	  </div>
   <a href="productInfo/add.jsp">添加物品</a>
<form action="UserServlet?action=showAll" method="post">
<input type="submit" value="显示所有用户"><br>
</form>


</body>
</html>