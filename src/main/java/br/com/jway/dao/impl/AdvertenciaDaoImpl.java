package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.AdvertenciaDao;
import br.com.jway.model.Advertencia;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class AdvertenciaDaoImpl implements AdvertenciaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Advertencia> uaiCriteria;

	@Override
	 public List<Advertencia> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Advertencia.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Advertencia.class).getResultList();
	}
	
	@Override
	public Advertencia read(long id) {
		return em.find(Advertencia.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Advertencia advertencia) {
		em.persist(advertencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Advertencia update(Advertencia advertencia) {
		return em.merge(advertencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Advertencia advertencia) {
		em.remove(advertencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Advertencia advertencia = em.getReference(Advertencia.class, id);
		delete(advertencia);
	}
	@Override
	public List<Advertencia> pesquisa(Advertencia advertencia){
		return null;	}
	
	
}