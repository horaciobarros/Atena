package br.com.jway.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jway.dao.CidadeDao;
import br.com.jway.model.Cidade;
import br.com.jway.model.Uf;

@Named
public class CidadeDaoImpl implements CidadeDao{
	
	@PersistenceContext 
	protected EntityManager em;

	@Override
	public List<Cidade> list() {
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + Cidade.class.getName() + " x ") //
				.append("ORDER BY x.municipio ");
			return em.createQuery(jpql.toString(), Cidade.class).getResultList();
	}

	@Override
	public Cidade read(String codigo) {
		return em.find(Cidade.class, codigo);
	}

	@Override
	public void create(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cidade update(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cidade> pesquisa(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> findByUf(Uf uf) {
		StringBuilder jpql = new StringBuilder()
				.append("SELECT x ") 
				.append("FROM " + Cidade.class.getName() + " x ") //
				.append("WHERE x.uf = '" + uf.getUf() + "'")
				.append("ORDER BY x.municipio ");
			return em.createQuery(jpql.toString(), Cidade.class).getResultList();
	}

}
