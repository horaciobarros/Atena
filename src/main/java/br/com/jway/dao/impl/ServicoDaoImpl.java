package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.uaicriteria.UaiCriteria;

import br.com.jway.dao.ServicoDao;
import br.com.jway.model.Servico;
import br.com.jway.service.TenancyService;

public class ServicoDaoImpl implements ServicoDao{
	
	@Inject
	private TenancyService tenancyService;

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Servico> uaiCriteria;

	@Override
	 public List<Servico> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Servico.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Servico.class).getResultList();
	}
	
	@Override
	public Servico read(long id) {
		return em.find(Servico.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Servico servico) {
		servico.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(servico);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Servico update(Servico servico) {
		return em.merge(servico);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Servico servico) {
		em.remove(servico);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Servico servico = em.getReference(Servico.class, id);
		delete(servico);
	}
	@Override
	public List<Servico> pesquisa(Servico servico){
		return null;	}
	

}
