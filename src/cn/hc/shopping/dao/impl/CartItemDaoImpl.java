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
	static {
		shoppingCart.put(1, new CartItem(1, "�ֱ�", 10, "��ɫ", 2));
		shoppingCart.put(2, new CartItem(2, "����", 1, "��ɫ", 10));
	}
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
	
}
