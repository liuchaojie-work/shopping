package cn.hc.shopping.dao;

import java.util.List;

import cn.hc.shopping.entity.Product;

public interface ProductDao {
	//增加产品
	public void addProduct(Product product);
	//删除产品
	public void delProductById(int id);
	//查找所有产品的信息
	public List<Product> findAllProduct();
	//根据id查找产品
	public Product findProductById(int id);
	//根据id修改产品库存
	public void alterProductStockById(int id);
}
