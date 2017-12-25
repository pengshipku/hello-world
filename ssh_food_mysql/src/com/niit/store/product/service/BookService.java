package com.niit.store.product.service;



import java.util.List;

import com.niit.store.product.dao.BookDao;
import com.niit.store.product.domain.Book;

public class BookService {

	private BookDao dao = new BookDao();
	public List<Book> findAll(){
		return dao.findAll();
	}
	public List<Book> findByCategory(String cid) {
		// TODO Auto-generated method stub
		return dao.findByCategory(cid);
	}
	public Book load(String bid) {
		// TODO Auto-generated method stub
		return dao.findByBid(bid);
	}
	public void add(Book book) {
		// TODO Auto-generated method stub
		dao.add(book);
	}
	public void delete(String bid) {
		// TODO Auto-generated method stub
		dao.updateDel(bid);
	}
	public void edit(Book book){
		dao.update(book);
	}
}
