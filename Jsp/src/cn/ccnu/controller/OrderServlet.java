package cn.ccnu.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import cn.ccnu.pojo.Order;
import cn.ccnu.pojo.User;
import cn.ccnu.service.impl.CartGoodsServiceImpl;
import cn.ccnu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		//通过action判断是哪个操作
		if(action.equals("add")){
			addOneOrder(request, response);
		}else if(action.equals("delete")){
			deleteOrder(request, response);
		}else if(action.equals("update")){
			updateOrderOne(request, response);
		}else if(action.equals("getOne")){
			getOneOrder(request, response);
		}else if(action.equals("getAll")){
			getUserAllOrder(request, response);
		}
	}
	protected void addOneOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//用于用户下单
				//購物車編號每個用戶只有一個，購物車編號不用輸入
				//從页面获取 货物id 支付方式  支付金额  当前时间为下单时间  发货时间为数据存入数据库的时间  付款时间为当前时间  下单状态为已付款
				//通过session获取用户编号
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("u_session");
				int customerId = user.getId();
				String customerName = user.getName();
				
				int goodsId = Integer.parseInt(request.getParameter("goodsId"));
				int payWay = Integer.parseInt(request.getParameter("payWay"));
				float money=Float.parseFloat(request.getParameter("price"));
				String customerAddress = request.getParameter("customerAddress");
				//用当前时间实例化一个时间对象
				Date date = new Date(System.currentTimeMillis());
				//实例化一个修改时间显示格式对象
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//修改时间显示格式
				String currentTime = simpleDateFormat.format(date);
				
				Order order = new Order();
				//使用默认订单-1,用自动增加
				order.setOrderId(-1);
				order.setGoodsId(goodsId);
				order.setCustomerId(customerId);
				//使用默认订单-1，在service层获取当前当前最大快递单号加一
				order.setShopId(2);
				//在service层获取当前用户的姓名,使用session获取
				order.setCustomerName(customerName);
				order.setCustomerAddress(customerAddress);
				order.setPayWay(payWay);
				//当前获取价格,在service层获取当前购物车所有货物 的价格和数量
				order.setOrderMoney(money);
				order.setOrderTime(currentTime);
				//发货时间为存入数据库的时间
				order.setSendTime("");
				//付款时间为当前时间
				order.setPayTime(currentTime);
				//当前下单状态为以下单
				order.setOrderStatus(1);
				
				try {
					orderServiceImpl.add(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				response.sendRedirect("OrderServlet?action=getAll");
	}
		protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int orderId =Integer.parseInt( request.getParameter("orderId"));
			try {
				orderServiceImpl.delete(orderId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//删除后跳转？？
		}
		
		protected void updateOrderOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//通过session获取用户编号
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("u_session");
			int customerId = user.getId();
			String customerName = user.getName();
			
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			int payWay = Integer.parseInt(request.getParameter("payWay"));
			String customerAddress = request.getParameter("customerAddress");
			//用当前时间实例化一个时间对象
			Date date = new Date(System.currentTimeMillis());
			//实例化一个修改时间显示格式对象
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//修改时间显示格式
			String currentTime = simpleDateFormat.format(date);
			
			Order order = new Order();
			//使用默认订单-1,用自动增加
			order.setOrderId(-1);
			order.setGoodsId(goodsId);
			//使用默认订单-1，在service层获取当前当前最大快递单号加一
			order.setCustomerId(customerId);
			order.setShopId(-1);
			//在service层获取当前用户的姓名,使用session获取
			order.setCustomerName(customerName);
			order.setCustomerAddress(customerAddress);
			order.setPayWay(payWay);
			//当前获取价格,在service层获取当前购物车所有货物 的价格和数量
			order.setOrderMoney(0);
			order.setOrderTime(currentTime);
			//发货时间为存入数据库的时间
			order.setSendTime("");
			//付款时间为当前时间
			order.setPayTime(currentTime);
			//当前下单状态为以下单
			order.setOrderStatus(1);
			
			try {
				orderServiceImpl.update(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//修改后跳转页面？？
		}
		protected void getOneOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int orderId = Integer.parseInt((request.getParameter("orderId")));
			Order order=null;
			try {
				order = orderServiceImpl.getOne(orderId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//页面跳转？？
			/*request.setAttribute("order", order);
			request.getRequestDispatcher("order/add.jsp").forward(request, response);*/
		}
		protected void getUserAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//在service层获取用户id 用session获取
			//通过session获取用户编号
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("u_session");
			int customerId = user.getId();
			ArrayList<Order> list=null;
			try {
				 list = orderServiceImpl.getOneCustomer(customerId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//界面跳转????
			System.out.println("%%%%%%%%"+list.size());
			request.setAttribute("list", list);
			request.getRequestDispatcher("order/showAll.jsp").forward(request, response);
		}
		
}
