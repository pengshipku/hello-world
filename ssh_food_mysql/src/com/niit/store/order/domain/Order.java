package com.niit.store.order.domain;

import java.util.Date;
import java.util.List;

import com.niit.store.user.domain.User;

public class Order {
	private String oid;
	private Date ordertime;
	private double total;
	private int state;//����״̬ 1.δ���� 2δ���� 3δȷ�� 4���
	private User owner;
	private String address;
	private List<OrderItem> orderItemList;//��ǰ������������Ŀ
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total="
				+ total + ", state=" + state + ", owner=" + owner
				+ ", address=" + address + "]";
	}
	
}
