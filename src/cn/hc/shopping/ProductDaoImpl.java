package cn.hc.shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
	
	//存储所有商品信息的集合对象,商品列表只有一份(Static)
	private static List<Product> productList = new ArrayList<Product>();
	
	//静态代码块 第一次加载类的时候执行，只执行一次，一般是对静态变量进行初始化操作
	static {
		productList.add(new Product(1, "钢笔", 10, "黑色", 500));
		productList.add(new Product(2, "本子", 1, "白色", 10000));
		productList.add(new Product(3, "笔芯", 0.5, "黑色", 50000));
	}
	//list语法不唯一，可通过编码判断来实现唯一（遍历list,查看商品编号是否存在）
	//增加产品
	public void addProduct(Product product) {
		//判断集合中是否已经有指定id的商品
		boolean flag=false;
		for(int i=0;i<productList.size();i++) {
			Product pro = productList.get(i);
			if(pro.getId()==product.getId()) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("该编号的商品已存在！");
		}else {
			productList.add(product);
			System.out.println("添加成功！");
		}
	}
	//查找所有产品的信息
	public List<Product> findAllProduct(){
		return productList;
	}
	//根据id查找产品,不能使用ProductList.get(id),因为这是按照索引查找
	public Product findProductById(int id) {
		//逐个比较，效率低
		for(int i=0;i<productList.size();i++) {
			Product product = productList.get(i);
			if(product.getId()==id) {
				return product;
			}
		}
		return null;
	}	
}
