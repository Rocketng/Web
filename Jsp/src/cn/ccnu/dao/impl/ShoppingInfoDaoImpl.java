package cn.ccnu.dao.impl;

import java.sql.*;
import java.util.*;

import cn.ccnu.pojo.*;
import cn.ccnu.util.*;
import cn.ccnu.dao.IShoppingInfoDao;

public class ShoppingInfoDaoImpl implements IShoppingInfoDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private String sql=null;
	
	public ShoppingInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(ShoppingInfo info) throws Exception {
		// TODO Auto-generated method stub
		
		conn=DBHelper.getConnection();
		sql="insert into shopping_info(shop_id,shop_name,shop_contact,telephone,price,modified_time) values(default,?,?,?,?,now())";
		ps=conn.prepareStatement(sql);
		ps.setString(1,info.getShopName());
		ps.setString(2,info.getShopContact());
		ps.setString(3,info.getTelephone());
		ps.setFloat(4,info.getPrice());
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
		conn=DBHelper.getConnection();
		String sql="delete from  shopping_info where shop_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int update(ShoppingInfo info) throws Exception {
		// TODO Auto-generated method stub
		
		conn=DBHelper.getConnection();
		String sql="update shopping_info set shop_name=?,shop_contact=?,telephone=?,price=?,modified_time=now() where shop_id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, info.getShopName());
		ps.setString(2, info.getShopContact());
		ps.setString(3, info.getShopContact());
		ps.setFloat(4, info.getPrice());
		ps.setInt(5, info.getShopId());
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public List<ShoppingInfo> showAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<ShoppingInfo> list=new ArrayList<ShoppingInfo>();
		conn=DBHelper.getConnection();
		String sql="select * from shopping_info";
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			ShoppingInfo info=new ShoppingInfo();
			info.setModifiedTime(rs.getDate("modified_time"));
			info.setPrice(rs.getFloat("Price"));
			info.setShopContact(rs.getString("shop_contact"));
			info.setShopId(rs.getInt("shop_id"));
			info.setShopName(rs.getString("shop_name"));
			info.setTelephone(rs.getString("telephone"));
			list.add(info);
		}
		DBHelper.closeConn(rs, ps, conn);
		
		
		System.out.println("list get");
		
		return list;
	}

	@Override
	public ShoppingInfo showOne(int id) throws Exception {
		// TODO Auto-generated method stub
		
		conn=DBHelper.getConnection();
		sql="select * from shipping_info where shop_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		ShoppingInfo info = new ShoppingInfo();
		while(rs.next()){			
			info.setModifiedTime(rs.getDate("modified_time"));
			info.setPrice(rs.getFloat("price"));
			info.setShopContact(rs.getString("shop_contact"));
			info.setShopId(rs.getInt("shop_id"));
			info.setShopName(rs.getString("shop_name"));
			info.setTelephone(rs.getString("telephone"));
		}
		DBHelper.closeConn(rs, ps, conn);
		
		return info;
	}

}
