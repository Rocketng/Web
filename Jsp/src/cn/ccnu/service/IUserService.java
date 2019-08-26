package cn.ccnu.service;

import java.util.List;
import cn.ccnu.pojo.User;

public interface IUserService {
	int add(User u)throws Exception;
	int delete(int id);
	int delete(int[] ids);
	int update(User u);
	List<User> showAll();
	User showOne(int id);
	boolean login(User u) throws Exception;
}
