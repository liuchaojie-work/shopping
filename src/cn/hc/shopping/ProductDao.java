package cn.hc.shopping;

import java.util.List;

public interface ProductDao {
	//���Ӳ�Ʒ
	public void addProduct(Product product);
	//�������в�Ʒ����Ϣ
	public List<Product> findAllProduct();
	//����id���Ҳ�Ʒ
	public List<Product> findProductById(int id);
}
