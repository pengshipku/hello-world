package com.niit.store.product.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.niit.store.product.domain.Book;
import com.niit.store.category.domain.Category;

public class BookDao {

	private QueryRunner qr = new TxQueryRunner();
	public List<Book> findAll(){
		String sql = "select * from book where del=false";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Book> findByCategory(String cid) {
		String sql = "select * from book where cid = ? and del=false";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class),cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Book findByBid(String bid) {
		String sql = "select * from book where bid = ?";
		try {
			Map<String,Object> map = qr.query(sql, new MapHandler(),bid);
			Book book = CommonUtils.toBean(map, Book.class);
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int getCountByCid(String cid) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from book where cid = ?";
		try {
			Number num = (Number)qr.query(sql, new ScalarHandler(), cid);
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	public void add(Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into book values(?,?,?,?,?,?,?)";
		Object[] params = {book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCategory().getCid(),false};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateDel(String bid) {
		// TODO Auto-generated method stub
		String sql = "update book set del = true where bid = ?";
		try {
			qr.update(sql, bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(Book book){
		String sql = "update book set bname=?,price=?,author=?,cid=? where bid=?";
		Object[] params = {book.getBname(),book.getPrice(),book.getAuthor(),book.getCategory().getCid(),book.getBid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

}
