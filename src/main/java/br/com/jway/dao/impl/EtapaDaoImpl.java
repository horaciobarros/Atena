package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.EtapaDao;
import br.com.jway.model.Etapa;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class EtapaDaoImpl implements EtapaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Etapa> uaiCriteria;

	@Override
	 public List<Etapa> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Etapa.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Etapa.class).getResultList();
	}
	
	@Override
	public Etapa read(long id) {
		return em.find(Etapa.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Etapa etapa) {
		em.persist(etapa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Etapa update(Etapa etapa) {
		return em.merge(etapa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Etapa etapa) {
		em.remove(etapa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Etapa etapa = em.getReference(Etapa.class, id);
		delete(etapa);
	}
	@Override
	public List<Etapa> pesquisa(Etapa etapa){
		return null;	}
	
	
}