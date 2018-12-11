package com.cafeview.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeview.dao.EmpresaDao;
import com.cafeview.dao.ReviewDao;
import com.cafeview.dao.UserDao;
import com.cafeview.dominio.Empresa;
import com.cafeview.dominio.Review;
import com.cafeview.dominio.User;
import com.cafeview.web.ReviewModel;

@Service
public class ServiceListarReview implements IServiceListarReview {

	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EmpresaDao empresaDao;
	
	@Transactional
	@Override
	public List<ReviewModel> getReviews() {
		// TODO Auto-generated method stub
		
		List<ReviewModel> reviews = new ArrayList<>();
		for (Review review : reviewDao.findAll()) {
			ReviewModel rm = new ReviewModel();
			rm.setId(review.getId());
			rm.setComentario(review.getComentario());
			rm.setEstrela(review.getEstrela());
			rm.setIdempresa(review.getIdempresa());
			rm.setIduser(review.getIduser());
			User user = this.userDao.getById(review.getIduser());
			rm.setNomeUser(user.getNome());
			Empresa empresa = this.empresaDao.getById(review.getIdempresa());
			rm.setNomeEmpresa(empresa.getNome());
			reviews.add(rm);
		}
		
		return reviews;
	}
	
	@Transactional
	@Override
	public List<ReviewModel> getMyReviews(Integer idusuario){
		List<ReviewModel> myReviews = new ArrayList<>();
		for (Review review : reviewDao.getReviewByUser(idusuario)) {
			ReviewModel rm = new ReviewModel();
			rm.setId(review.getId());
			rm.setComentario(review.getComentario());
			rm.setEstrela(review.getEstrela());
			rm.setIdempresa(review.getIdempresa());
			rm.setIduser(review.getIduser());
			User user = this.userDao.getById(review.getIduser());
			rm.setNomeUser(user.getNome());
			Empresa empresa = this.empresaDao.getById(review.getIdempresa());
			rm.setNomeEmpresa(empresa.getNome());
			myReviews.add(rm);
		}
		
		return myReviews;
	}
	
	public List<ReviewModel> getReviewsByIdEmpresa(Integer idempresa){
		List<ReviewModel> reviews = new ArrayList<>();
		for (Review review : reviewDao.getReviewsByIdEmpresa(idempresa)) {
			ReviewModel rm = new ReviewModel();
			rm.setId(review.getId());
			rm.setComentario(review.getComentario());
			rm.setEstrela(review.getEstrela());
			rm.setIdempresa(review.getIdempresa());
			rm.setIduser(review.getIduser());
			User user = this.userDao.getById(review.getIduser());
			rm.setNomeUser(user.getNome());
			Empresa empresa = this.empresaDao.getById(review.getIdempresa());
			rm.setNomeEmpresa(empresa.getNome());
			reviews.add(rm);
		}
		
		return reviews;
	}
	
	@Transactional
	@Override
	public void deletar(Integer idreview) {
		reviewDao.delete(reviewDao.getById(idreview));
	}
	
}
