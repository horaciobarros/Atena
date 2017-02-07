package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.AvisoDao;
import br.com.jway.model.Aviso;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class AvisoDaoImpl implements AvisoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Aviso> uaiCriteria;

	@Override
	 public List<Aviso> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Aviso.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Aviso.class).getResultList();
	}
	
	@Override
	public Aviso read(long id) {
		return em.find(Aviso.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Aviso aviso) {
		em.persist(aviso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Aviso update(Aviso aviso) {
		return em.merge(aviso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Aviso aviso) {
		em.remove(aviso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Aviso aviso = em.getReference(Aviso.class, id);
		delete(aviso);
	}
	@Override
	public List<Aviso> pesquisa(Aviso aviso){
		return null;	}
	
	
}