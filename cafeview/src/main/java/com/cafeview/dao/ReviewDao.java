package com.cafeview.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.cafeview.dominio.Review;

@Repository
public class ReviewDao extends AbstractDao<Long, Review> {
	public List<Review> getReviewByUser(Integer idusuario) {

		try {
			List<Review> reviews = getSession()
					.createQuery("SELECT r from Review r where r.iduser = :idusuario")
					.setParameter("idusuario", idusuario).list();

			return reviews;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Review> getReviewsByIdEmpresa(Integer idempresa){
		
		try {
			List<Review> reviews = getSession()
					.createQuery("SELECT r from Review r where r.idempresa = :id")
					.setParameter("id", idempresa).list();

			return reviews;
		} catch (NoResultException e) {
			return null;
		}
		
	}
}