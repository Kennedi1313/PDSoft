package com.cafeview.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.dominio.Empresa;
import com.cafeview.service.IServiceCadastrarEmpresa;
import com.cafeview.service.IServiceListarEmpresas;
import com.cafeview.service.NegocioException;

@Controller
@Scope("view")
public class CadastrarEmpresaFormBean extends AbstractFormBean{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("serviceCadastrarEmpresa")
	private IServiceCadastrarEmpresa serviceCadastrarEmpresa;
	
	@Autowired
	@Qualifier("serviceListarEmpresas")
	private IServiceListarEmpresas serviceListarEmpresas;
	
	private Empresa empresa;
	private EmpresaModel empresaModel;
	private Integer idEmpresa;
	
	public CadastrarEmpresaFormBean() {
		// Inicializando o objeto para ele não ser nulo
		 this.setEmpresaModel(new EmpresaModel());
	}

	public String cadastrar() {
		try {
			this.serviceCadastrarEmpresa.validar(getEmpresaModel());
			this.serviceCadastrarEmpresa.cadastrar(getEmpresaModel());
			addInfoMessage("Empresa cadastrada com successo!");
			this.setEmpresaModel(new EmpresaModel());
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
		return null;
	}
	
	public void obterEmpresa() {
		this.empresa = serviceListarEmpresas.getById(idEmpresa);
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	
}
