package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.ResponsavelDao;
import br.com.jway.model.Responsavel;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class ResponsavelDaoImpl implements ResponsavelDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Responsavel> uaiCriteria;

	@Override
	 public List<Responsavel> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Responsavel.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Responsavel.class).getResultList();
	}
	
	@Override
	public Responsavel read(long id) {
		return em.find(Responsavel.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Responsavel responsavel) {
		em.persist(responsavel);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Responsavel update(Responsavel responsavel) {
		return em.merge(responsavel);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Responsavel responsavel) {
		em.remove(responsavel);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Responsavel responsavel = em.getReference(Responsavel.class, id);
		delete(responsavel);
	}
	@Override
	public List<Responsavel> pesquisa(Responsavel responsavel){
		return null;	}
	
	
}