package cn.hc.shopping.test;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.dao.ProductDao;
import cn.hc.shopping.dao.impl.CartItemDaoImpl;
import cn.hc.shopping.dao.impl.ProductDaoImpl;
import cn.hc.shopping.entity.CartItem;
import cn.hc.shopping.entity.Product;

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
			System.out.println("\t6.删除商品");
			System.out.println("\t7.修改商品库存");
			System.out.println("\t8.删除购物车中的商品");
			System.out.println("\t9.退出");
			System.out.println("=======================");
			System.out.println("请选择：");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("添加商品");
				addProduct();
				break;
			case 2:
				System.out.println("查看所有商品");
				showAllProduct();
				break;
			case 3:
				System.out.println("查看指定编号商品");
				showProductById();
				break;
			case 4:
				System.out.println("添加到购物车");
				addCartItem();
				break;
			case 5:
				System.out.println("显示购物车");
				showCartItem();
				break;
			case 6:
				System.out.println("删除商品");
				delProductById();
				break;
			case 7:
				System.out.println("修改商品库存");
				alterProductStockById();
				break;
			case 8:
				System.out.println("删除购物车中的商品");
				delCartItem();
				break;
			case 9:
				System.out.println("退出");
				System.exit(0);
			default:
				System.out.println("输入错误");
				break;
			}
		}while(true);
	}
	static CartItemDao cartItemDao = new CartItemDaoImpl();
	private static void delCartItem() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品的编号：");
		int id = sc.nextInt();
		//CartItemDao cartItemDao = new CartItemDaoImpl();
		cartItemDao.delCartItemById(id);
	}
	static ProductDao productDao = new ProductDaoImpl();
	private static void alterProductStockById() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品的编号：");
		int id = sc.nextInt();
		System.out.println("请输入库存的改变量(入库+num;出库-num)：");
		int num = sc.nextInt();
		//ProductDao productDao = new ProductDaoImpl();
		productDao.alterProductStockById(id, num);;
	}
	private static void delProductById() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品的编号：");
		int id = sc.nextInt();
		//ProductDao productDao = new ProductDaoImpl();
		productDao.delProductById(id);
	}
	//添加购物车条目
	private static void addCartItem() {
		// TODO Auto-generated method stub
		//输入要购买的商品的编号和数量
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入商品的编号：");
		int id = sc.nextInt();
		System.out.println("请输入要购买的数量：");
		int amount = sc.nextInt();
		//根据编号获取商品的其他信息
		//ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findProductById(id);
		if(null==product) {
			System.out.println("该编号商品不存在，添加购物车失败！");
		}else {
			//构建一个条目
			CartItem item = new CartItem(id, product.getName(),product.getPrice(),product.getColor(),amount);
			//调用后台添加条目
			//CartItemDao cartItemDao = new CartItemDaoImpl();
			cartItemDao.addCartItem(item);
		}		
	}

	//从后台获取购物车信息，并在前台输出
	private static void showCartItem() {
		// TODO Auto-generated method stub
		//从后台获取购物车信息
		//CartItemDao cartItemDao=new CartItemDaoImpl();
		Map<Integer,CartItem> shoppingCart = cartItemDao.findAllCartItem();
		//在前台输出
		Collection<CartItem> items = shoppingCart.values();
		System.out.println("商品编号\t商品名称\t商品颜色\t商品价格\t数量\t小计");
		//总计：1.给定初始值
		double total = 0;
		for(CartItem item:items) {
			System.out.println(item.getId()+"\t"+item.getName()+"\t"+item.getColor()
				+"\t"+item.getPrice()+"\t"+item.getAmount()+"\t"+item.getPrice()*item.getAmount());
			//总计：2.累计小计
			total+=item.getPrice()*item.getAmount();
		}
		//总计：3.输出
		System.out.println("\t\t\t\t总计：    "+total);
	}
	
	private static void addProduct() {
		// TODO Auto-generated method stub
		//在前台输入商品相关信息
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入商品编码：");
		int id = sc.nextInt();
		System.out.println("请输入商品名称：");
		String name = sc.next();
		System.out.println("请输入商品价格：");
		double price = sc.nextDouble();
		System.out.println("请输入商品颜色：");
		String color = sc.next();
		System.out.println("请输入商品库存：");
		int stock = sc.nextInt();
		//将商品信息写入后台
		Product product = new Product(id, name, price, color, stock);
		//ProductDao productDao = new ProductDaoImpl();
		productDao.addProduct(product);
		//输出结果
		//System.out.println("添加成功！");
	}
	/**
	 * 获取指定编号商品信息，再进行输出
	 */
	public static void showProductById() {
		//输入要查询的商品编号
		Scanner num = new Scanner(System.in);
		System.out.println("请输入要查询的商品的编号：");
		int id = num.nextInt();
		//获取该编号的商品信息
		//ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findProductById(id);
		//输出商品信息
		if(null==product) {
			System.out.println("该编号的商品不存在！");
		}else {
			System.out.println("商品编号\t商品名称\t商品价格\t商品颜色\t商品库存");
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
				+"\t"+product.getColor()+"\t"+product.getStock());
		}
		
	}
	
	/**
	 * 获取后台商品信息，再进行输出
	 */
	public static void showAllProduct() {
		//获取后台的商品信息
		//ProductDao productDao = new ProductDaoImpl();
		List<Product> productList = productDao.findAllProduct();
		//输出商品信息
		System.out.println("商品编号\t商品名称\t商品价格\t商品颜色\t商品库存");
		for(Product product:productList) {
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice()
			+"\t"+product.getColor()+"\t"+product.getStock());
		}
	}
}
