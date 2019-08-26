package cn.ccnu.service.impl;

import java.util.List;

import cn.ccnu.dao.IProductInfoDao;
import cn.ccnu.dao.impl.ProductInfoDaoImpl;
import cn.ccnu.pojo.ProductInfo;
import cn.ccnu.service.IProductInfoService;

public class ProductInfoServiceImpl implements IProductInfoService{
	IProductInfoDao dao=new ProductInfoDaoImpl();
	
	
	public ProductInfoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(ProductInfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.add(info);
	}

	@Override
	public int delete(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(product_id);
	}

	@Override
	public int update(ProductInfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(info);
	}

	@Override
	public List<ProductInfo> showAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

	@Override
	public ProductInfo showOne(int product_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.showOne(product_id);
	}

}
