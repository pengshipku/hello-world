package com.niit.store.product.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.niit.store.product.domain.Book;
import com.niit.store.product.service.BookService;
import com.niit.store.category.domain.Category;
import com.niit.store.category.service.CategoryService;

public class AdminBookServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService();
	private BookService service = new BookService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("bookList", service.findAll());
		return "f:/adminjsps/admin/book/list.jsp";
	}

	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Book book = service.load(bid);
		request.setAttribute("book", book);
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/desc.jsp";
	}
	public String preAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/add.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		service.delete(bid);
		return this.findAll(request, response);
	}
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		book.setCategory(CommonUtils.toBean(request.getParameterMap(), Category.class));
		service.edit(book);
		return this.findAll(request, response);
	}
}
