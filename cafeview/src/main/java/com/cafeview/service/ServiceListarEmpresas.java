package com.cafeview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeview.dao.EmpresaDao;
import com.cafeview.dominio.Empresa;

@Service
public class ServiceListarEmpresas implements IServiceListarEmpresas {

	@Autowired
	EmpresaDao empresaDao;
	
	@Transactional
	@Override
	public List<Empresa> getEmpresas() {
		// TODO Auto-generated method stub
		
		List<Empresa> empresas = empresaDao.findAll();
		
		return empresas;
	}
	
	@Transactional
	@Override
	public Empresa getById(Integer id) {
		Empresa empresa = empresaDao.getById(id);
		return empresa;
	}

}
