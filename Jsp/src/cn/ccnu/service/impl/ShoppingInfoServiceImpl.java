package cn.ccnu.service.impl;

import java.util.List;

import cn.ccnu.pojo.ShoppingInfo;
import cn.ccnu.service.IShoppingInfoService;
import cn.ccnu.dao.IShoppingInfoDao;
import cn.ccnu.dao.impl.ShoppingInfoDaoImpl;

public class ShoppingInfoServiceImpl implements IShoppingInfoService{
	private ShoppingInfoDaoImpl dao=new ShoppingInfoDaoImpl(); 
	
	@Override
	public int add(ShoppingInfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.add(info);
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(ShoppingInfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(info);
	}

	@Override
	public List<ShoppingInfo> showAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

	@Override
	public ShoppingInfo showOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.showOne(id);
	}

}
