package com.cafeview.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafeview.dao.ReviewDao;
import com.cafeview.dominio.Review;
import com.cafeview.web.ReviewModel;

@Service
public class ServiceReview implements IServiceReview {
	
	@Autowired
	private ReviewDao reviewDao;

	public ServiceReview() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void cadastrar(ReviewModel reviewModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		Review review = new Review();
		
		review.setEstrela(reviewModel.getEstrela());
		review.setComentario(reviewModel.getComentario());
		review.setIdempresa(reviewModel.getIdempresa());
		review.setIduser(reviewModel.getIduser());
		this.reviewDao.persist(review);
		
	}

	@Override
	public void validar(ReviewModel reviewModel) throws NegocioException {
		// TODO Auto-generated method stub
		
		if (StringUtils.isEmpty(reviewModel.getEstrela())) {
			throw new NegocioException("O campo ESTRELA deve ser informado.");
		}
		if (StringUtils.isEmpty(reviewModel.getComentario())) {
			throw new NegocioException("O campo COMENTARIO deve ser informado.");
		}
		
	}

}
