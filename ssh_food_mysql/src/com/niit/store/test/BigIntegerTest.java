package com.niit.store.test;

import java.math.BigDecimal;

import org.junit.Test;

public class BigIntegerTest {

	@Test
	public void fun1(){
		BigDecimal price = new BigDecimal("0");
		BigDecimal _count = new BigDecimal(2+"");
		price.add(_count);
		System.out.println(price);


	}
	@Test
	public void fun2(){
		BigDecimal price = new BigDecimal("0");
		BigDecimal _count = new BigDecimal("20");
		price.add(_count);
		System.out.println(price);
	}
}
