package cn.hc.shopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hc.shopping.dao.ProductDao;
import cn.hc.shopping.entity.Product;

public class ProductDaoImpl implements ProductDao{
	
	//�洢������Ʒ��Ϣ�ļ��϶���,��Ʒ�б�ֻ��һ��(Static)
	private static List<Product> productList = new ArrayList<Product>();
	
	//��̬����� ��һ�μ������ʱ��ִ�У�ִֻ��һ�Σ�һ���ǶԾ�̬�������г�ʼ������
	static {
		productList.add(new Product(1, "�ֱ�", 10, "��ɫ", 500));
		productList.add(new Product(2, "����", 1, "��ɫ", 10000));
		productList.add(new Product(3, "��о", 0.5, "��ɫ", 50000));
	}
	//list�﷨��Ψһ����ͨ�������ж���ʵ��Ψһ������list,�鿴��Ʒ����Ƿ���ڣ�
	//���Ӳ�Ʒ
	public void addProduct(Product product) {
		//�жϼ������Ƿ��Ѿ���ָ��id����Ʒ
		boolean flag=false;
		for(int i=0;i<productList.size();i++) {
			Product pro = productList.get(i);
			if(pro.getId()==product.getId()) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("�ñ�ŵ���Ʒ�Ѵ��ڣ�");
		}else {
			productList.add(product);
			System.out.println("��ӳɹ���");
		}
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
	@Override
	public void delProductById(int id) {
		// TODO Auto-generated method stub
		Product product=findProductById(id);
		if(null!=product) {
			productList.remove(product);
			System.out.println("����Ʒɾ���ɹ���");
		}else {
			System.out.println("ɾ��ʧ�ܣ�������Ʒ�����ڣ�");
		}
	}
	@Override
	public void alterProductStockById(int id, int changeNum) {
		// TODO Auto-generated method stub
		Product product=findProductById(id);
		if(null!=product) {
			if((product.getStock()+changeNum)>=0) {
				product.setStock(product.getStock()+changeNum);
				System.out.println("����Ʒ����޸ĳɹ���");
			}else {
				System.out.println("�޸Ŀ��ʧ�ܣ���治�㣡");
			}	
		}else {
			System.out.println("�޸Ŀ��ʧ�ܣ�������Ʒ�����ڣ�");
		}
	}

}
