package com.cafeview.service;

import com.cafeview.dominio.User;

public interface IServiceLogin {
	public User Login(String login, String senha);
}
