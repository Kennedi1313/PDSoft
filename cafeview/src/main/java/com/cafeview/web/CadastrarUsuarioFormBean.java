package com.cafeview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.service.IServiceUser;
import com.cafeview.service.NegocioException;

@Controller
@Scope("view")
public class CadastrarUsuarioFormBean extends AbstractFormBean{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("serviceUser")
	private IServiceUser serviceUser;
	
	private UserModel userModel;
	
	public CadastrarUsuarioFormBean() {
		// Inicializando o objeto para ele não ser nulo
		 this.setUserModel(new UserModel());
	}

	public String cadastrar() {
		try {
			this.serviceUser.validar(getUserModel());
			this.serviceUser.cadastrar(getUserModel());
			addInfoMessage("Usuario cadastrado com successo!");
			this.setUserModel(new UserModel());
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
		return null;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}
