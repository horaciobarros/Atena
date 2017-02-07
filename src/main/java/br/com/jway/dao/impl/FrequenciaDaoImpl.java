package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.FrequenciaDao;
import br.com.jway.model.Frequencia;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class FrequenciaDaoImpl implements FrequenciaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Frequencia> uaiCriteria;

	@Override
	 public List<Frequencia> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Frequencia.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Frequencia.class).getResultList();
	}
	
	@Override
	public Frequencia read(long id) {
		return em.find(Frequencia.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Frequencia frequencia) {
		em.persist(frequencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Frequencia update(Frequencia frequencia) {
		return em.merge(frequencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Frequencia frequencia) {
		em.remove(frequencia);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Frequencia frequencia = em.getReference(Frequencia.class, id);
		delete(frequencia);
	}
	@Override
	public List<Frequencia> pesquisa(Frequencia frequencia){
		return null;	}
	
	
}