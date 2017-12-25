package com.niit.store.cart.domain;

import java.math.BigDecimal;

import com.niit.store.product.domain.product;

public class CartItem {

	private product book;
	private int count;
	public double getSubtotal(){
		BigDecimal price = new BigDecimal(book.getPrice()+"");
		BigDecimal _count = new BigDecimal(count+"");
		return price.multiply(_count).doubleValue();
	}
	public product getBook() {
		return book;
	}
	public void setBook(product book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}
	
}
