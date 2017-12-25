package com.niit.store.user.service;

import com.niit.store.user.dao.UserDao;
import com.niit.store.user.domain.User;

public class UserService {
	private UserDao dao = new UserDao();
	public void regist(User form) throws UserException{
		User user = dao.findByUsername(form.getUsername());
		if(user!=null) throw new UserException("���û����ѱ�ע��");
		user = dao.findByEmail(form.getEmail());
		if(user!=null) throw new UserException("�������ѱ�ע��");
		dao.add(form);
	}
	public void active(String code)throws UserException{
		User user = dao.findByCode(code);
		if(user==null)
			throw new UserException("��������Ч");
		if(user.isState())
			throw new UserException("�û��Ѽ���");
		user.setState(true);
		dao.updateState(user.getUid(), user.isState());
	}

	public User login(User form)throws UserException{
		User user = dao.findByUsername(form.getUsername());
		if(user==null) throw new UserException("�û���������");
		String password = user.getPassword();
		if(!password.equalsIgnoreCase(form.getPassword())){
			throw new UserException("�������");
		}
		if(!user.isState()) throw new UserException("���û���δ����");
		return user;
	}
}
