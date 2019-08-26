package cn.ccnu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import cn.ccnu.dao.ICartUserDao;
import cn.ccnu.pojo.CartUser;
import cn.ccnu.util.DBHelper;

public class CartUserDaoImpl implements ICartUserDao{
	Connection conn=null;
	PreparedStatement ps=null;
	
	@Override
	public int add(CartUser cu) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		int cart_id=cu.getCart_id();
		int user_id=cu.getUser_id();
		String sql="insert into cart_user values(cart_id,user_id)";
		ps=conn.prepareStatement(sql);
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int delete(int cart_id) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		String sql="delect from cart_user where cart_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cart_id);
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int update(CartUser cu) {
		// TODO Auto-generated method stub		
		return 0;
	}

	@Override
	public CartUser showOne(int cart_id) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		String sql="select * from cart_user where cart_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cart_id);
		ResultSet rs=null;
		rs=ps.executeQuery();
		CartUser cu=new CartUser();
		while(rs.next()){
			cu.setCart_id(rs.getInt("cart_id"));
			cu.setUser_id(rs.getInt("user_id"));
		}
		DBHelper.closeConn(rs, ps, conn);
		
		return cu;
	}

	@Override
	public List<CartUser> showAll() throws Exception {
		// TODO Auto-generated method stub
		List<CartUser> list=new ArrayList<CartUser>();
		conn=DBHelper.getConnection();
		String sql="select * form cart_user";
		ResultSet rs=null;
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		CartUser cu=null;
		while(rs.next()){
			cu=new CartUser();
			cu.setCart_id(rs.getInt("cart_id"));
			cu.setUser_id(rs.getInt("user_id"));
			list.add(cu);
		}
		DBHelper.closeConn(rs, ps, conn);

		return list;
	}
	
}
