package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;
import br.com.jway.model.Matricula;

import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class MatriculaDaoImpl implements MatriculaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	TenancyService tenancyService;

	UaiCriteria<Matricula> uaiCriteria;

	@Override
	 public List<Matricula> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Matricula.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Matricula.class).getResultList();
	}
	
	@Override
	public Matricula read(long id) {
		return em.find(Matricula.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Matricula matricula) {
		matricula.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(matricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Matricula update(Matricula matricula) {
		return em.merge(matricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Matricula matricula) {
		em.remove(matricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Matricula matricula = em.getReference(Matricula.class, id);
		delete(matricula);
	}
	@Override
	public List<Matricula> pesquisa(Matricula matricula){
		return null;	}
	
	
}