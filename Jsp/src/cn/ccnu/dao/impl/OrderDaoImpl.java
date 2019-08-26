package cn.ccnu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import cn.ccnu.dao.IOrderDao;
import cn.ccnu.pojo.Order;
import cn.ccnu.pojo.User;
import cn.ccnu.util.DBHelper;

public class OrderDaoImpl implements IOrderDao {
	//�����������ӣ���DriverManager.getCreateConnection������������
		private Connection connection = null;
		//��connection������,Ԥ�������
		private PreparedStatement preparedStatement = null;
		
	@Override
	public int add(Order order) throws Exception {
		// TODO Auto-generated method stub
		//��preparedStatementִ�����󷵻صĽ����,�������û�з��ؼ��ϣ�ֻ�Ƿ���һ��ƾ֤�����޸��˶�����
				//ResultSet resultSet = null;
				//�������ݿ������
				String sql_insert = "insert into order_inf(order_id,goods_id,customer_id,shop_id,customer_name,customer_address,pay_way,order_money,order_time,send_time,pay_time,order_status) values(default,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				//��ǰʱ��
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
				String currenttime = simpleDateFormat.format(date);
				//����ʱ��
				
				
				//���޸�������
				int row =0;
				
				try {
					
					//ʵ�������Ӷ���
					connection = DBHelper.getConnection();
					//PreparedStatement ����,Ԥ�������sql_insert
					preparedStatement = connection.prepareStatement(sql_insert);
					
					//��ռλ����ֵ,���뵽���ݿ��е�����Ϊ���ݹ����Ķ���u
					//preparedStatement.setInt(1, order.getOrderId());
					preparedStatement.setInt(1, order.getGoodsId());
					preparedStatement.setInt(2, order.getCustomerId());
					preparedStatement.setInt(3, order.getShopId());
					preparedStatement.setString(4, order.getCustomerName());
					preparedStatement.setString(5, order.getCustomerAddress());
					preparedStatement.setInt(6, order.getPayWay());
					preparedStatement.setFloat(7, order.getOrderMoney());
					preparedStatement.setString(8, order.getOrderTime());
					preparedStatement.setString(9, currenttime);
					preparedStatement.setString(10, order.getPayTime());
					preparedStatement.setInt(11, order.getOrderStatus());
					
					
					//û��ʵ��ʱ������
					
					
					
				    //ִ�н�����ص�
					row = preparedStatement.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//�ͷ�����,����С���ȹ���
					try {
						DBHelper.closeConn(null, preparedStatement, connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return row;
			}

	@Override
	public int delete(int orderId) throws Exception {
		// TODO Auto-generated method stub
		//�޸����ݿ�
				String sql = "delete from order_inf where order_id=?";
				//�Ƿ��޸ĳɹ�
				int row = 0;
				try {
					
					connection = DBHelper.getConnection();
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, orderId);
					row = preparedStatement.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//�ر�����
					try {
						DBHelper.closeConn(null, preparedStatement,  connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//����ɾ���󷵻ص�ִ�н��
				return row;
			}
	@Override
	public int updata(Order order) throws Exception {
		// TODO Auto-generated method stub
		//�������ݿ������
		String sql_insert = "update  order_inf set order_id=?,goods_id=?,customer_id=?,shop_id=?,customer_name=?,customer_address=?,pay_way=?,order_money=?,order_time=?,send_time=?,pay_time=?,order_status=? where order_id=?";
		
		
		
		//��ǰʱ��
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		String currenttime = simpleDateFormat.format(date);
		
		
		//���޸�������
		int row =0;
		
		try {
			
			//ʵ�������Ӷ���
			connection = DBHelper.getConnection();
			//PreparedStatement ����,Ԥ�������sql_insert
			preparedStatement = connection.prepareStatement(sql_insert);
			
			//��ռλ����ֵ,���뵽���ݿ��е�����Ϊ���ݹ����Ķ���u
			preparedStatement.setInt(12, order.getOrderId());
			preparedStatement.setInt(1, order.getGoodsId());
			preparedStatement.setInt(2, order.getCustomerId());
			preparedStatement.setInt(3, order.getShopId());
			preparedStatement.setString(4, order.getCustomerName());
			preparedStatement.setString(5, order.getCustomerAddress());
			preparedStatement.setInt(6, order.getPayWay());
			preparedStatement.setFloat(7, order.getOrderMoney());
			preparedStatement.setString(8, order.getOrderTime());
			preparedStatement.setString(9, currenttime);
			preparedStatement.setString(10, order.getPayTime());
			preparedStatement.setInt(11, order.getOrderStatus());
			
			
			//û��ʵ��ʱ������
			
			
			
		    //ִ�н�����ص�
			row = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ�����,����С���ȹ���
			try {
				DBHelper.closeConn(null, preparedStatement, connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}


	@Override
	public ArrayList<Order> getAllRow() throws Exception {
		// TODO Auto-generated method stub
		ResultSet res = null;
		//��list���洢��ѯ��Ϣ
		ArrayList<Order> list = new ArrayList<Order>();
		
		try {
			
			//��ѯ���
			String sql = "select * from order_inf";
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			//�����
			res = preparedStatement.executeQuery();
			//ʹ��next()������һ��һ�еĶ�
			while(res.next()){
				//�� user�� �洢��ѯ������Բ�����ʽ���ص���Ҫ��ʾ�û������ڽ���
				Order order = new Order();
				
				order.setOrderId(res.getInt("order_id"));
				order.setGoodsId(res.getInt("goods_id"));
				order.setCustomerId(res.getInt("customer_id"));
				order.setShopId(res.getInt("shop_id"));
				order.setCustomerName(res.getString("customer_name"));
				order.setCustomerAddress(res.getString("customer_address"));
				order.setPayWay(res.getInt("pay_way"));
				order.setOrderMoney(res.getFloat("order_money"));
				order.setOrderTime(res.getString("order_time"));
				order.setSendTime(res.getString("send_time"));
				order.setPayTime(res.getString("pay_time"));
				order.setOrderStatus(res.getInt("order_status"));
				
				list.add(order);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}

	@Override
	public Order getOneRow(int orderId) throws Exception {
		// TODO Auto-generated method stub
		ResultSet res = null;
			
			//��ѯ���
			String sql = "select * from order_inf where order_id=?";
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			//�����
			res = preparedStatement.executeQuery();
			Order order =null;
			//ʹ��next()������һ��һ�еĶ�
			while(res.next()){
				//�� user�� �洢��ѯ������Բ�����ʽ���ص���Ҫ��ʾ�û������ڽ���
				order = new Order();
				
				order.setOrderId(res.getInt("order_id"));
				order.setGoodsId(res.getInt("goods_id"));
				order.setCustomerId(res.getInt("customer_id"));
				order.setShopId(res.getInt("shop_id"));
				order.setCustomerName(res.getString("customer_name"));
				order.setCustomerAddress(res.getString("customer_address"));
				order.setPayWay(res.getInt("pay_way"));
				order.setOrderMoney(res.getFloat("order_money"));
				order.setOrderTime(res.getString("order_time"));
				order.setSendTime(res.getString("send_time"));
				order.setPayTime(res.getString("pay_time"));
				order.setOrderStatus(res.getInt("order_status"));	
				
			}
			
		return order ;
		}

}
