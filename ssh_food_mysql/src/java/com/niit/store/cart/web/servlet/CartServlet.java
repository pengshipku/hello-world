package com.niit.store.cart.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.niit.store.product.domain.product;
import com.niit.store.product.service.ProductService;
import com.niit.store.cart.domain.Cart;
import com.niit.store.cart.domain.CartItem;

public class CartServlet extends BaseServlet {
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart)request.getSession().getAttribute("session_cart");
		CartItem item = new CartItem();
		product book = new ProductService().load(request.getParameter("bid"));
		int count = Integer.parseInt(request.getParameter("count"));
		item.setBook(book);
		item.setCount(count);
		cart.add(item);
		return "jsps/cart/list.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("session_cart");
		String bid = request.getParameter("bid");
		cart.remove(bid);
		return "jsps/cart/list.jsp";
	}
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("session_cart");
		cart.clear();
		return "jsps/cart/list.jsp";
	}

}
