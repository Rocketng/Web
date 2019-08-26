package cn.ccnu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ccnu.pojo.CartGoodsInfo;
import cn.ccnu.pojo.CartUser;
import cn.ccnu.pojo.User;
import cn.ccnu.pojo.ProductInfo;
import cn.ccnu.service.impl.CartGoodsServiceImpl;
import cn.ccnu.service.impl.CartUserServiceImpl;
import cn.ccnu.service.impl.ProductInfoServiceImpl;

import java.sql.*;

/**
 * Servlet implementation class CartGoodsServlet
 */
@WebServlet("/CartGoodsServlet")
public class CartGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartGoodsServiceImpl cartGoodsServiceImpl = new CartGoodsServiceImpl();
	CartUserServiceImpl cartUserServiceImpl = new CartUserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		//通过action判断是哪个操作
		if(action.equals("add")){
			addOneCartGoodsData(request, response);
		}else if(action.equals("deleteOne")){
			deleteOneCartGoodsData(request, response);
		}else if(action.equals("deleteAll")){
			deleteCartAllGoodsData(request,response);
		}else if(action.equals("update")){
			updateCartOneData(request, response);
		}else if(action.equals("getOne")){
			getOneCartGoodsData(request, response);
		}else if(action.equals("getAll")){
			getUserAllGoodsData(request, response);
		}
		
	}

	protected void addOneCartGoodsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		User user = (User)session.getAttribute("u_session");
		int customerId = user.getId();*/
		int customerId=Integer.parseInt(request.getParameter("customerId"));

		
		CartUser cartUser = null;
		int row =0;
		try {
			cartUser = cartUserServiceImpl.showOne(customerId);
			if(cartUser==null){
				//如果没有为用户创建购物车，先创建购物车
				CartUser newCartUser = new CartUser();
				newCartUser.setUser_id(customerId);
				//自增主键
				newCartUser.setCart_id(-1);
				
				cartUserServiceImpl.add(newCartUser);
			}
			else{
				int goodsId = Integer.parseInt(request.getParameter("goodsId"));
				int goodsAccount =Integer.parseInt(request.getParameter("goodsAccount"));
				float price = Float.parseFloat(request.getParameter("price"));
				CartGoodsInfo cartGoodsInfo = new CartGoodsInfo(goodsId,cartUser.getCart_id(),goodsAccount,price);
				row = cartGoodsServiceImpl.add(cartGoodsInfo);
				if(row>0){
					//添加成功??
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("CartGoodsServlet?action=getAll");
		}else{
			
		}
			
	}
	protected void deleteOneCartGoodsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//货物Id
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		//购物车id
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		CartGoodsInfo cartGoodsInfo = new CartGoodsInfo(goodsId,cartId);
		try {
			cartGoodsServiceImpl.delete(cartGoodsInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("CartGoodsServlet?action=getAll");
	}
	protected void deleteCartAllGoodsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//删除某个购物车所有商品
		
				//购物车id
				int cartId = Integer.parseInt(request.getParameter("cartId"));
				int row =0;
				try {
					row = cartGoodsServiceImpl.delete(cartId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				response.sendRedirect("CartGoodsServlet?action=getAll");
	}
	protected void updateCartOneData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		CartUser cartUser = getCartUser(request, response);
		try {
				
				int goodsId = Integer.parseInt(request.getParameter("goodsId"));
				int goodsAccount =Integer.parseInt(request.getParameter("goodsAccount"));
				float price = Float.parseFloat(request.getParameter("price"));
				CartGoodsInfo cartGoodsInfo = new CartGoodsInfo(goodsId,cartUser.getCart_id(),goodsAccount,price);
				int row =0;
				row = cartGoodsServiceImpl.add(cartGoodsInfo);
				if(row>0){
					//添加成功??
				}
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	protected void getOneCartGoodsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartUser cartUser = getCartUser(request, response);
		try {
			CartGoodsInfo cartGoodsInfo = cartGoodsServiceImpl.getOne(cartUser.getCart_id(), cartUser.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取到一行数据后？？？
		
	}
	protected void getUserAllGoodsData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartUser cartUser = getCartUser(request, response);
		System.out.print(cartUser.getCart_id());
		ArrayList< CartGoodsInfo> list = null;
		try {
			list = cartGoodsServiceImpl.getCartAll(cartUser.getCart_id());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(list.size()+"*******");
		//获取到用户数据后？？？
	/*	List<ProductInfo> pilist=new ArrayList<ProductInfo>();
		ProductInfoServiceImpl service=new ProductInfoServiceImpl();
		int length=list.size();
		ProductInfo pi=null;
		while(length>0){
			pi=new ProductInfo();
			try {
				pi=service.showOne(list.get(length-1).getGoodsId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(pi.getDescript());
			pilist.add(pi);
			length--;
		}
		System.out.print(length+"  "+pilist.size());*/
		
		//计算购物车总价
		int length=list.size();
		float sum=0;
		for(int i=0;i<length;i++){
			sum+=list.get(i).getPrice()*list.get(i).getGoodsAccount();
		}
		
		request.setAttribute("sum",sum);
		request.setAttribute("list",list);
		request.getRequestDispatcher("cart/showAll.jsp").forward(request,response);
	}
	protected CartUser getCartUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("u_session");
		int customerId = user.getId();
		
		CartUser cartUser=null;
		try {
			cartUser = cartUserServiceImpl.showOne(customerId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cartUser;
		
	}
}
