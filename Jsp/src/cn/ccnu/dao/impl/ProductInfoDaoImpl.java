package cn.ccnu.dao.impl;

import cn.ccnu.dao.*;
import cn.ccnu.pojo.*;
import cn.ccnu.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductInfoDaoImpl implements IProductInfoDao{

	private Connection conn=null;
	private PreparedStatement ps=null;
	private String sql=null;
	
	
	
	public ProductInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(ProductInfo info) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		sql="insert into product_info(product_id,product_name,product_img,price,descript) values(default,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, info.getProduct_name());
		ps.setString(2, info.getProduct_img());
		ps.setFloat(3, info.getPrice());
		ps.setString(4, info.getDescript());
		
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int delete(int product_id) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		sql="delete from product_info where product_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, product_id);
		
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public int update(ProductInfo info) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		sql="update product_info set product_name=?,product_img=?,price=?,descript=? where product_id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, info.getProduct_name());
		ps.setString(2, info.getProduct_img());
		ps.setFloat(3, info.getPrice());
		ps.setString(4, info.getDescript());
		ps.setInt(5, info.getProduct_id());
		
		int row=ps.executeUpdate();
		DBHelper.closeConn(null, ps, conn);
		
		return row;
	}

	@Override
	public List<ProductInfo> showAll() throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		sql="select * from product_info";
		ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		List<ProductInfo> list=new ArrayList<ProductInfo>();
		while(rs.next()){
			ProductInfo pi=new ProductInfo();
			pi.setProduct_id(rs.getInt("product_id"));
			pi.setProduct_name(rs.getString("product_name"));
			pi.setProduct_img(rs.getString("product_img"));
			pi.setPrice(rs.getFloat("price"));
			pi.setDescript(rs.getString("descript"));
			list.add(pi);
		}
		DBHelper.closeConn(rs, ps, conn);
		
		return list;
	}

	@Override
	public ProductInfo showOne(int product_id) throws Exception {
		// TODO Auto-generated method stub
		conn=DBHelper.getConnection();
		sql="select * from product_info where product_id=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, product_id);
		ProductInfo pi=new ProductInfo();
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			pi.setProduct_id(rs.getInt("product_id"));
			pi.setProduct_name(rs.getString("product_name"));
			pi.setProduct_img(rs.getString("product_img"));
			pi.setPrice(rs.getFloat("price"));
			pi.setDescript(rs.getString("descript"));
		}
		
		DBHelper.closeConn(rs, ps, conn);
		
		return pi;
	}
	
}
