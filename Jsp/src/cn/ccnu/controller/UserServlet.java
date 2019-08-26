package cn.ccnu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ccnu.pojo.User;
import cn.ccnu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		
		String action=request.getParameter("action");
		System.out.print(action+"*******************************");
		if(action.equals("insert")){
			add(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("login")){
			login(request,response);
		}else if(action.equals("showOne")){
			showOne(request,response);
		}else if(action.equals("showAll")){
			showAll(request,response);
		}else if(action.equals("adminlogin")){
			adminlogin(request,response);
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取页面参数
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		int i=0;
		UserServiceImpl usi=new UserServiceImpl();
		User u=new User();
		u.setName(name);
		u.setId(id);;
		
		
		try{
			i=usi.add(u);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(i>0){
			response.sendRedirect("login.jsp");
		}else{
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
	       
		int row=0;
		UserServiceImpl service = new UserServiceImpl();
		try {
			row = service.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(row>0){
			response.sendRedirect("UserServlet?action=showAll");
		}else{
			request.setAttribute("msg", "删除失败");
			request.getRequestDispatcher("UserServlet?action=showAll").forward(request, response);
		}	
	}
	private void showOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id=Integer.parseInt(request.getParameter("id"));
		UserServiceImpl service = new UserServiceImpl();
		User u=null;
		u=service.showOne(id);
		System.out.println(u.getId()+"+++++++++++=");
		request.setAttribute("u", u);
		request.getRequestDispatcher("update.jsp").forward(request,response);
	}
	
	private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserServiceImpl usi = new UserServiceImpl();
		List<User> list =null; 
		list=usi.showAll();
			
		request.setAttribute("list", list);
		request.getRequestDispatcher("showUser.jsp").forward(request,response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取参数
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		
		UserServiceImpl usi=new UserServiceImpl();
		int row=usi.update(u);
		
		if(row>0){
			response.sendRedirect("UserServlet?action=showAll");
		}else{
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("UserServlet?action=showOne?id="+id);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	    User u = new User(id, name);  
		boolean flag=false;
		UserServiceImpl service = new UserServiceImpl();
		try {
			flag=service.login(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag==true){
			//获取session
			HttpSession session=request.getSession();
			//将值存到session中
			session.setAttribute("u_session",u);
			response.sendRedirect("ProductInfoServlet?action=showAll");
	    }
	}
	
	private void adminlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	    User u = new User(id, name);  
		boolean flag=false;
		UserServiceImpl service = new UserServiceImpl();
		try {
			flag=service.login(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag==true){
			response.sendRedirect("ProductInfoServlet?action=adminShowAll");
	    }
	}
	
}
