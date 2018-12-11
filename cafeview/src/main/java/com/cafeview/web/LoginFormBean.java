package com.cafeview.web;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.dominio.User;
import com.cafeview.service.IServiceLogin;

@Controller
@Scope("view")
public class LoginFormBean extends AbstractFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IServiceLogin login;
	private UserModel userModel = new UserModel();

	public String envia() {

		User usuario = login.Login(userModel.getEmail(), userModel.getSenha());
		if (usuario == null) {
			addErrorMessage("Login e senha invalidos.");
			return null;
		} else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idusuario", usuario.getId());
			return "/indexLogado"; 
		}
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}