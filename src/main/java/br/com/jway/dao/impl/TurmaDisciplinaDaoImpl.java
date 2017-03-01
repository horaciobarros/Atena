package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.TurmaDisciplinaDao;
import br.com.jway.model.TurmaDisciplina;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class TurmaDisciplinaDaoImpl implements TurmaDisciplinaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<TurmaDisciplina> uaiCriteria;

	@Override
	 public List<TurmaDisciplina> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + TurmaDisciplina.class.getName() + " x ") //
			.append("INNER JOIN x.disciplina d ")
			.append("INNER JOIN x.professor p ")
			.append("INNER JOIN x.professor.pessoa pe ")
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), TurmaDisciplina.class).getResultList();
	}
	
	@Override
	public TurmaDisciplina read(long id) {
		return em.find(TurmaDisciplina.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(TurmaDisciplina turmadisciplina) {
		em.persist(turmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public TurmaDisciplina update(TurmaDisciplina turmadisciplina) {
		return em.merge(turmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(TurmaDisciplina turmadisciplina) {
		em.remove(turmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		TurmaDisciplina turmadisciplina = em.getReference(TurmaDisciplina.class, id);
		delete(turmadisciplina);
	}
	@Override
	public List<TurmaDisciplina> pesquisa(TurmaDisciplina turmadisciplina){
		return null;	}
	
	
}