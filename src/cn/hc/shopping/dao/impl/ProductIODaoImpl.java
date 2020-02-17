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
		Product pro=findProductById(id);
		if(null==pro) {
			System.out.println("����Ʒ�����ڣ�ɾ��ʧ�ܣ�");
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
			System.out.println("ɾ���ɹ���");
		}
	}

	/**
	 * ��ȡ��Ʒ��Ϣ
	 * 1.ʹ�������������ļ���һ��һ�ж���ʹ��BufferedReader
	 * 2.����Ʒ��Ϣ����Ϊ����
	 * 3.ÿ��product���뼯��
	 */
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		//����һ�����ϣ�������е���Ʒ��ϢArrayList
		List<Product> productList=new ArrayList<Product>();
		//������������ȡ�ļ�������Ʒ��Ϣ���뼯��
		
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
		//������Ʒ�б�
		return productList;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		Product product=null;
		//������������ȡ�ļ�������Ʒ��Ϣ���뼯��
		
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
			System.out.println("����Ʒ�����ڣ�");
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
			System.out.println("�޸Ŀ��ɹ���");
		}
	}

}
