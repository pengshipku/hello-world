package com.niit.store.user.service;

import com.niit.store.user.dao.UserDao;
import com.niit.store.user.domain.User;

public class UserService {
	private UserDao dao = new UserDao();
	public void regist(User form) throws UserException{
		User user = dao.findByUsername(form.getUsername());
		if(user!=null) throw new UserException("The username has been registerred,please change another !");
		user = dao.findByEmail(form.getEmail());
		if(user!=null) throw new UserException("The email has been registerred,please change another !");
		dao.add(form);
	}
	public void active(String code)throws UserException{
		User user = dao.findByCode(code);
		if(user==null)
			throw new UserException("the activation code is invalid!");
		if(user.isState())
			throw new UserException("User has been activated!");
		user.setState(true);
		dao.updateState(user.getUid(), user.isState());
	}

	public User login(User form)throws UserException{
		User user = dao.findByUsername(form.getUsername());
		if(user==null) throw new UserException("The username is not exist!");
		String password = user.getPassword();
		if(!password.equalsIgnoreCase(form.getPassword())){
			throw new UserException("Your password goes wrong!");
		}
		if(!user.isState()) throw new UserException(" The user has not been activated!");
		return user;
	}
}
