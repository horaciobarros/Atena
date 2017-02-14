package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.TurmaDao;
import br.com.jway.model.Turma;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class TurmaDaoImpl implements TurmaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	TenancyService tenancyService;

	UaiCriteria<Turma> uaiCriteria;

	@Override
	 public List<Turma> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Turma.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Turma.class).getResultList();
	}
	
	@Override
	public Turma read(long id) {
		return em.find(Turma.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Turma turma) {
		turma.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(turma);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Turma update(Turma turma) {
		return em.merge(turma);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Turma turma) {
		em.remove(turma);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Turma turma = em.getReference(Turma.class, id);
		delete(turma);
	}
	@Override
	public List<Turma> pesquisa(Turma turma){
		return null;	}
	
	
}