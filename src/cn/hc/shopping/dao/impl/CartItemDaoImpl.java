package cn.hc.shopping.dao.impl;

import java.util.LinkedHashMap;

import cn.hc.shopping.dao.CartItemDao;
import cn.hc.shopping.entity.CartItem;

public class CartItemDaoImpl implements CartItemDao{
	//购物车
	private LinkedHashMap<Integer,CartItem> shoppingCart = new LinkedHashMap<Integer,CartItem>();
	/**
	 * 添加条目到购物车
	 * @param item
	 */
	public void addCartItem(CartItem item) {
		
	}
	/**
	 * 获取所有的购物车条目/获取购物车的信息
	 * @return
	 */
	public LinkedHashMap<Integer,CartItem> findAllCartItem(){
		shoppingCart.put(1, new CartItem(1, "钢笔", 10, "黑色", 2));
		shoppingCart.put(2, new CartItem(2, "本子", 1, "白色", 10));
		return null;
	}
	
}
