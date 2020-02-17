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
	 * 添加条目到购物车
	 * @param item
	 */
	private static File file=null;
	static {
//		shoppingCart.put(1, new CartItem(1, "钢笔", 10, "黑色", 2));
//		shoppingCart.put(2, new CartItem(2, "本子", 1, "白色", 10));
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
		//判断编号的条目是否存在
		CartItem item2=shoppingCart.get(item.getId());
		//若存在，则修改数量；否则，添加条目
		if(null==item2) {
			shoppingCart.put(item.getId(), item);
		}else {
			item2.setAmount(item.getAmount()+item2.getAmount());
		}
		System.out.println("添加购物车成功！");
	}
	/**
	 * 获取所有的购物车条目/获取购物车的信息
	 * 
	 * 查询购物车
	 * 第一次访问的时候，若购物车是空，要访问文件，看是否有条目
	 * 第一次访问的时候，若购物车不是空的，不访问文件，非第一次的时候都 不访问文件
	 * @return
	 */
	public Map<Integer,CartItem> findAllCartItem(){
		if(0==shoppingCart.size()) {//购物车为空，访问文件
			//创建对象流，读文件
			ObjectInputStream ois=null;
			try {
				InputStream is=new FileInputStream(file);
			    ois=new ObjectInputStream(is);
			    //使用流
			    while(true) {
			    	CartItem item= (CartItem)ois.readObject();
			    	//item放入购物车
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
			System.out.println("该商品已从购物车中删除！");
		}else {
			System.out.println("删除失败！，该购物车中没有此商品！");
		}
	}
	/**
	 * 使用对象流保存购物车
	 * 1.直接保存Map,一个对象
	 * 2.取出shoppingCart中的每个CartItem ,分别保存，多个对象
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
