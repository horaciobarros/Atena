package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.LocalDao;
import br.com.jway.model.Local;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class LocalDaoImpl implements LocalDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	private TenancyService tenancyService;

	UaiCriteria<Local> uaiCriteria;

	@Override
	 public List<Local> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Local.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Local.class).getResultList();
	}
	
	@Override
	public Local read(long id) {
		return em.find(Local.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Local local) {
		local.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(local);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Local update(Local local) {
		return em.merge(local);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Local local) {
		em.remove(local);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Local local = em.getReference(Local.class, id);
		delete(local);
	}
	@Override
	public List<Local> pesquisa(Local local){
		return null;	}
	
	
}