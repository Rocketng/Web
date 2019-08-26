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
		//ͨ��action�ж����ĸ�����
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
				//�����û��µ�
				//ُ��܇��̖ÿ���Ñ�ֻ��һ����ُ��܇��̖����ݔ��
				//��ҳ���ȡ ����id ֧����ʽ  ֧�����  ��ǰʱ��Ϊ�µ�ʱ��  ����ʱ��Ϊ���ݴ������ݿ��ʱ��  ����ʱ��Ϊ��ǰʱ��  �µ�״̬Ϊ�Ѹ���
				//ͨ��session��ȡ�û����
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("u_session");
				int customerId = user.getId();
				String customerName = user.getName();
				
				int goodsId = Integer.parseInt(request.getParameter("goodsId"));
				int payWay = Integer.parseInt(request.getParameter("payWay"));
				float money=Float.parseFloat(request.getParameter("price"));
				String customerAddress = request.getParameter("customerAddress");
				//�õ�ǰʱ��ʵ����һ��ʱ�����
				Date date = new Date(System.currentTimeMillis());
				//ʵ����һ���޸�ʱ����ʾ��ʽ����
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//�޸�ʱ����ʾ��ʽ
				String currentTime = simpleDateFormat.format(date);
				
				Order order = new Order();
				//ʹ��Ĭ�϶���-1,���Զ�����
				order.setOrderId(-1);
				order.setGoodsId(goodsId);
				order.setCustomerId(customerId);
				//ʹ��Ĭ�϶���-1����service���ȡ��ǰ��ǰ����ݵ��ż�һ
				order.setShopId(2);
				//��service���ȡ��ǰ�û�������,ʹ��session��ȡ
				order.setCustomerName(customerName);
				order.setCustomerAddress(customerAddress);
				order.setPayWay(payWay);
				//��ǰ��ȡ�۸�,��service���ȡ��ǰ���ﳵ���л��� �ļ۸������
				order.setOrderMoney(money);
				order.setOrderTime(currentTime);
				//����ʱ��Ϊ�������ݿ��ʱ��
				order.setSendTime("");
				//����ʱ��Ϊ��ǰʱ��
				order.setPayTime(currentTime);
				//��ǰ�µ�״̬Ϊ���µ�
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
			//ɾ������ת����
		}
		
		protected void updateOrderOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//ͨ��session��ȡ�û����
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("u_session");
			int customerId = user.getId();
			String customerName = user.getName();
			
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			int payWay = Integer.parseInt(request.getParameter("payWay"));
			String customerAddress = request.getParameter("customerAddress");
			//�õ�ǰʱ��ʵ����һ��ʱ�����
			Date date = new Date(System.currentTimeMillis());
			//ʵ����һ���޸�ʱ����ʾ��ʽ����
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//�޸�ʱ����ʾ��ʽ
			String currentTime = simpleDateFormat.format(date);
			
			Order order = new Order();
			//ʹ��Ĭ�϶���-1,���Զ�����
			order.setOrderId(-1);
			order.setGoodsId(goodsId);
			//ʹ��Ĭ�϶���-1����service���ȡ��ǰ��ǰ����ݵ��ż�һ
			order.setCustomerId(customerId);
			order.setShopId(-1);
			//��service���ȡ��ǰ�û�������,ʹ��session��ȡ
			order.setCustomerName(customerName);
			order.setCustomerAddress(customerAddress);
			order.setPayWay(payWay);
			//��ǰ��ȡ�۸�,��service���ȡ��ǰ���ﳵ���л��� �ļ۸������
			order.setOrderMoney(0);
			order.setOrderTime(currentTime);
			//����ʱ��Ϊ�������ݿ��ʱ��
			order.setSendTime("");
			//����ʱ��Ϊ��ǰʱ��
			order.setPayTime(currentTime);
			//��ǰ�µ�״̬Ϊ���µ�
			order.setOrderStatus(1);
			
			try {
				orderServiceImpl.update(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�޸ĺ���תҳ�棿��
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
			//ҳ����ת����
			/*request.setAttribute("order", order);
			request.getRequestDispatcher("order/add.jsp").forward(request, response);*/
		}
		protected void getUserAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//��service���ȡ�û�id ��session��ȡ
			//ͨ��session��ȡ�û����
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
			//������ת????
			System.out.println("%%%%%%%%"+list.size());
			request.setAttribute("list", list);
			request.getRequestDispatcher("order/showAll.jsp").forward(request, response);
		}
		
}
