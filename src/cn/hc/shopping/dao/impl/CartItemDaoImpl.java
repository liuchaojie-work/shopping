package cn.hc.shopping.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.entity.CartItem;

public class CartItemDaoImpl implements CartItemDao{
	//购物车
	private static Map<Integer,CartItem> shoppingCart = new LinkedHashMap<Integer,CartItem>();
	/**
	 * 添加条目到购物车
	 * @param item
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
	 * @return
	 */
	public Map<Integer,CartItem> findAllCartItem(){
//		shoppingCart.put(1, new CartItem(1, "钢笔", 10, "黑色", 2));
//		shoppingCart.put(2, new CartItem(2, "本子", 1, "白色", 10));
		return shoppingCart;
	}
	
}
