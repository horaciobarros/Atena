package br.com.jway.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import br.com.jway.service.*;
import br.com.jway.model.*;
import br.com.jway.util.FacesUtils;

@ManagedBean
@ViewScoped
public class TurmaDisciplinaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(TurmaDisciplinaBean.class);

	@Inject
	private TurmaDisciplinaService service;

	private String state;
	private List<TurmaDisciplina> items;
	private List<Disciplina> listaDisciplina;
	private List<Professor> listaProfessor;

	private Disciplina Disciplina;

	@Inject
	private DisciplinaService disciplinaService;
	private List<Turma> listaTurma;

	@Inject
	private ProfessorService professorService;

	private Turma Turma;

	@Inject
	private TurmaService turmaService;
	private TurmaDisciplina item;
	private TurmaDisciplina itemFilter;

	public TurmaDisciplinaBean() {
		log.info("Bean constructor called.");
		itemFilter = new TurmaDisciplina();
		limpaPesquisa();
		listaDisciplina = disciplinaService.list();
		listaTurma = turmaService.list();
		listaProfessor = professorService.list();
	}

	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
	}

	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}

	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = TurmaDisciplina.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			FacesUtils.addI18nError("generic.bean.unableToCleanViewData");
		}
	}

	public void create() {
		service.create(item);
		limpaPesquisa();
		items = service.list();
		item = null;
	}

	public void update() {
		service.update(item);
		limpaPesquisa();
		items = service.list();
		item = null;
	}

	public void delete() {
		service.delete(item.getId());
		limpaPesquisa();
		items = service.list();
		item = null;
	}

	public void pesquisa() {
		items = service.pesquisa(item);
	}

	public void limpaPesquisa() {

	}

	@PreDestroy
	private void preDestroy() {
		log.info("Bean @PreDestroy called.");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TurmaDisciplina> getItems() {
		return items;
	}

	public void setItems(List<TurmaDisciplina> items) {
		this.items = items;
	}

	public TurmaDisciplina getItem() {
		return item;
	}

	public void setItem(TurmaDisciplina item) {
		this.item = item;
	}

	public TurmaDisciplina getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(TurmaDisciplina itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public Disciplina getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(Disciplina Disciplina) {
		this.Disciplina = Disciplina;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public Turma getTurma() {
		return Turma;
	}

	public void setTurma(Turma Turma) {
		this.Turma = Turma;
	}

	public List<Professor> getListaProfessor() {
		return listaProfessor;
	}

	public void setListaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}

}