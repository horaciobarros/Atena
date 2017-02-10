package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.ProfessorDao;
import br.com.jway.model.Professor;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class ProfessorDaoImpl implements ProfessorDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Professor> uaiCriteria;

	@Override
	 public List<Professor> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Professor.class.getName() + " x ") //
			.append("INNER JOIN x.pessoa ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Professor.class).getResultList();
	}
	
	@Override
	public Professor read(long id) {
		return em.find(Professor.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Professor professor) {
		em.persist(professor);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Professor update(Professor professor) {
		return em.merge(professor);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Professor professor) {
		em.remove(professor);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Professor professor = em.getReference(Professor.class, id);
		delete(professor);
	}
	@Override
	public List<Professor> pesquisa(Professor professor){
		return null;	}
	
	
}