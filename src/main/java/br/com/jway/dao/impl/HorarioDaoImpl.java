package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.HorarioDao;
import br.com.jway.model.Horario;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class HorarioDaoImpl implements HorarioDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<Horario> uaiCriteria;

	@Override
	 public List<Horario> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + Horario.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), Horario.class).getResultList();
	}
	
	@Override
	public Horario read(long id) {
		return em.find(Horario.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Horario horario) {
		em.persist(horario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Horario update(Horario horario) {
		return em.merge(horario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Horario horario) {
		em.remove(horario);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		Horario horario = em.getReference(Horario.class, id);
		delete(horario);
	}
	@Override
	public List<Horario> pesquisa(Horario horario){
		return null;	}
	
	
}