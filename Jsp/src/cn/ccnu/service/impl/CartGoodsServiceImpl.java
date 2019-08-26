package cn.ccnu.service.impl;

import java.util.ArrayList;

import cn.ccnu.dao.impl.CartGoodsDaoImpl;
import cn.ccnu.pojo.CartGoodsInfo;
import cn.ccnu.service.ICartGoodsService;

public class CartGoodsServiceImpl implements ICartGoodsService {
	private CartGoodsDaoImpl cartGoodsDaoImpl = new CartGoodsDaoImpl();

	@Override
	public int add(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		return cartGoodsDaoImpl.add(cGInfo);
	}

	@Override
	public int delete(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		return cartGoodsDaoImpl.delete(cGInfo);
	}

	@Override
	public int delete(int cartId) throws Exception {
		// TODO Auto-generated method stub
		CartGoodsInfo cartGoodsInfo = new CartGoodsInfo(-1,cartId);
		return cartGoodsDaoImpl.delete(cartGoodsInfo);
	}
	@Override
	public int update(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		return cartGoodsDaoImpl.update(cGInfo);
	}

	@Override
	public CartGoodsInfo getOne(int cartId, int goodsId) throws Exception {
		// TODO Auto-generated method stub
		return cartGoodsDaoImpl.getOne(cartId, goodsId);
	}

	@Override
	public ArrayList<CartGoodsInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		return cartGoodsDaoImpl.getAll();
	}

	@Override
	public ArrayList<CartGoodsInfo> getCartAll(int cartId) throws Exception {
		// TODO Auto-generated method stub
		//如果货物编号为-1则为该购物车全体物品
		ArrayList<CartGoodsInfo> list = cartGoodsDaoImpl.getAll();
		//目标货物
		ArrayList<CartGoodsInfo> list2  = new ArrayList<CartGoodsInfo>();
		int lenth = list.size();
		System.out.println(lenth);
		while(lenth>0){
		//	System.out.println(list.get(lenth-1).getGoodsId());
			if(list.get(lenth-1).getCartId()==cartId){
				list2.add(list.get(lenth-1));
			}
			lenth--;
		}
		System.out.print(list2.size());
		return list2;
	}
	

}
