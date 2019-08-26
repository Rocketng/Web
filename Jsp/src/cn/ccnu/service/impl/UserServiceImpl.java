package cn.ccnu.service.impl;

import java.util.List;

import cn.ccnu.service.IUserService;
import cn.ccnu.pojo.User;
import cn.ccnu.dao.IUserDao;
import cn.ccnu.dao.impl.UserDaoImpl;



public class UserServiceImpl implements IUserService {
	private IUserDao dao = new UserDaoImpl();

	@Override
	public int add(User u) throws Exception {
		// TODO Auto-generated method stub
		return dao.add(u);
	}

	@Override
	public int delete(int id){
		// TODO Auto-generated method stub
		int row=0;
		try {
			row = dao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(User u) {
		// TODO Auto-generated method stub
		return dao.update(u);
	}

	@Override
	public List<User> showAll() {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

	@Override
	public User showOne(int id) {
		// TODO Auto-generated method stub
		return dao.showOne(id);
	}

	public int delete(int[] ids){
		int row=0;
	  for (int i : ids) {
		  try {
			row=dao.delete(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	}
	  return row;
	}

	@Override
	public boolean login(User u) throws Exception {
		// TODO Auto-generated method stub
		User retUser =dao.showOne(u.getId());
		if(retUser.getId()==u.getId()){
			return true;
		}
		return false;
	}
}
