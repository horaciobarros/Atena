package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.TurmaDisciplinaAlunoDao;
import br.com.jway.model.TurmaDisciplinaAluno;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class TurmaDisciplinaAlunoDaoImpl implements TurmaDisciplinaAlunoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<TurmaDisciplinaAluno> uaiCriteria;

	@Override
	 public List<TurmaDisciplinaAluno> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + TurmaDisciplinaAluno.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), TurmaDisciplinaAluno.class).getResultList();
	}
	
	@Override
	public TurmaDisciplinaAluno read(long id) {
		return em.find(TurmaDisciplinaAluno.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(TurmaDisciplinaAluno turmadisciplinaaluno) {
		em.persist(turmadisciplinaaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public TurmaDisciplinaAluno update(TurmaDisciplinaAluno turmadisciplinaaluno) {
		return em.merge(turmadisciplinaaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(TurmaDisciplinaAluno turmadisciplinaaluno) {
		em.remove(turmadisciplinaaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		TurmaDisciplinaAluno turmadisciplinaaluno = em.getReference(TurmaDisciplinaAluno.class, id);
		delete(turmadisciplinaaluno);
	}
	@Override
	public List<TurmaDisciplinaAluno> pesquisa(TurmaDisciplinaAluno turmadisciplinaaluno){
		return null;	}
	
	
}