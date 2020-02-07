package cn.hc.shopping.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.entity.CartItem;

public class CartItemDaoImpl implements CartItemDao{
	//���ﳵ
	private static Map<Integer,CartItem> shoppingCart = new LinkedHashMap<Integer,CartItem>();
	/**
	 * �����Ŀ�����ﳵ
	 * @param item
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
	 * @return
	 */
	public Map<Integer,CartItem> findAllCartItem(){
//		shoppingCart.put(1, new CartItem(1, "�ֱ�", 10, "��ɫ", 2));
//		shoppingCart.put(2, new CartItem(2, "����", 1, "��ɫ", 10));
		return shoppingCart;
	}
	
}
