package com.cafeview.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.service.IServiceListarReview;
import com.cafeview.web.ReviewModel;;


@Controller
@Scope("view")
public class MyReviewsFormBean {
	
	@Autowired
	@Qualifier("serviceListarReview")
	private IServiceListarReview serviceListarReview;
	
	
	private List<ReviewModel> myReviews;
	
	
	
	@PostConstruct
	public void init() {
		this.myReviews = serviceListarReview.getMyReviews((Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idusuario"));
	}
	
	public List<ReviewModel> getMyReviews() {
		
		return myReviews;
	}
	
	public String deletar() {
		Integer idreview = new Integer(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		this.serviceListarReview.deletar(idreview);
		return "/review/myReviews";
	}
}
