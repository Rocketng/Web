package cn.ccnu.dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;

import cn.ccnu.dao.ICartGoodsDao;
import cn.ccnu.pojo.CartGoodsInfo;
import cn.ccnu.util.DBHelper;

public class CartGoodsDaoImpl implements ICartGoodsDao {
	//都需要连接数据库所以声明一个连接
	private Connection connection = null;
	private PreparedStatement preparedStatement =null;
	@Override
	public int add(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		connection = DBHelper.getConnection();
		String sql = "insert into cart_goods_inf(goods_id,cart_id,goods_account,price) values(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, cGInfo.getGoodsId());
		preparedStatement.setInt(2, cGInfo.getCartId());
		preparedStatement.setInt(3, cGInfo.getGoodsAccount());
		preparedStatement.setFloat(4, cGInfo.getPrice());
		int row = preparedStatement.executeUpdate();
		DBHelper.closeConn(null, preparedStatement, connection);
		return row;
	}

	@Override
	public int delete(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		//当货物id==-1时删除购物车所有物品
		connection  = DBHelper.getConnection();
		String sql = "delete from cart_goods_inf where cart_id=? and goods_id=?";
		String sql_all = "delete from cart_goods_inf where  cart_id=?";
		int row =0;
		System.out.print("&&&"+cGInfo.getGoodsId()+"###");
		if(cGInfo.getGoodsId()!=-1){
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, cGInfo.getCartId());
				preparedStatement.setInt(2, cGInfo.getGoodsId());
				row = preparedStatement.executeUpdate();
				}else{
					preparedStatement = connection.prepareStatement(sql_all);
					preparedStatement.setInt(1, cGInfo.getCartId());
					row = preparedStatement.executeUpdate();
		}
		DBHelper.closeConn(null, preparedStatement, connection);
		return row;
	}

	@Override
	public int update(CartGoodsInfo cGInfo) throws Exception {
		// TODO Auto-generated method stub
		connection = DBHelper.getConnection();
		String sql  = "update  cart_goods_inf set goods_account=?,price=? where goods_id=?and cart_id=? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, cGInfo.getGoodsId());
		preparedStatement.setInt(2, cGInfo.getCartId());
		preparedStatement.setInt(3, cGInfo.getGoodsAccount());
		preparedStatement.setFloat(4, cGInfo.getPrice());
		int row = preparedStatement.executeUpdate();
		DBHelper.closeConn(null, preparedStatement, connection);
		return row;
	}

	@Override
	public CartGoodsInfo getOne(int cartId, int goodsId) throws Exception {
		// TODO Auto-generated method stub
		connection = DBHelper.getConnection();
		ResultSet resultSet = null;
		String sql =  "select * from cart_goods_inf where goods_id=? and cart_id=?";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, goodsId);
		preparedStatement.setInt(2, cartId);

		resultSet = preparedStatement.executeQuery();
		CartGoodsInfo cartGoodsInfo = null;
		while(resultSet.next()){
			cartGoodsInfo = new CartGoodsInfo(resultSet.getInt("goods_id"),resultSet.getInt("cart_id"),resultSet.getInt("goods_account"),resultSet.getFloat("price"));

		}
		DBHelper.closeConn(resultSet, preparedStatement, connection);
		return cartGoodsInfo;
	}

	@Override
	public ArrayList<CartGoodsInfo> getAll() throws Exception {
		// TODO Auto-generated method stub
		connection = DBHelper.getConnection();
		ResultSet resultSet = null;
		String sql = "select * from cart_goods_inf";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		ArrayList<CartGoodsInfo> list = new ArrayList<>();
		CartGoodsInfo cartGoodsInfo = null;
		
		while(resultSet.next()){
			cartGoodsInfo = new CartGoodsInfo(resultSet.getInt("goods_id"),resultSet.getInt("cart_id"),resultSet.getInt("goods_account"),resultSet.getFloat("price"));
			list.add(cartGoodsInfo);
			
		}
		DBHelper.closeConn(resultSet, preparedStatement, connection);
		return list;
	}

}
