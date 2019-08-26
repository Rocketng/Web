package cn.ccnu.service;

import java.util.ArrayList;

import cn.ccnu.pojo.CartGoodsInfo;

public interface ICartGoodsService {
	int add(CartGoodsInfo cGInfo)throws Exception;
	int delete(CartGoodsInfo cGInfo)throws Exception;
	//ɾ��ĳ�����ﳵ������Ʒ
	int delete(int cartId)throws Exception;
	int update(CartGoodsInfo cGInfo)throws Exception;
	//������¼
	CartGoodsInfo getOne(int cartId,int goodsId)throws Exception;
	ArrayList<CartGoodsInfo> getAll()throws Exception;
	//��ȡĳ�����ﳵ������Ʒ
	ArrayList<CartGoodsInfo> getCartAll(int cartId) throws Exception;


}
