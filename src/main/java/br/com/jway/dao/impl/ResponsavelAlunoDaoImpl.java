package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.ResponsavelAlunoDao;
import br.com.jway.model.ResponsavelAluno;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class ResponsavelAlunoDaoImpl implements ResponsavelAlunoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<ResponsavelAluno> uaiCriteria;

	@Override
	 public List<ResponsavelAluno> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + ResponsavelAluno.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), ResponsavelAluno.class).getResultList();
	}
	
	@Override
	public ResponsavelAluno read(long id) {
		return em.find(ResponsavelAluno.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(ResponsavelAluno responsavelaluno) {
		em.persist(responsavelaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public ResponsavelAluno update(ResponsavelAluno responsavelaluno) {
		return em.merge(responsavelaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(ResponsavelAluno responsavelaluno) {
		em.remove(responsavelaluno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		ResponsavelAluno responsavelaluno = em.getReference(ResponsavelAluno.class, id);
		delete(responsavelaluno);
	}
	@Override
	public List<ResponsavelAluno> pesquisa(ResponsavelAluno responsavelaluno){
		return null;	}
	
	
}