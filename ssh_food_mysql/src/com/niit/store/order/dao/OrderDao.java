package com.niit.store.order.dao;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.niit.store.product.domain.Book;
import com.niit.store.order.domain.Order;
import com.niit.store.order.domain.OrderItem;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();
	public void addOrder(Order order){
		Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
		Object[] params = {order.getOid(),timestamp,order.getTotal(),order.getState(),order.getOwner().getUid(),order.getAddress()};
		String sql = "insert into orders values(?,?,?,?,?,?)";
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addOrderItemList(List<OrderItem> orderItemList){
		Object[][] params = new Object[orderItemList.size()][];
		for(int i=0;i<orderItemList.size();i++){
			OrderItem item = orderItemList.get(i);
			params[i]=new Object[]{item.getIid(),item.getCount(),
					item.getSubtotal(),item.getOrder().getOid(),item.getBook().getBid()};
		}
		String sql = "insert into orderitem values(?,?,?,?,?)";
		try {
			qr.batch(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Order> findByUid(String uid) {
		// TODO Auto-generated method stub
		String sql = "select * from orders where uid = ?";
		try {
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
			for(Order order:orderList){
				loadOrderItemList(order);
			}
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	private void loadOrderItemList(Order order) {
		String oid = order.getOid();
		String sql = "select * from book b,orderItem i where i.bid = b.bid and oid = ?";
		try {
			List<Map<String,Object>> mapList = qr.query(sql, new MapListHandler(), oid);
			List<OrderItem> orderItemList = toOrderItemList(mapList);
			order.setOrderItemList(orderItemList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Map<String,Object> map : mapList){
			orderItemList.add(toOrderItem(map));
		}
		return orderItemList;
	}
	private OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}
	public Order load(String oid) {
		String sql = "select * from orders where oid = ?";
		Order order = null;
		try {
			order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
			loadOrderItemList(order);	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return order;
	}
	public int getStateByOid(String oid){
		String sql = "select state from orders where oid = ?";
		try {
			Integer state = (Integer)qr.query(sql, new ScalarHandler(), oid);
			if(state==null)
				return -1;
			return state;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateStateByOid(String oid,int state){
		String sql = "update orders set state = ? where oid = ?";
		try {
			qr.update(sql, state,oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
