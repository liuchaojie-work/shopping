package cn.hc.shopping.dao.impl;

import java.util.LinkedHashMap;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.entity.CartItem;

public class CartItemDaoImpl implements CartItemDao{
	//���ﳵ
	private LinkedHashMap<Integer,CartItem> shoppingCart = new LinkedHashMap<Integer,CartItem>();
	/**
	 * �����Ŀ�����ﳵ
	 * @param item
	 */
	public void addCartItem(CartItem item) {
		
	}
	/**
	 * ��ȡ���еĹ��ﳵ��Ŀ/��ȡ���ﳵ����Ϣ
	 * @return
	 */
	public LinkedHashMap<Integer,CartItem> findAllCartItem(){
		shoppingCart.put(1, new CartItem(1, "�ֱ�", 10, "��ɫ", 2));
		shoppingCart.put(2, new CartItem(2, "����", 1, "��ɫ", 10));
		return null;
	}
	
}
