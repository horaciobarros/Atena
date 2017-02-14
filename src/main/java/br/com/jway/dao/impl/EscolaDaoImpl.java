package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.EscolaDao;
import br.com.jway.model.Escola;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class EscolaDaoImpl implements EscolaDao{
	
	@Inject
	private TenancyService tenancyService;

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Escola> uaiCriteria;

	@Override
	 public List<Escola> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Escola.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Escola.class).getResultList();
	}
	
	@Override
	public Escola read(long id) {
		return em.find(Escola.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Escola escola) {
		escola.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(escola);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Escola update(Escola escola) {
		return em.merge(escola);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Escola escola) {
		em.remove(escola);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Escola escola = em.getReference(Escola.class, id);
		delete(escola);
	}
	@Override
	public List<Escola> pesquisa(Escola escola){
		return null;	}
	
	
}