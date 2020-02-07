package cn.hc.shopping.dao;

import java.util.LinkedHashMap;

import cn.hc.shopping.entity.CartItem;

public interface CartItemDao {
	/**
	 * �����Ŀ�����ﳵ
	 * @param item
	 */
	public void addCartItem(CartItem item);
	/**
	 * ��ȡ���еĹ��ﳵ��Ŀ/��ȡ���ﳵ����Ϣ
	 * @return
	 */
	public LinkedHashMap<Integer,CartItem> findAllCartItem();
	
}
