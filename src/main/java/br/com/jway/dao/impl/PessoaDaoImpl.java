package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.PessoaDao;
import br.com.jway.model.Pessoa;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class PessoaDaoImpl implements PessoaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Pessoa> uaiCriteria;

	@Override
	 public List<Pessoa> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Pessoa.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Pessoa.class).getResultList();
	}
	
	@Override
	public Pessoa read(long id) {
		return em.find(Pessoa.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Pessoa pessoa) {
		em.persist(pessoa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Pessoa update(Pessoa pessoa) {
		return em.merge(pessoa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Pessoa pessoa) {
		em.remove(pessoa);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Pessoa pessoa = em.getReference(Pessoa.class, id);
		delete(pessoa);
	}
	@Override
	public List<Pessoa> pesquisa(Pessoa pessoa){
		return null;	}
	
	
}