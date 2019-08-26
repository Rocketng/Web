package cn.ccnu.dao;

import java.sql.SQLException;
import java.util.List;
import cn.ccnu.pojo.User;

public interface IUserDao {
	int add(User u) throws Exception;
	int delete(int id) throws Exception;
	int update(User u);
	List<User> showAll();
	User showOne(int id);
}
