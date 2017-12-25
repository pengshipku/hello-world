package com.niit.store.category.web.servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.niit.store.category.service.CategoryService;

public class CategoryServlet extends BaseServlet {

	private CategoryService service = new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MessagingException{
		request.setAttribute("categoryList", service.findAll());
		return "jsps/left.jsp";
	}
}
