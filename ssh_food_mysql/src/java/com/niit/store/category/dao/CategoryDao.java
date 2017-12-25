package com.niit.store.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.niit.store.category.domain.Category;

public class CategoryDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from category";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Category category) {
		String sql = "insert into category values(?,?)";
		try {
			qr.update(sql, category.getCid(),category.getCname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteByCid(String cid) {
		String sql = "delete from category where cid = ?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Category load(String cid) {
		// TODO Auto-generated method stub
		String sql = "select * from category where cid = ?";
		try {
			return qr.query(sql, new BeanHandler<Category>(Category.class), cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void edit(Category category) {
		// TODO Auto-generated method stub
		String sql = "update category set cname = ? where cid = ?";
		try {
			qr.update(sql, category.getCname(),category.getCid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
