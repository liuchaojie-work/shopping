package cn.hc.shopping;
import java.util.List;
import java.util.Scanner;
public class Start {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("========XX�̳�========");
			System.out.println("\t1.�����Ʒ");
			System.out.println("\t2.�鿴������Ʒ");
			System.out.println("\t3.�鿴ָ�������Ʒ");
			System.out.println("\t4.��ӵ����ﳵ");
			System.out.println("\t5.��ʾ���ﳵ");
			System.out.println("\t6.�˳�");
			System.out.println("=======================");
			System.out.println("��ѡ��");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("�����Ʒ");
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
				System.out.println("��ӵ����ﳵ");
				break;
			case 5:
				System.out.println("��ʾ���ﳵ");
				break;
			case 6:
				System.out.println("�˳�");
			default:
				System.out.println("�������");
				break;
			}
		}while(true);
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
		ProductDao productDao = new ProductDaoImpl();
		productDao.addProduct(product);
		//������
		//System.out.println("��ӳɹ���");
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
		ProductDao productDao = new ProductDaoImpl();
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
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.findAllProduct();
		//�����Ʒ��Ϣ
		System.out.println("��Ʒ���\t��Ʒ����\t��Ʒ�۸�\t��Ʒ��ɫ\t��Ʒ���");
		for(Product product:productList) {
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
			+"\t"+product.getColor()+"\t"+product.getStock());
		}
	}
}
