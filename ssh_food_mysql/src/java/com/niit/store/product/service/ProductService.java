package com.niit.store.product.service;



import java.util.List;

import com.niit.FarmProductsstore.product.dao.ProductDao;
import com.niit.store.product.domain.product;

public class ProductService {

	private ProductDao dao = new ProductDao();
	public List<product> findAll(){
		return dao.findAll();
	}
	public List<product> findByCategory(String cid) {
		// TODO Auto-generated method stub
		return dao.findByCategory(cid);
	}
	public product load(String bid) {
		// TODO Auto-generated method stub
		return dao.findByBid(bid);
	}
	public void add(product book) {
		// TODO Auto-generated method stub
		dao.add(book);
	}
	public void delete(String bid) {
		// TODO Auto-generated method stub
		dao.updateDel(bid);
	}
	public void edit(product book){
		dao.update(book);
	}
}
