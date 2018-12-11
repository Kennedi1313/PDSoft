package com.cafeview.service;

import java.util.List;

import com.cafeview.dominio.Empresa;

public interface IServiceListarEmpresas {
	public List<Empresa> getEmpresas();

	public Empresa getById(Integer id);
}
