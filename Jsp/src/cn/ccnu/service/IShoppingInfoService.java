package cn.ccnu.service;

import java.util.List;

import cn.ccnu.pojo.ShoppingInfo;

public interface IShoppingInfoService {
	int add(ShoppingInfo info) throws Exception;
	int delete(int id) throws Exception;
	int update(ShoppingInfo info) throws Exception;
	List<ShoppingInfo> showAll() throws Exception;
	ShoppingInfo showOne(int id) throws Exception;
}
