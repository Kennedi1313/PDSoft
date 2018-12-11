package com.cafeview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafeview.dao.EmpresaDao;
import com.cafeview.dominio.Empresa;
import com.cafeview.web.EmpresaModel;

import org.apache.commons.lang3.StringUtils;

@Service
public class ServiceCadastrarEmpresa implements IServiceCadastrarEmpresa {
	
	@Autowired
	private EmpresaDao empresaDao;

	public ServiceCadastrarEmpresa() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void cadastrar(EmpresaModel empresaModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		Empresa empresa = new Empresa();
		
		empresa.setNome(empresaModel.getNome());
		empresa.setTelefone(empresaModel.getTelefone());
		empresa.setEndereco(empresaModel.getEndereco());
		
		this.empresaDao.persist(empresa);
		
	}

	@Override
	public void validar(EmpresaModel empresaModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		if (StringUtils.isEmpty(empresaModel.getNome())) {
			throw new NegocioException("O campo NOME deve ser informado.");
		}
		
	}

}
