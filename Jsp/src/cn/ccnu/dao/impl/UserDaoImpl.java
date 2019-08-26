package cn.ccnu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;                //û�õ�
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
		//�����������		
		conn=DBHelper.getConnection();
		//��Connection�����л�ȡstatement����
		ps = conn.prepareStatement(sql);
		//Ϊռλ����ֵ
		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		//statement����ִ��sql���
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
		//�����������		
		conn=DBHelper.getConnection();
		//��Connection�����л�ȡstatement����
		ps = conn.prepareStatement(sql);
		//Ϊռλ����ֵ
		ps.setInt(1, id);
		//statement����ִ��sql���
		i=ps.executeUpdate();		
		DBHelper.closeConn(null, ps, conn);
		
		return i;
	}

	@Override
	public int update(User u){
		// TODO Auto-generated method stub
		
		String sql="update customer_inf set customer_name=? where customer_id=?";
		
		Connection conn=null;
		/* ���ݿ������� */
		PreparedStatement ps=null;
		/* Statementִ�в���������SQL���  PrepareStatementִ�д�������SQL���               ���������ɽ���Ķ���  */
		
		int i=0;
		try{
				//�����������		
			conn=DBHelper.getConnection();
			//��Connection�����л�ȡstatement����
			ps = conn.prepareStatement(sql);
			//Ϊռλ����ֵ
			ps.setString(1, u.getName());
			ps.setInt(2,u.getId());
			//statement����ִ��sql���
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
		//List���ϴ�Ŷ������
		List<User> list =new ArrayList<User>();
		
		String sql="select * from customer_inf";
		
		Connection conn=null;
		/* ���ݿ������� */
		PreparedStatement ps=null;
		/* Statementִ�в���������SQL���  PrepareStatementִ�д�������SQL���               ���������ɽ���Ķ���  */
		ResultSet rs=null;
		/* java.sql.ResultSet�ӿڱ�ʾһ�����ݿ��ѯ����ļ��ϡ�һ��ResultSet�������һ���α�ָ��ǰ�еĽ���� ��next()�����Ƶ���һ�� ��û����һ��ʱ����false*/
		
		
		//����������ݿ�����
		try{
			conn=DBHelper.getConnection();
			
			//�������Ӷ��� ,������������䷢�͵����ݿ�����һ��PreparedStatement���󣬸ö����ܼ����Զ����ɵļ�
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			/*
			 executeQuery����ִ�� select��䣬���ݿ���Ӧ�Ĳ�ѯ������ص�ResultSet��Ķ�����
			 executeUpdate ����ִ��insert update�Լ�delete���  ���������ݿ���Ӱ�������
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
