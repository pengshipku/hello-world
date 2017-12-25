package com.niit.store.category.service;

import java.util.List;

import com.niit.store.product.dao.BookDao;
import com.niit.store.category.dao.CategoryDao;
import com.niit.store.category.domain.Category;

public class CategoryService {

	private CategoryDao dao = new CategoryDao();
	private BookDao bookDao = new BookDao();
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void add(Category category) {
		// TODO Auto-generated method stub
		dao.add(category);
	}

	public void delete(String cid) throws CategoryException {
		//ҵ�񣺲鿴�÷������Ƿ���ͼ�飬�������쳣
		int count = bookDao.getCountByCid(cid);
		if(count!=0) throw new CategoryException("����ɾ���÷����»���ͼ��");
		dao.deleteByCid(cid);
	}

	public Category load(String cid) {
		// TODO Auto-generated method stub
		return dao.load(cid);
	}

	public void edit(Category category) {
		// TODO Auto-generated method stub
		dao.edit(category);
	}
}
