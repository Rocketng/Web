package cn.ccnu.dao;

import java.util.ArrayList;

import cn.ccnu.pojo.Order;

public interface IOrderDao {
	//与数据库对接的底层接口
	
	//添加一行，返回修改在行数
	int add(Order order)throws Exception;
	//删除指定行，返回修改在行数
	int delete(int orderId)throws Exception;
	//更新指定行，返回修改在行数
	int updata(Order order)throws Exception;
	//查询获取所有行
	ArrayList<Order> getAllRow()throws Exception;
	//查询获取一行
	Order getOneRow( int orderId)throws Exception;
	
}
