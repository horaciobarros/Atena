package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uaihebert.uaicriteria.UaiCriteria;

import br.com.jway.dao.BaixaCobrancaDao;
import br.com.jway.model.BaixaCobranca;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaixaCobranca read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaixaCobranca update(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BaixaCobranca> pesquisa(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		return null;
	}

}
