package cn.hc.shopping.dao.impl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.entity.CartItem;

public class CartItemIODaoImpl implements CartItemDao{
	private static Map<Integer,CartItem> shoppingCart = new LinkedHashMap<Integer,CartItem>();
	/**
	 * �����Ŀ�����ﳵ
	 * @param item
	 */
	private static File file=null;
	static {
//		shoppingCart.put(1, new CartItem(1, "�ֱ�", 10, "��ɫ", 2));
//		shoppingCart.put(2, new CartItem(2, "����", 1, "��ɫ", 10));
		file=new File("cart.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 */
	public void addCartItem(CartItem item) {
		//�жϱ�ŵ���Ŀ�Ƿ����
		CartItem item2=shoppingCart.get(item.getId());
		//�����ڣ����޸����������������Ŀ
		if(null==item2) {
			shoppingCart.put(item.getId(), item);
		}else {
			item2.setAmount(item.getAmount()+item2.getAmount());
		}
		System.out.println("��ӹ��ﳵ�ɹ���");
	}
	/**
	 * ��ȡ���еĹ��ﳵ��Ŀ/��ȡ���ﳵ����Ϣ
	 * 
	 * ��ѯ���ﳵ
	 * ��һ�η��ʵ�ʱ�������ﳵ�ǿգ�Ҫ�����ļ������Ƿ�����Ŀ
	 * ��һ�η��ʵ�ʱ�������ﳵ���ǿյģ��������ļ����ǵ�һ�ε�ʱ�� �������ļ�
	 * @return
	 */
	public Map<Integer,CartItem> findAllCartItem(){
		if(0==shoppingCart.size()) {//���ﳵΪ�գ������ļ�
			//���������������ļ�
			ObjectInputStream ois=null;
			try {
				InputStream is=new FileInputStream(file);
			    ois=new ObjectInputStream(is);
			    //ʹ����
			    while(true) {
			    	CartItem item= (CartItem)ois.readObject();
			    	//item���빺�ﳵ
			    	shoppingCart.put(item.getId(), item);
			    }
			} catch (EOFException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(null!=ois) {
						ois.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return shoppingCart;
	}
	@Override
	public void delCartItemById(int id) {
		// TODO Auto-generated method stub
		CartItem item = shoppingCart.get(id);
		if(null!=item) {
			shoppingCart.remove(id, item);
			System.out.println("����Ʒ�Ѵӹ��ﳵ��ɾ����");
		}else {
			System.out.println("ɾ��ʧ�ܣ����ù��ﳵ��û�д���Ʒ��");
		}
	}
	/**
	 * ʹ�ö��������湺�ﳵ
	 * 1.ֱ�ӱ���Map,һ������
	 * 2.ȡ��shoppingCart�е�ÿ��CartItem ,�ֱ𱣴棬�������
	 */
	@Override
	public void saveCarItem() {
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		try {
			OutputStream os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			Collection<CartItem> items=shoppingCart.values();
			for(CartItem item:items) {
				oos.writeObject(item);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(null!=oos) {
					oos.close();
				}		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
