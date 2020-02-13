package cn.hc.shopping.test;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.dao.ProductDao;
import cn.hc.shopping.dao.impl.CartItemIODaoimpl;
import cn.hc.shopping.dao.impl.ProductIODaoImpl;
import cn.hc.shopping.entity.CartItem;
import cn.hc.shopping.entity.Product;

public class StartIO {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("========XX�̳�========");
			System.out.println("\t1.������Ʒ");
			System.out.println("\t2.�鿴������Ʒ");
			System.out.println("\t3.�鿴ָ�������Ʒ");
			System.out.println("\t4.���ӵ����ﳵ");
			System.out.println("\t5.��ʾ���ﳵ");
			System.out.println("\t6.ɾ����Ʒ");
			System.out.println("\t7.�޸���Ʒ���");
			System.out.println("\t8.ɾ�����ﳵ�е���Ʒ");
			System.out.println("\t9.�˳�");
			System.out.println("=======================");
			System.out.println("��ѡ��");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("������Ʒ");
				addProduct();
				break;
			case 2:
				System.out.println("�鿴������Ʒ");
				showAllProduct();
				break;
			case 3:
				System.out.println("�鿴ָ�������Ʒ");
				showProductById();
				break;
			case 4:
				System.out.println("���ӵ����ﳵ");
				addCartItem();
				break;
			case 5:
				System.out.println("��ʾ���ﳵ");
				showCartItem();
				break;
			case 6:
				System.out.println("ɾ����Ʒ");
				delProductById();
				break;
			case 7:
				System.out.println("�޸���Ʒ���");
				alterProductStockById();
				break;
			case 8:
				System.out.println("ɾ�����ﳵ�е���Ʒ");
				delCartItem();
				break;
			case 9:
				System.out.println("�˳�");
				System.exit(0);
			default:
				System.out.println("�������");
				break;
			}
		}while(true);
	}
	static CartItemDao cartItemDao = new CartItemIODaoimpl();
	private static void delCartItem() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ�ı�ţ�");
		int id = sc.nextInt();
		//CartItemDao cartItemDao = new CartItemDaoImpl();
		cartItemDao.delCartItemById(id);
	}
	static ProductDao productDao = new ProductIODaoImpl();
	private static void alterProductStockById() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ�ı�ţ�");
		int id = sc.nextInt();
		System.out.println("��������ĸı���(���+num;����-num)��");
		int num = sc.nextInt();
		//ProductDao productDao = new ProductDaoImpl();
		productDao.alterProductStockById(id, num);;
	}
	private static void delProductById() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ�ı�ţ�");
		int id = sc.nextInt();
		//ProductDao productDao = new ProductDaoImpl();
		productDao.delProductById(id);
	}
	//���ӹ��ﳵ��Ŀ
	private static void addCartItem() {
		// TODO Auto-generated method stub
		//����Ҫ�������Ʒ�ı�ź�����
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ʒ�ı�ţ�");
		int id = sc.nextInt();
		System.out.println("������Ҫ�����������");
		int amount = sc.nextInt();
		//���ݱ�Ż�ȡ��Ʒ��������Ϣ
		//ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findProductById(id);
		if(null==product) {
			System.out.println("�ñ����Ʒ�����ڣ����ӹ��ﳵʧ�ܣ�");
		}else {
			//����һ����Ŀ
			CartItem item = new CartItem(id, product.getName(),product.getPrice(),product.getColor(),amount);
			//���ú�̨������Ŀ
			//CartItemDao cartItemDao = new CartItemDaoImpl();
			cartItemDao.addCartItem(item);
		}		
	}

	//�Ӻ�̨��ȡ���ﳵ��Ϣ������ǰ̨���
	private static void showCartItem() {
		// TODO Auto-generated method stub
		//�Ӻ�̨��ȡ���ﳵ��Ϣ
		//CartItemDao cartItemDao=new CartItemDaoImpl();
		Map<Integer,CartItem> shoppingCart = cartItemDao.findAllCartItem();
		//��ǰ̨���
		Collection<CartItem> items = shoppingCart.values();
		System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ��ɫ\t��Ʒ�۸�\t����\tС��");
		//�ܼƣ�1.������ʼֵ
		double total = 0;
		for(CartItem item:items) {
			System.out.println(item.getId()+"\t"+item.getName()+"\t"+item.getColor()
				+"\t"+item.getPrice()+"\t"+item.getAmount()+"\t"+item.getPrice()*item.getAmount());
			//�ܼƣ�2.�ۼ�С��
			total+=item.getPrice()*item.getAmount();
		}
		//�ܼƣ�3.���
		System.out.println("\t\t\t\t�ܼƣ�    "+total);
	}
	
	private static void addProduct() {
		// TODO Auto-generated method stub
		//��ǰ̨������Ʒ�����Ϣ
		Scanner sc=new Scanner(System.in);
		System.out.println("��������Ʒ���룺");
		int id = sc.nextInt();
		System.out.println("��������Ʒ���ƣ�");
		String name = sc.next();
		System.out.println("��������Ʒ�۸�");
		double price = sc.nextDouble();
		System.out.println("��������Ʒ��ɫ��");
		String color = sc.next();
		System.out.println("��������Ʒ��棺");
		int stock = sc.nextInt();
		//����Ʒ��Ϣд���̨
		Product product = new Product(id, name, price, color, stock);
		//ProductDao productDao = new ProductDaoImpl();
		productDao.addProduct(product);
		//������
		//System.out.println("���ӳɹ���");
	}
	/**
	 * ��ȡָ�������Ʒ��Ϣ���ٽ������
	 */
	public static void showProductById() {
		//����Ҫ��ѯ����Ʒ���
		Scanner num = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ����Ʒ�ı�ţ�");
		int id = num.nextInt();
		//��ȡ�ñ�ŵ���Ʒ��Ϣ
		//ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findProductById(id);
		//�����Ʒ��Ϣ
		if(null==product) {
			System.out.println("�ñ�ŵ���Ʒ�����ڣ�");
		}else {
			System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ�۸�\t��Ʒ��ɫ\t��Ʒ���");
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
				+"\t"+product.getColor()+"\t"+product.getStock());
		}
		
	}
	
	/**
	 * ��ȡ��̨��Ʒ��Ϣ���ٽ������
	 */
	public static void showAllProduct() {
		//��ȡ��̨����Ʒ��Ϣ
		//ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.findAllProduct();
		//�����Ʒ��Ϣ
		System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ�۸�\t��Ʒ��ɫ\t��Ʒ���");
		for(Product product:productList) {
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
			+"\t"+product.getColor()+"\t"+product.getStock());
		}
	}
}