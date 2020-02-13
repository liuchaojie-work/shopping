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
 * 1.ObjectInputStream��ObjectOutputStream
 * 		�������ļ���������Ҫ���л�
 * 2.ʹ��BufferedReader��BufferedWriter(PrintWriter)
 * 		�ı��ļ� ������Ҫ���л� д���ļ��Ĳ��Ƕ����Ǹ�������ƴ�Ӷ��ɵ��ַ���
 * @author L1471
 *
 */
public class ProductIODaoImpl implements ProductDao{

	//����һ���ļ�
	private static File file;
	//ִֻ��һ�Σ�����ִ�У���ʼ������
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
		//��product���������ƴ�ӳ��ַ�������#�ָ�
		String strPro=product.getId()+"#"+product.getName()+"#"
				+product.getPrice()+"#"+product.getColor()+"#"+product.getStock();
		//ʹ�û����ַ���д�ַ������ļ���
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
