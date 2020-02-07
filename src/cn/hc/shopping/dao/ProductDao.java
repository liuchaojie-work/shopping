package cn.hc.shopping.dao;

import java.util.List;

import cn.hc.shopping.entity.Product;

public interface ProductDao {
	//���Ӳ�Ʒ
	public void addProduct(Product product);
	//ɾ����Ʒ
	public void delProductById(int id);
	//�������в�Ʒ����Ϣ
	public List<Product> findAllProduct();
	//����id���Ҳ�Ʒ
	public Product findProductById(int id);
	//����id�޸Ĳ�Ʒ���
	public void alterProductStockById(int id);
}
