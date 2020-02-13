package cn.hc.shopping.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
		
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterProductStockById(int id, int changeNum) {
		// TODO Auto-generated method stub
		
	}

}
