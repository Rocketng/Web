package cn.ccnu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccnu.dao.impl.ProductInfoDaoImpl;
import cn.ccnu.pojo.ProductInfo;
import cn.ccnu.service.impl.ProductInfoServiceImpl;

/**
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ProductInfoServiceImpl service=new ProductInfoServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action=request.getParameter("action");
		if(action.equals("insert")){
			add(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("showOne")){
			showOne(request,response);
		}else if(action.equals("showAll")){
			showAll(request,response);
		}else if(action.equals("adminShowAll")){
			adminShowAll(request,response);
		}
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id=Integer.parseInt(request.getParameter("productId"));
		String name=request.getParameter("productName");
		String img=request.getParameter("productImg");
		float price=Float.parseFloat(request.getParameter("price"));
		String descript=request.getParameter("descript");
		ProductInfo info=new ProductInfo(name,img,price,descript);
		int row=0;
		try {
			row=service.add(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("ProductInfoServlet?action=showAll");
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("productId"));
		int row=0;
		try {
			row=service.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row<=0){
			request.setAttribute("msg", "É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("ProductInfoServlet?action=showAll").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("productId"));
		String name=request.getParameter("productName");
		String img=request.getParameter("productImg");
		float price=Float.parseFloat(request.getParameter("price"));
		String descript=request.getParameter("descript");
		ProductInfo info=new ProductInfo(id,name,img,price,descript);
		int row=0;
		try {
			row=service.update(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("ProductInfoServlet?action=showAll");
		}else{
			request.setAttribute("msg", "ÐÞ¸ÄÊ§°Ü");
			request.getRequestDispatcher("ProductInfoServlet?action=showOne&id="+id);
		}
	}
	
	protected void showOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("productId"));
		ProductInfo info=null;
		try {
			info=service.showOne(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(info!=null){
			request.setAttribute("info", info);
			request.getRequestDispatcher("productInfo/update.jsp").forward(request,response);
		}
	}
	
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductInfo> list=null;
		try {
			list=service.showAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("productInfo/showAll.jsp").forward(request, response);
	}
	
	protected void adminShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductInfo> list=null;
		try {
			list=service.showAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("productInfo/adminShowAll.jsp").forward(request, response);
	}
}
