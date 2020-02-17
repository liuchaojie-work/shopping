package cn.hc.shopping.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import cn.hc.shopping.dao.ProductDao;
import cn.hc.shopping.entity.Product;
/**
 * 1.ObjectInputStream和ObjectOutputStream
 * 		二进制文件，对象需要序列化
 * 2.使用BufferedReader和BufferedWriter(PrintWriter)
 * 		文本文件 对象不需要序列化 写入文件的不是对象，是各个属性拼接而成的字符串
 * @author L1471
 *
 */
public class ProductIODaoImpl implements ProductDao{

	//定义一个文件
	private static File file;
	//只执行一次，最早执行，初始化操作
	static {
		file=new File("product.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		//将product对象的属性拼接成字符串，以#分隔
		String strPro=product.getId()+"#"+product.getName()+"#"
				+product.getPrice()+"#"+product.getColor()+"#"+product.getStock();
		//使用缓冲字符流写字符串到文件中
		BufferedWriter bw = null;
		try {
			Writer w=new FileWriter(file,true);
			bw=new BufferedWriter(w);
			bw.write(strPro);
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(null!=bw) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delProductById(int id) {
		// TODO Auto-generated method stub
		Product pro=findProductById(id);
		if(null==pro) {
			System.out.println("该商品不存在！删除失败！");
		}
		else {
			List<Product> productList=findAllProduct();
			productList.remove(pro);
			if(file.exists()) {
				file.delete();
				file=new File("product.txt");
			}
			for(Product p:productList) {
				addProduct(p);
			}
			System.out.println("删除成功！");
		}
	}

	/**
	 * 获取商品信息
	 * 1.使用输入流来读文件，一行一行读，使用BufferedReader
	 * 2.将商品信息保存为对象
	 * 3.每个product放入集合
	 */
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		//创建一个集合，存放所有的商品信息ArrayList
		List<Product> productList=new ArrayList<Product>();
		//创建输入流读取文件并将商品信息放入集合
		
		BufferedReader br=null;
		try {
			Reader r = new FileReader(file);
			br=new BufferedReader(r);
			String str = br.readLine();
			while(null!=str) {
				String arr[] = str.split("#");
				Product product = new Product();
				product.setId(Integer.parseInt(arr[0]));
				product.setName(arr[1]);
				product.setPrice(Double.parseDouble(arr[2]));
				product.setColor(arr[3]);
				product.setStock(Integer.parseInt(arr[4]));
				productList.add(product);
				str=br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(null!=br) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//返回商品列表
		return productList;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		Product product=null;
		//创建输入流读取文件并将商品信息放入集合
		
		BufferedReader br=null;
		try {
			Reader r = new FileReader(file);
			br=new BufferedReader(r);
			String str = br.readLine();
			while(null!=str) {
				String arr[] = str.split("#");
				if(id==Integer.parseInt(arr[0])) {
					product = new Product();
					product.setId(Integer.parseInt(arr[0]));
					product.setName(arr[1]);
					product.setPrice(Double.parseDouble(arr[2]));
					product.setColor(arr[3]);
					product.setStock(Integer.parseInt(arr[4]));
					break;
				}
				str=br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(null!=br) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
		return product;
	}

	@Override
	public void alterProductStockById(int id, int changeNum) {
		// TODO Auto-generated method stub
		Product pro=findProductById(id);
		if(null==pro) {
			System.out.println("该商品不存在！");
		}else {
			List<Product> proList=findAllProduct();
			if(file.exists()) {
				file.delete();
				file=new File("product.txt");
			}
			for(Product p:proList) {
				if(p.getId()==id) {
					p.setStock(pro.getStock()+changeNum);
				}
				addProduct(p);
			}
			System.out.println("修改库存成功！");
		}
	}

}
