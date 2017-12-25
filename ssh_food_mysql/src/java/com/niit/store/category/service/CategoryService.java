package com.niit.store.category.service;

import java.util.List;

import com.niit.FarmProductsstore.product.dao.ProductDao;
import com.niit.store.category.dao.CategoryDao;
import com.niit.store.category.domain.Category;

public class CategoryService {

	private CategoryDao dao = new CategoryDao();
	private ProductDao bookDao = new ProductDao();
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void add(Category category) {
		// TODO Auto-generated method stub
		dao.add(category);
	}

	public void delete(String cid) throws CategoryException {
		//业务：查看该分类下是否还有蔬菜，有则抛异常
		int count = bookDao.getCountByCid(cid);
		if(count!=0) throw new CategoryException("不能删除,该分类下还有蔬菜");
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
