package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.uaicriteria.UaiCriteria;

import br.com.jway.dao.BaixaCobrancaDao;
import br.com.jway.model.BaixaCobranca;
import br.com.jway.model.LancamentoCobranca;
import br.com.jway.service.TenancyService;

@Named
public class BaixaCobrancaDaoImpl implements BaixaCobrancaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;
	
	@Inject
	private TenancyService tenancyService;

	UaiCriteria<BaixaCobranca> uaiCriteria;

	@Override
	public List<BaixaCobranca> list() {
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + BaixaCobranca.class.getName() + " x ") //
				.append("INNER JOIN x.lancamentoCobranca lc ")
				.append("INNER JOIN lc.matricula m ")
				.append("INNER JOIN m.aluno a ")
				.append("INNER JOIN a.pessoa p ")
				.append("INNER JOIN m.turma t ")
				.append("ORDER BY x.id ASC ");
			return em.createQuery(jpql.toString(), BaixaCobranca.class).getResultList();
	}

	@Override
	public BaixaCobranca read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(BaixaCobranca bc) {
		bc.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(bc);
		
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public BaixaCobranca update(BaixaCobranca bc) {
		return em.merge(bc);}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(BaixaCobranca bc) {
		em.remove(bc);
		
	}

	@Override
	public void delete(long id) {
		BaixaCobranca bc = em.getReference(BaixaCobranca.class, id);
		delete(bc);
	}

	@Override
	public List<BaixaCobranca> pesquisa(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		return null;
	}

}
