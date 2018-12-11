package com.cafeview.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeview.dao.UserDao;
import com.cafeview.dominio.User;

@Service
public class ServiceLogin implements IServiceLogin{

	@Autowired
	UserDao userDao;
	
	@Transactional
	@Override
	public User Login(String login, String senha) {
		// TODO Auto-generated method stub
		User user = this.userDao.getUsuario(login, senha);
		return user;
	}

}
