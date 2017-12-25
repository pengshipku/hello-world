package com.niit.store.product.web.servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.niit.store.product.service.ProductService;

public class BookServlet extends BaseServlet {

	private ProductService service = new ProductService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MessagingException{
		request.setAttribute("bookList", service.findAll());
		return "jsps/book/list.jsp";
	}
	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MessagingException{
		request.setAttribute("bookList", service.findByCategory(request.getParameter("cid")));
		return "jsps/book/list.jsp";
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MessagingException{
		request.setAttribute("book", service.load(request.getParameter("bid")));
		return "jsps/book/desc.jsp";
	}
}
