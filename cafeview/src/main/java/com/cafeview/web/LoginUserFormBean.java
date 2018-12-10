package com.cafeview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.service.IServiceCadastrarEmpresa;
import com.cafeview.service.NegocioException;

@Controller
@Scope("view")
public class LoginUserFormBean extends AbstractFormBean{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("serviceLoginUser")
	private IServiceCadastrarEmpresa serviceLoginUser;
	
	private EmpresaModel empresaModel;
	
	public LoginUserFormBean() {
		// Inicializando o objeto para ele não ser nulo
		 this.setEmpresaModel(new EmpresaModel());
	}

	public String cadastrar() {
		try {
			this.serviceLoginUser.validar(getEmpresaModel());
			addInfoMessage("Empresa cadastrada com successo!");
			this.setEmpresaModel(new EmpresaModel());
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
		return null;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}
	
}
