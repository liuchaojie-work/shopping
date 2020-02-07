package cn.hc.shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
	
	//�洢������Ʒ��Ϣ�ļ��϶���,��Ʒ�б�ֻ��һ��(Static)
	private static List<Product> productList = new ArrayList<Product>();
	
	//��̬����� ��һ�μ������ʱ��ִ�У�ִֻ��һ�Σ�һ���ǶԾ�̬�������г�ʼ������
	static {
		productList.add(new Product(1, "�ֱ�", 10, "��ɫ", 500));
		productList.add(new Product(2, "����", 1, "��ɫ", 10000));
		productList.add(new Product(3, "��о", 0.5, "��ɫ", 50000));
	}
	//���Ӳ�Ʒ
	public void addProduct(Product product) {
		
	}
	//�������в�Ʒ����Ϣ
	public List<Product> findAllProduct(){
		return productList;
	}
	//����id���Ҳ�Ʒ,����ʹ��ProductList.get(id),��Ϊ���ǰ�����������
	public Product findProductById(int id) {
		//����Ƚϣ�Ч�ʵ�
		for(int i=0;i<productList.size();i++) {
			Product product = productList.get(i);
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}	
}
