package com.cafeview.service;

import com.cafeview.web.UserModel;

public interface IServiceUser {
	
	public void cadastrar(UserModel userModel) throws NegocioException;
	public void validar(UserModel userModel) throws NegocioException;

}
