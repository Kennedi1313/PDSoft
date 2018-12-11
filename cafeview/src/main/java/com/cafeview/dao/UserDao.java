package com.cafeview.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.cafeview.dominio.User;

@Repository
public class UserDao extends AbstractDao<Long, User> {

	public User getUsuario(String emailUsuario, String senha) {

		try {
			User usuario = (User) getSession()
					.createQuery("SELECT u from User u where u.email = :email and u.senha = :senha")
					.setParameter("email", emailUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
}