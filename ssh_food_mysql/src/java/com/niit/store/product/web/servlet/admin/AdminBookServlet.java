package com.niit.store.product.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.niit.store.product.domain.product;
import com.niit.store.product.service.ProductService;
import com.niit.store.category.domain.Category;
import com.niit.store.category.service.CategoryService;

public class AdminBookServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryService();
	private ProductService service = new ProductService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("bookList", service.findAll());
		return "f:/adminjsps/admin/book/list.jsp";
	}

	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		product book = service.load(bid);
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
		product book = CommonUtils.toBean(request.getParameterMap(), product.class);
		book.setCategory(CommonUtils.toBean(request.getParameterMap(), Category.class));
		service.edit(book);
		return this.findAll(request, response);
	}
}
