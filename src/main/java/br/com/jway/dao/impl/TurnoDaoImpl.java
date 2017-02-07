package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.TurnoDao;
import br.com.jway.model.Turno;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class TurnoDaoImpl implements TurnoDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Turno> uaiCriteria;

	@Override
	 public List<Turno> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Turno.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Turno.class).getResultList();
	}
	
	@Override
	public Turno read(long id) {
		return em.find(Turno.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Turno turno) {
		em.persist(turno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Turno update(Turno turno) {
		return em.merge(turno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Turno turno) {
		em.remove(turno);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Turno turno = em.getReference(Turno.class, id);
		delete(turno);
	}
	@Override
	public List<Turno> pesquisa(Turno turno){
		return null;	}
	
	
}