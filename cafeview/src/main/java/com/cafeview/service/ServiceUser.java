package com.cafeview.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafeview.dao.UserDao;
import com.cafeview.dominio.User;
import com.cafeview.web.EmpresaModel;
import com.cafeview.web.UserModel;

@Service
public class ServiceUser implements IServiceUser {
	
	@Autowired
	private UserDao userDao;

	public ServiceUser() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void cadastrar(UserModel userModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		User user = new User();
		
		user.setNome(userModel.getNome());
		user.setEmail(userModel.getEmail());
		user.setSenha(userModel.getSenha());
		
		this.userDao.persist(user);
		
	}

	@Override
	public void validar(UserModel userModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		if (StringUtils.isEmpty(userModel.getNome())) {
			throw new NegocioException("O campo NOME deve ser informado.");
		}
		if (StringUtils.isEmpty(userModel.getSenha())) {
			throw new NegocioException("O campo SENHA deve ser informado.");
		}
		if (StringUtils.isEmpty(userModel.getEmail())) {
			throw new NegocioException("O campo EMAIL deve ser informado.");
		}
		
	}

}
