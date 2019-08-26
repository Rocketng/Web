package cn.ccnu.service;

import java.util.ArrayList;

import cn.ccnu.pojo.CartGoodsInfo;

public interface ICartGoodsService {
	int add(CartGoodsInfo cGInfo)throws Exception;
	int delete(CartGoodsInfo cGInfo)throws Exception;
	//删除某个购物车所有物品
	int delete(int cartId)throws Exception;
	int update(CartGoodsInfo cGInfo)throws Exception;
	//单条记录
	CartGoodsInfo getOne(int cartId,int goodsId)throws Exception;
	ArrayList<CartGoodsInfo> getAll()throws Exception;
	//获取某个购物车所有商品
	ArrayList<CartGoodsInfo> getCartAll(int cartId) throws Exception;


}
