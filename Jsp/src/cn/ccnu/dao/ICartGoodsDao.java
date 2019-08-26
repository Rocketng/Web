package cn.ccnu.dao;

import java.util.ArrayList;

import cn.ccnu.pojo.CartGoodsInfo;

public interface ICartGoodsDao {
	int add(CartGoodsInfo cCInfo)throws Exception;
	int delete(CartGoodsInfo cCInfo)throws Exception;
	int update(CartGoodsInfo cCInfo)throws Exception;
	CartGoodsInfo getOne(int cartId,int customerId)throws Exception;
	ArrayList<CartGoodsInfo> getAll()throws Exception;

}
