package com.cafeview.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cafeview.dominio.Empresa;
import com.cafeview.service.IServiceListarEmpresas;
import com.cafeview.service.IServiceListarReview;
import com.cafeview.service.IServiceReview;
import com.cafeview.service.NegocioException;

@Controller
@Scope("view")
public class CadastrarReviewFormBean extends AbstractFormBean{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("serviceReview")
	private IServiceReview serviceReview;
	@Autowired
	@Qualifier("serviceListarEmpresas")
	private IServiceListarEmpresas serviceListar;
	@Autowired
	@Qualifier("serviceListarReview")
	private IServiceListarReview serviceListarReview;
	
	private ReviewModel reviewModel;
	private Map<String, Integer> empresas;
	private List<ReviewModel> reviews;
	private List<ReviewModel> reviewsByIdEmpresa;
	private Integer idBusca;
	
	public CadastrarReviewFormBean() {
		// Inicializando o objeto para ele não ser nulo
		 this.setReviewModel(new ReviewModel());
	}

	public String cadastrar() {
		try {
			
			reviewModel.setIduser((Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idusuario"));
			this.serviceReview.validar(getReviewModel());
			this.serviceReview.cadastrar(getReviewModel());
			addInfoMessage("Review cadastrado com successo!");
			this.setReviewModel(new ReviewModel());
		} catch (NegocioException e) {
			addErrorMessage(e.getMessage());
		}
		return null;
	}
	
	

	public Integer getIdBusca() {
		return idBusca;
	}

	public void setIdBusca(Integer idBusca) {
		this.idBusca = idBusca;
	}

	public ReviewModel getReviewModel() {
		return reviewModel;
	}

	public void setReviewModel(ReviewModel reviewModel) {
		this.reviewModel = reviewModel;
	}
	
	@PostConstruct
	public void init() {
		this.reviews = serviceListarReview.getReviews();
	}
	
	@Transactional
	public List<ReviewModel> getReviewsByIdEmpresa() throws IOException {
		this.reviews = serviceListarReview.getReviewsByIdEmpresa(idBusca);
		
		return reviews;
	}
	
	public List<ReviewModel> getReviews() {
		
		return reviews;
	}
	
	public Map<String, Integer> getEmpresas(){
		this.empresas = new HashMap<String, Integer>();
		List<Empresa> lista = serviceListar.getEmpresas();
		for (Empresa empresa : lista) {
			this.empresas.put(empresa.getNome(), empresa.getId());
		}
		return empresas;
	}
}
