<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
	* {
				margin: 0px;
				padding: 0px;
				font-size: 14px;
			}
			/*
			 复合选择器
			 选择器1，选择器2
			 * */
			
			.header,
			.banner {
				/*border:1px solid red;*/
				/*width:70%;
				margin:0 auto;*/
			}
			
			.header {
				padding-left: 0px;
			}
			
			.main {
				width: 70%;
				margin: 0 auto;
			}
			
			.banner {
				background-color: black;
				color: white;
				height: 30px;
				line-height: 25px;
				/*line_height 文本上下居中*/
			}
			
			li {
				/*去掉li的项目符号*/
				list-style: none;
				text-align: center;
				/*文本居中*/
				/*background-color: aliceblue;*/
				width: 80px;
				float: left;
				border-right: 1px solid black;
				height: 20px;
				/*右边框*/
				/*border: 1px solid red;*/
			}
			
			.logo {
				margin-right: 50px;
				margin-left: 0px;
				/*border: 1px solid red;*/
			}
			
			.header_right {
				float: right;
				margin-top: 10px;
			}
			
			.headedr_header {
				margin-bottom: 10px;
			}
			
			img,
			ul {
				/*border:1px solid blue;*/
			}
			
			ul {
				margin-bottom: 10px;
				height: 20px;
			}
			
			.banner ul li {
				border-right: 1px solid white;
				/*background-color: red;*/
				margin-top: 5px;
			}
			
			
			.login_main{
			
				margin-top: 50px;
				margin-right: 10px;
				float: right;
	    		width: 50%;
	    		/*border: 2px red solid;*/
	    		font: arial;
	    		color: burlywood;
	    	}
	    	
	    	.login_main_left{
	    		/*border: 2px red solid;*/
	    		width: 945px;
	    		height: 550px;
	    		background: url("img2/login_left.jpg");
	    		
	    	}
	    	
	    	label{
	    		height:40px;
	    		width:20%;
	    		
	    	}
	    	#username{
	    		height:40px;
				width:80%;
				/*float: right;*/
				/*margin:0 auto;*/   
				/*border: 2px red solid;*/ 		
	    	}
	    	
	    	#password{
	    		height:40px;
	    		width:80%;
	    		/*position:relative;*/
	    		/*display:inline;*/
	    		/*border: 2px red solid;*/
	    	}
	    	#verification_code{}
	    	.register{
	    		width:80%;
	    		margin-left: 11%;
	    		/*border: 2px red solid;*/
	    	}
	    	
		</style>

</head>

<body>

<div class="main">
			<div class="header">
				
				<img class="logo" src="img2/logo.gif" />
				<img class="headedr_header" src="img2/header.jpg" />

				<div class="header_right">
					<ul>
						<li>登录</li>
						<li>注册</li>
						<li>会员中心</li>
						<li>购物指南</li>
						<li class="no_border">关于我们</li>
					</ul>
					<ul>
						<li>购物车</li>
						<li>客服热线</li>

					</ul>
				</div>
			</div>
			
			<div class="banner">
				<ul>
					<li>登录</li>
					<li>注册</li>
					<li>会员中心</li>
					<li>购物指南</li>
					<li>关于我们</li>
				</ul>
			</div>
		
		
		
		<div class="login_main_left">
			
			
		<!--
        	作者：offline
        	时间：2019-07-08
        	描述：分成兩個部分
       -->
			<div class="login_main" >
				
			<!--
	        	作者：offline
	        	时间：2019-07-08
	        	描述：登錄到UserDataServlet，註冊頁面在右邊
	        -->
		   		<form action="UserServlet" method="post">
					<table align="center">
					<tr>
						<td>用户名</td>
						<td><input type="text" name="name"/>    <!-- name 与数据库中的name保持一致 -->
						<input type="hidden" name="action" value="insert"></td> 
					</tr>
					<tr>
						<td>用户ID</td>
						<td><input type="text" name="id"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="注册"/>
							<input type="reset" value="重置"/>
						</td>
					</tr>
					
					
					</table>
				</form>
									
			</div>
				
			
		</div>
	</div>



</body>
</html>