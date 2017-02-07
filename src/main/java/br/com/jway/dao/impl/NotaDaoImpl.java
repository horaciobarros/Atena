package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.NotaDao;
import br.com.jway.model.Nota;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class NotaDaoImpl implements NotaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Nota> uaiCriteria;

	@Override
	 public List<Nota> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Nota.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Nota.class).getResultList();
	}
	
	@Override
	public Nota read(long id) {
		return em.find(Nota.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Nota nota) {
		em.persist(nota);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Nota update(Nota nota) {
		return em.merge(nota);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Nota nota) {
		em.remove(nota);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Nota nota = em.getReference(Nota.class, id);
		delete(nota);
	}
	@Override
	public List<Nota> pesquisa(Nota nota){
		return null;	}
	
	
}