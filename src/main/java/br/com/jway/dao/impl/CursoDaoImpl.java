package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.CursoDao;
import br.com.jway.model.Curso;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class CursoDaoImpl implements CursoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	private TenancyService tenancyService;

	UaiCriteria<Curso> uaiCriteria;

	@Override
	 public List<Curso> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Curso.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Curso.class).getResultList();
	}
	
	@Override
	public Curso read(long id) {
		return em.find(Curso.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Curso curso) {
		curso.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(curso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Curso update(Curso curso) {
		return em.merge(curso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Curso curso) {
		em.remove(curso);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Curso curso = em.getReference(Curso.class, id);
		delete(curso);
	}
	@Override
	public List<Curso> pesquisa(Curso curso){
		return null;	}
	
	
}