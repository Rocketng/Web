package cn.ccnu.service.impl;

import java.util.List;

import cn.ccnu.dao.ICartUserDao;
import cn.ccnu.dao.impl.CartUserDaoImpl;
import cn.ccnu.pojo.CartUser;
import cn.ccnu.service.ICartUserService;

public class CartUserServiceImpl implements ICartUserService{
	private ICartUserDao dao=new CartUserDaoImpl();

	@Override
	public int add(CartUser cu) throws Exception {
		// TODO Auto-generated method stub
		return dao.add(cu);
	}

	@Override
	public int delete(int cart_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(cart_id);
	}

	@Override
	public int update(CartUser cu) {
		// TODO Auto-generated method stub
		return dao.update(cu);
	}

	@Override
	public CartUser showOne(int cart_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.showOne(cart_id);
	}

	@Override
	public List<CartUser> showAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

}
