package com.niit.store.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	//���ﳵ�ǹ�����Ŀ�ļ���
	//�����������Ŀ
	public void add(CartItem item){		
		String bid = item.getBook().getBid();//��ȡ����Ŀ��bid
		if(map.containsKey(bid)){//�����Ŀ��Ӧ��bid����
			item.setCount(map.get(bid).getCount()+item.getCount());
			map.put(bid, item);
		}else{
			map.put(bid, item);
		}
	}
	public void clear(){//���
		map.clear();
	}
	public void remove(String bid){//�Ƴ�
		map.remove(bid);
	}
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	public double getTotal(){
		BigDecimal total = new BigDecimal("0");
		for(CartItem item:map.values()){	
			BigDecimal subtotal = new BigDecimal(""+item.getSubtotal());
			total = total.add(subtotal);//����bug!!
		}
		return total.doubleValue();
	}
}
