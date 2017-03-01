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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LancamentoCobranca read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(LancamentoCobranca lc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LancamentoCobranca update(LancamentoCobranca lc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(LancamentoCobranca lc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
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
