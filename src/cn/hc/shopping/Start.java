package cn.hc.shopping;
import java.util.List;
import java.util.Scanner;
public class Start {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("========XX商城========");
			System.out.println("\t1.添加商品");
			System.out.println("\t2.查看所有商品");
			System.out.println("\t3.查看指定编号商品");
			System.out.println("\t4.添加到购物车");
			System.out.println("\t5.显示购物车");
			System.out.println("\t6.退出");
			System.out.println("=======================");
			System.out.println("请选择：");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("添加商品");
				break;
			case 2:
				System.out.println("查看所有商品");
				showAllProduct();
				break;
			case 3:
				System.out.println("查看指定编号商品");
				break;
			case 4:
				System.out.println("添加到购物车");
				break;
			case 5:
				System.out.println("显示购物车");
				break;
			case 6:
				System.out.println("退出");
			default:
				System.out.println("输入错误");
				break;
			}
		}while(true);
	}
	/**
	 * 获取后台商品信息，再进行输出
	 */
	public static void showAllProduct() {
		//获取后台的商品信息
		ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.findAllProduct();
		//输出商品信息
		System.out.println("商品编号\t商品名称\t商品价格\t商品颜色\t商品库存");
		for(Product product:productList) {
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
			+"\t"+product.getColor()+"\t"+product.getStock());
		}
	}
}
