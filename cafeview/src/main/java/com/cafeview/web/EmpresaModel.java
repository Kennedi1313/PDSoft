package com.cafeview.web;

import java.io.Serializable;

public class EmpresaModel implements Serializable {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
