package br.com.jway.dao.impl; 

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.dao.AlunoDao;
import br.com.jway.model.Aluno;
import br.com.jway.service.TenancyService;
import br.com.jway.dao.*;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@Named 
public class AlunoDaoImpl implements AlunoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Aluno> uaiCriteria;
	
	@Inject
	private TenancyService tenancyService;

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
		
		aluno.setTenancy(tenancyService.getTenancyDaSessao());
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
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + Aluno.class.getName() + " x ") //
				.append("INNER JOIN x.pessoa p ") //
				.append("WHERE 1 = 1 ");
				if (aluno.getMatricula() != null && !aluno.getMatricula().isEmpty()) {
					jpql.append("AND x.matricula LIKE '%" + aluno.getMatricula() + "%' ");
				}
				if (aluno.getPessoa() != null && aluno.getPessoa().getId() != null) {
					jpql.append("AND x.pessoa.id = " + aluno.getPessoa().getId() + " ");
				} else {
					if (aluno.getPessoa() != null && aluno.getPessoa().getCpf() != null) {
						jpql.append("AND x.pessoa.cpf LIKE '%" + aluno.getPessoa().getCpf() + "%' "); 
					}
				}
				
				jpql.append("ORDER BY x.id ASC ");
				
			return em.createQuery(jpql.toString(), Aluno.class).getResultList();
	}
	
	@Override
	public Aluno findByMatricula(String matricula){
		final UaiCriteria<Aluno> uaiCriteria = UaiCriteriaFactory.createQueryCriteria(em, Aluno.class);
		uaiCriteria.andEquals("matricula", matricula);
		final List<Aluno> uaiCriteriaResult =  uaiCriteria.getResultList();
		if (uaiCriteriaResult!=null && uaiCriteriaResult.size()>0){
			return uaiCriteriaResult.get(0);
		}
		else{
			
		}
		return null;
	}
	
}