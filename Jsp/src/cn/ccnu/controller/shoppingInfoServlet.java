package cn.ccnu.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccnu.pojo.*;
import cn.ccnu.service.*;
import cn.ccnu.service.impl.*;
/**
 * Servlet implementation class shoppingInfoServlet
 */
@WebServlet("/shoppingInfoServlet")
public class shoppingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取action类型
		String action=request.getParameter("action");
		System.out.println(action+"----------shoppingInfo");
		if(action.equals("add")){
			add(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("showOne")){
			showOne(request,response);
		}else if(action.equals("showAll")){
			System.out.println(action+"----------shoppingInfo");
			showAll(request,response);
		}
		
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取info
		String name=request.getParameter("shopName");
		String contact=request.getParameter("shopContact");
		String tel=request.getParameter("telephone");
		float price = Float.parseFloat(request.getParameter("price"));
		ShoppingInfo info=new ShoppingInfo(name,contact,tel,price);
		int row=0;
		ShoppingInfoServiceImpl service=new ShoppingInfoServiceImpl();
		try{
			row=service.add(info);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("shoppingInfoServlet?action=showAll");
		}
	}
	

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取info
		int id=Integer.parseInt(request.getParameter("shopId"));
		int row=0;
		ShoppingInfoServiceImpl service=new ShoppingInfoServiceImpl();
		try{
			row=service.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(row<=0){
			request.setAttribute("msg", "删除失败");
		}
		request.getRequestDispatcher("shoppingInfoServlet?action=showAll").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取info
		String name=request.getParameter("shopName");
		String contact=request.getParameter("shopContact");
		String tel=request.getParameter("telephone");
		int id=Integer.parseInt(request.getParameter("shopId"));
		float price = Float.parseFloat(request.getParameter("price"));
		ShoppingInfo info=new ShoppingInfo(id,name,contact,tel,price);
		
		ShoppingInfoServiceImpl service=new ShoppingInfoServiceImpl();
		int row=0;
		try{
			row=service.update(info);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("shoppingInfoServlet?action=showAll");
		}else{
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}
	protected void showOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("shopId"));//shipId是超链接?后的名字
		 ShoppingInfo info = null;	
		 ShoppingInfoServiceImpl service=new ShoppingInfoServiceImpl();
		 try {
			 info = service.showOne(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 request.setAttribute("info", info);
		request.getRequestDispatcher("shoppingInfo/update.jsp").forward(request, response);
	}
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingInfoServiceImpl service=new ShoppingInfoServiceImpl();
		
		List<ShoppingInfo> list=null;
		try {
			list = service.showAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("shoppingInfo/showAll.jsp").forward(request, response);
	}
	
	

}
