package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.UsuarioDao;
import br.com.jway.model.Usuario;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class UsuarioDaoImpl implements UsuarioDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Usuario> uaiCriteria;

	@Override
	 public List<Usuario> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Usuario.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Usuario.class).getResultList();
	}
	
	@Override
	public Usuario read(long id) {
		return em.find(Usuario.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Usuario usuario) {
		em.persist(usuario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Usuario update(Usuario usuario) {
		return em.merge(usuario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Usuario usuario) {
		em.remove(usuario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Usuario usuario = em.getReference(Usuario.class, id);
		delete(usuario);
	}
	@Override
	public List<Usuario> pesquisa(Usuario usuario){
		return null;	}
	
	
}