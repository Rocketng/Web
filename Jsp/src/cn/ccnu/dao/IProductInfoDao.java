package cn.ccnu.dao;

import java.util.List;

import cn.ccnu.pojo.*;

public interface IProductInfoDao {
	
	int add(ProductInfo info) throws Exception;
	int delete(int product_id) throws Exception;
	int update(ProductInfo info) throws Exception;
	List<ProductInfo> showAll() throws Exception;
	ProductInfo showOne(int product_id) throws Exception;
}
