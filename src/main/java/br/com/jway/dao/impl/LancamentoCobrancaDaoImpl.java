package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;

import br.com.jway.dao.LancamentoCobrancaDao;
import br.com.jway.model.LancamentoCobranca;
import br.com.jway.service.TenancyService;

@Named
public class LancamentoCobrancaDaoImpl implements LancamentoCobrancaDao{
	
	@Inject
	private TenancyService tenancyService;

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<LancamentoCobranca> uaiCriteria;

	@Override
	public List<LancamentoCobranca> list() {
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + LancamentoCobranca.class.getName() + " x ") //
				.append("INNER JOIN x.matricula m ")
				.append("INNER JOIN m.aluno a ")
				.append("INNER JOIN a.pessoa p ")
				.append("ORDER BY x.id ASC ");
			return em.createQuery(jpql.toString(), LancamentoCobranca.class).getResultList();
	}

	@Override
	public LancamentoCobranca read(long id) {
		return em.find(LancamentoCobranca.class, id);
	}

	@Override
	public void create(LancamentoCobranca lc) {
		lc.setTenancy(tenancyService.getTenancyDaSessao());
		em.persist(lc);
		
	}

	@Override
	public LancamentoCobranca update(LancamentoCobranca lc) {
		return em.merge(lc);
	}

	@Override
	public void delete(LancamentoCobranca lc) {
		em.remove(lc);
		
	}

	@Override
	public void delete(long id) {
		LancamentoCobranca turma = em.getReference(LancamentoCobranca.class, id);
		delete(turma);
		
	}

	@Override
	public List<LancamentoCobranca> pesquisa(LancamentoCobranca lc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LancamentoCobranca findByMatricula(String lc) {
		// TODO Auto-generated method stub
		return null;
	}

}
