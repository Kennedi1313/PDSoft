package com.cafeview.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public abstract class AbstractDao<PK extends Serializable, T> extends HibernateDaoSupport implements Dao<Serializable, T> {
	
	private final Class<T> entityBeanType;
	
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.entityBeanType = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
	}
	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(entityBeanType, id);
    }
	@Override
	public void persist(T entity) {
		getHibernateTemplate().persist(entity);
    }
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
    }
	@Override
    public void delete(T entity) {
		getHibernateTemplate().delete(entity);
    }
	@Override
    public void delete(Serializable id) {
		getHibernateTemplate().delete(hibernateTemplate.get(entityBeanType, id));
    }
	@Override
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	return (List<T>) getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityBeanType));
    }
    @Override
    @SuppressWarnings("unchecked")
	public List<T> findAllPaginated(Integer startPosition, Integer maxResult) {
    	return (List<T>) getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityBeanType), startPosition, maxResult);
    }
    @Override
    public Long countAll() {
    	return (Long) getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(t) FROM " + entityBeanType.getSimpleName() + " t").uniqueResult();
    }
    
    @PostConstruct
    public void init(){
    	setHibernateTemplate(hibernateTemplate);
    }
    

}
