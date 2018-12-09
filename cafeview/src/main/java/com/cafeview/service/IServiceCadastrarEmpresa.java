package com.cafeview.service;

import com.cafeview.web.EmpresaModel;
import com.cafeview.web.UserModel;

public interface IServiceCadastrarEmpresa {
	
	public void cadastrar(EmpresaModel empresaModel) throws NegocioException;
	public void validar(EmpresaModel empresaModel) throws NegocioException;

}
