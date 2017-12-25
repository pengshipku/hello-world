package com.niit.store.category.web.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.niit.store.category.domain.Category;
import com.niit.store.category.service.CategoryException;
import com.niit.store.category.service.CategoryService;

public class AdminCategoryServlet extends BaseServlet {

	private CategoryService service = new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categoryList", service.findAll());
		return "/adminjsps/admin/category/list.jsp";
	}
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		category.setCid(CommonUtils.uuid());
		service.add(category);
		return this.findAll(request, response);
	}
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		try {
			service.delete(cid);
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "/adminjsps/msg.jsp";
		}
		return this.findAll(request, response);
	}
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = service.load(request.getParameter("cid"));
		request.setAttribute("category", category);
		return "f:/adminjsps/admin/category/mod.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		service.edit(category);
		return this.findAll(request, response);
	}
}
