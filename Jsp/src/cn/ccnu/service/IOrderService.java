package cn.ccnu.service;

import java.util.ArrayList;

import cn.ccnu.pojo.Order;

public interface IOrderService {
	int add(Order order)throws Exception;
	int delete(int orderId)throws Exception;
	int update(Order order)throws Exception;
	Order getOne(int orderId)throws Exception;
	//某一用戶的所有訂單信息
	ArrayList<Order> getOneCustomer(int customerId)throws Exception;
	
}
