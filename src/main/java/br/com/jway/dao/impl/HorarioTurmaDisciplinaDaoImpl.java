package br.com.jway.dao.impl; 

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.jway.dao.HorarioTurmaDisciplinaDao;
import br.com.jway.model.HorarioTurmaDisciplina;
import br.com.jway.dao.*;
import com.uaihebert.uaicriteria.UaiCriteria;

@Named 
public class HorarioTurmaDisciplinaDaoImpl implements HorarioTurmaDisciplinaDao{

	private static final long serialVersionUID = 1L;

	@PersistenceContext 
	protected EntityManager em;

	UaiCriteria<HorarioTurmaDisciplina> uaiCriteria;

	@Override
	 public List<HorarioTurmaDisciplina> list() {
		StringBuilder jpql = new StringBuilder()
			.append("SELECT x ") 
			.append("FROM " + HorarioTurmaDisciplina.class.getName() + " x ") //
			.append("ORDER BY x.id ASC ");
		return em.createQuery(jpql.toString(), HorarioTurmaDisciplina.class).getResultList();
	}
	
	@Override
	public HorarioTurmaDisciplina read(long id) {
		return em.find(HorarioTurmaDisciplina.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(HorarioTurmaDisciplina horarioturmadisciplina) {
		em.persist(horarioturmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public HorarioTurmaDisciplina update(HorarioTurmaDisciplina horarioturmadisciplina) {
		return em.merge(horarioturmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(HorarioTurmaDisciplina horarioturmadisciplina) {
		em.remove(horarioturmadisciplina);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(long id) {
		HorarioTurmaDisciplina horarioturmadisciplina = em.getReference(HorarioTurmaDisciplina.class, id);
		delete(horarioturmadisciplina);
	}
	@Override
	public List<HorarioTurmaDisciplina> pesquisa(HorarioTurmaDisciplina horarioturmadisciplina){
		return null;	}
	
	
}