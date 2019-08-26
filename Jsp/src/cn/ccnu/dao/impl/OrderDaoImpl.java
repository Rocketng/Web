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
	//声明建立连接，由DriverManager.getCreateConnection（）方法创造
		private Connection connection = null;
		//由connection对象获得,预编译语句
		private PreparedStatement preparedStatement = null;
		
	@Override
	public int add(Order order) throws Exception {
		// TODO Auto-generated method stub
		//由preparedStatement执行语句后返回的结果集,插入语句没有返回集合，只是返回一个凭证，及修改了多少行
				//ResultSet resultSet = null;
				//插入数据库在语句
				String sql_insert = "insert into order_inf(order_id,goods_id,customer_id,shop_id,customer_name,customer_address,pay_way,order_money,order_time,send_time,pay_time,order_status) values(default,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				//当前时间
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
				String currenttime = simpleDateFormat.format(date);
				//发货时间
				
				
				//被修改在行数
				int row =0;
				
				try {
					
					//实例化连接对象
					connection = DBHelper.getConnection();
					//PreparedStatement 对象,预编译语句sql_insert
					preparedStatement = connection.prepareStatement(sql_insert);
					
					//给占位符赋值,插入到数据库中的新行为传递过来的对象u
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
					
					
					//没有实现时间设置
					
					
					
				    //执行结果返回到
					row = preparedStatement.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//释放连接,从最小的先关起
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
		//修改数据库
				String sql = "delete from order_inf where order_id=?";
				//是否修改成功
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
					//关闭连接
					try {
						DBHelper.closeConn(null, preparedStatement,  connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//返回删除后返回的执行结果
				return row;
			}
	@Override
	public int updata(Order order) throws Exception {
		// TODO Auto-generated method stub
		//插入数据库在语句
		String sql_insert = "update  order_inf set order_id=?,goods_id=?,customer_id=?,shop_id=?,customer_name=?,customer_address=?,pay_way=?,order_money=?,order_time=?,send_time=?,pay_time=?,order_status=? where order_id=?";
		
		
		
		//当前时间
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		String currenttime = simpleDateFormat.format(date);
		
		
		//被修改在行数
		int row =0;
		
		try {
			
			//实例化连接对象
			connection = DBHelper.getConnection();
			//PreparedStatement 对象,预编译语句sql_insert
			preparedStatement = connection.prepareStatement(sql_insert);
			
			//给占位符赋值,插入到数据库中的新行为传递过来的对象u
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
			
			
			//没有实现时间设置
			
			
			
		    //执行结果返回到
			row = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放连接,从最小的先关起
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
		//用list来存储查询信息
		ArrayList<Order> list = new ArrayList<Order>();
		
		try {
			
			//查询语句
			String sql = "select * from order_inf";
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			//结果集
			res = preparedStatement.executeQuery();
			//使用next()方法来一行一行的读
			while(res.next()){
				//用 user类 存储查询结果并以参数形式返回到需要显示用户数据在界面
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
			
			//查询语句
			String sql = "select * from order_inf where order_id=?";
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderId);
			//结果集
			res = preparedStatement.executeQuery();
			Order order =null;
			//使用next()方法来一行一行的读
			while(res.next()){
				//用 user类 存储查询结果并以参数形式返回到需要显示用户数据在界面
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
