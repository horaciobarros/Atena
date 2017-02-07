package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.DisciplinaDao;
import br.com.jway.model.Disciplina;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class DisciplinaDaoImpl implements DisciplinaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Disciplina> uaiCriteria;

	@Override
	 public List<Disciplina> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Disciplina.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Disciplina.class).getResultList();
	}
	
	@Override
	public Disciplina read(long id) {
		return em.find(Disciplina.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Disciplina disciplina) {
		em.persist(disciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Disciplina update(Disciplina disciplina) {
		return em.merge(disciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Disciplina disciplina) {
		em.remove(disciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Disciplina disciplina = em.getReference(Disciplina.class, id);
		delete(disciplina);
	}
	@Override
	public List<Disciplina> pesquisa(Disciplina disciplina){
		return null;	}
	
	
}