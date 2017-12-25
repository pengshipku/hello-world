package com.niit.store.order.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;

import com.niit.store.order.dao.OrderDao;
import com.niit.store.order.domain.Order;

public class OrderService {
	private OrderDao dao = new OrderDao();
	public void add(Order order){
		try {
			JdbcUtils.beginTransaction();
			dao.addOrder(order);
			dao.addOrderItemList(order.getOrderItemList());
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);//回滚之后还要抛！查看什么导致的回滚
		}
		
	}
	public List<Order> myOrders(String uid) {
		// TODO Auto-generated method stub
		return dao.findByUid(uid);
	}
	public Order load(String oid) {
		// TODO Auto-generated method stub
		return dao.load(oid);
	}
	public void confirm(String oid) throws OrderException{
		int state = dao.getStateByOid(oid);
		if(state!=3) throw new OrderException("确认失败,您的操作涉嫌违规！");
		dao.updateStateByOid(oid, 4);
	}
}
