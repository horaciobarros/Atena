package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.uaicriteria.UaiCriteria;

import br.com.jway.dao.ServicoMatriculaDao;
import br.com.jway.model.ServicoMatricula;
import br.com.jway.service.TenancyService;

@Named
public class ServicoMatriculaDaoImpl implements ServicoMatriculaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	TenancyService tenancyService;

	UaiCriteria<ServicoMatricula> uaiCriteria;

	@Override
	 public List<ServicoMatricula> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + ServicoMatricula.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), ServicoMatricula.class).getResultList();
	}
	
	@Override
	public ServicoMatricula read(long id) {
		return em.find(ServicoMatricula.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(ServicoMatricula servicoMatricula) {
		servicoMatricula.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(servicoMatricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public ServicoMatricula update(ServicoMatricula servicoMatricula) {
		return em.merge(servicoMatricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(ServicoMatricula servicoMatricula) {
		em.remove(servicoMatricula);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		ServicoMatricula servicoMatricula = em.getReference(ServicoMatricula.class, id);
		delete(servicoMatricula);
	}
	@Override
	public List<ServicoMatricula> pesquisa(ServicoMatricula servicoMatricula){
		return null;	}

	@Override
	public List<ServicoMatricula> findByMatriculaId(Long id) {
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + ServicoMatricula.class.getName() + " x ") //
				.append("INNER JOIN x.matricula matricula ")
				.append("INNER JOIN x.servico servico ")
				.append("WHERE matricula.id = " + id);
			return em.createQuery(jpql.toString(), ServicoMatricula.class).getResultList();
	}
}
