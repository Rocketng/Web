package cn.ccnu.service;

import java.util.List;

import cn.ccnu.dao.*;
import cn.ccnu.dao.impl.*;
import cn.ccnu.pojo.ProductInfo;

public interface IProductInfoService {
	
	int add(ProductInfo info) throws Exception;
	int delete(int product_id) throws Exception;
	int update(ProductInfo info) throws Exception;
	List<ProductInfo> showAll() throws Exception;
	ProductInfo showOne(int product_id) throws Exception;
}
