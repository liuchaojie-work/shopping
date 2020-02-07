package cn.hc.shopping;

import java.util.List;

public interface ProductDao {
	//增加产品
	public void addProduct(Product product);
	//查找所有产品的信息
	public List<Product> findAllProduct();
	//根据id查找产品
	public List<Product> findProductById(int id);
}
