package cn.ccnu.dao;

import java.util.List;

import cn.ccnu.pojo.*;

public interface ICartUserDao {
	int add(CartUser cu) throws Exception;
	int delete(int cart_id) throws Exception;
	int update(CartUser cu);
	CartUser showOne(int cart_id) throws Exception;
	List<CartUser> showAll() throws Exception;
}
