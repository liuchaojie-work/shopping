package cn.hc.shopping.dao;

import java.util.Map;

import cn.hc.shopping.entity.CartItem;

public interface CartItemDao {
	/**
	 * 添加条目到购物车
	 * @param item
	 */
	public void addCartItem(CartItem item);
	/**
	 * 获取所有的购物车条目/获取购物车的信息
	 * @return
	 */
	public Map<Integer,CartItem> findAllCartItem();
	
}
