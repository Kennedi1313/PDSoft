package com.cafeview.service;

import com.cafeview.web.ReviewModel;

public interface IServiceReview {
	
	public void cadastrar(ReviewModel reviewModel) throws NegocioException;
	public void validar(ReviewModel reviewModel) throws NegocioException;

}
