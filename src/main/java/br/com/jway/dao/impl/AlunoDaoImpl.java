package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.AlunoDao;
import br.com.jway.model.Aluno;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class AlunoDaoImpl implements AlunoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Aluno> uaiCriteria;

	@Override
	 public List<Aluno> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Aluno.class.getName() + " x ") //
			.append("INNER JOIN x.pessoa p ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Aluno.class).getResultList();
	}
	
	@Override
	public Aluno read(long id) {
		return em.find(Aluno.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Aluno aluno) {
		em.persist(aluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Aluno update(Aluno aluno) {
		return em.merge(aluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Aluno aluno) {
		em.remove(aluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Aluno aluno = em.getReference(Aluno.class, id);
		delete(aluno);
	}
	@Override
	public List<Aluno> pesquisa(Aluno aluno){
		return null;	}
	
	
}