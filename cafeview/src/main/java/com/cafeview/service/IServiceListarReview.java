package com.cafeview.service;

import java.util.List;

import com.cafeview.web.ReviewModel;

public interface IServiceListarReview {
	public List<ReviewModel> getReviews();

	public List<ReviewModel> getMyReviews(Integer idusuario);

	public List<ReviewModel> getReviewsByIdEmpresa(Integer id);
	
	void deletar(Integer idreview);
}
