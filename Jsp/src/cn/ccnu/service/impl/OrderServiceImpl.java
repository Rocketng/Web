package cn.ccnu.service.impl;

import java.util.ArrayList;

import cn.ccnu.dao.impl.OrderDaoImpl;
import cn.ccnu.pojo.Order;
import cn.ccnu.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
	@Override
	public int add(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderDaoImpl.add(order);
	}

	@Override
	public int delete(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return orderDaoImpl.delete(orderId);
	}

	@Override
	public int update(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderDaoImpl.updata(order);
	}

	@Override
	public Order getOne(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return orderDaoImpl.getOneRow(orderId);
	}

	@Override
	public ArrayList<Order> getOneCustomer(int customerId) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> oldList = orderDaoImpl.getAllRow();
		ArrayList<Order> reslutList = new ArrayList<>();
		for(Order order:oldList){
			if(order.getCustomerId()==customerId)
				reslutList.add(order);
		}
		return reslutList;
	}

}
