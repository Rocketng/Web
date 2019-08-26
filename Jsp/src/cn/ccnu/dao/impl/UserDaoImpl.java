package cn.ccnu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;                //没用到
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ccnu.dao.IUserDao;
import cn.ccnu.pojo.User;
import cn.ccnu.util.DBHelper;

public class UserDaoImpl implements IUserDao{
	@Override
	public int add(User u)  throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into customer_inf(customer_inf_id,customer_id,customer_name) values(default,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		//反射加载驱动		
		conn=DBHelper.getConnection();
		//从Connection对象中获取statement对象
		ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		//statement对象执行sql语句
		i=ps.executeUpdate();		
		DBHelper.closeConn(null, ps, conn);
		
		return i;
	}

	@Override
	public int delete(int id) throws Exception{
		// TODO Auto-generated method stub
		String sql="delete from customer_inf where customer_id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		//反射加载驱动		
		conn=DBHelper.getConnection();
		//从Connection对象中获取statement对象
		ps = conn.prepareStatement(sql);
		//为占位符赋值
		ps.setInt(1, id);
		//statement对象执行sql语句
		i=ps.executeUpdate();		
		DBHelper.closeConn(null, ps, conn);
		
		return i;
	}

	@Override
	public int update(User u){
		// TODO Auto-generated method stub
		
		String sql="update customer_inf set customer_name=? where customer_id=?";
		
		Connection conn=null;
		/* 数据库连接类 */
		PreparedStatement ps=null;
		/* Statement执行不带参数的SQL语句  PrepareStatement执行带参数的SQL语句               都返回生成结果的对象  */
		
		int i=0;
		try{
				//反射加载驱动		
			conn=DBHelper.getConnection();
			//从Connection对象中获取statement对象
			ps = conn.prepareStatement(sql);
			//为占位符赋值
			ps.setString(1, u.getName());
			ps.setInt(2,u.getId());
			//statement对象执行sql语句
			i=ps.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				DBHelper.closeConn(null, ps, conn);
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return i;
	}

	@Override
	public List<User> showAll() {
		// TODO Auto-generated method stub
		//List集合存放多个对象
		List<User> list =new ArrayList<User>();
		
		String sql="select * from customer_inf";
		
		Connection conn=null;
		/* 数据库连接类 */
		PreparedStatement ps=null;
		/* Statement执行不带参数的SQL语句  PrepareStatement执行带参数的SQL语句               都返回生成结果的对象  */
		ResultSet rs=null;
		/* java.sql.ResultSet接口表示一个数据库查询结果的集合。一个ResultSet对象具有一个游标指向当前行的结果集 ，next()方法移到下一行 ，没有下一行时返回false*/
		
		
		//反射加载数据库驱动
		try{
			conn=DBHelper.getConnection();
			
			//利用连接对象 ,将参数化的语句发送到数据库生成一个PreparedStatement对象，该对象能检索自动生成的键
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			/*
			 executeQuery用来执行 select语句，数据库响应的查询结果返回到ResultSet类的对象中
			 executeUpdate 用于执行insert update以及delete语句  ，返回数据库受影响的行数
			 */
			
			User u;
			while(rs.next()){
				int id=rs.getInt("customer_id");
				String name=rs.getString("customer_name");
				u=new User();
				u.setId(id);
				u.setName(name);
				list.add(u);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)
					rs.close();
		        if(ps!=null)
		        	ps.close();
		        if(conn!=null)
		        	conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(list.isEmpty()){
			System.out.println("1111111111111111111111111111111111111");
		}else{
			System.out.println("222222222222222222222222222222222222222");
		}
		
		return list;
	}

	@Override
	public User showOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		
		try{
			conn=DBHelper.getConnection();
			
			ps=conn.prepareStatement("select * from customer_inf where customer_id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("customer_id"));
				u.setName(rs.getString("customer_name"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return u;
	}
}
