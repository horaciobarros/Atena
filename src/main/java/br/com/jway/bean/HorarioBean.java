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
public  class HorarioBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(HorarioBean.class);

	@Inject
	private HorarioService service;
	
	@Inject
	private TurmaService turmaService;
	
	@Inject
	private DisciplinaService disciplinaService;
	
	private String state;
	private List<Horario> items;
	private Horario item;
	private Horario itemFilter;
	
	private List<Turma> listaTurma;
	private List<Disciplina> listaDisciplina;
	
	
	public HorarioBean() {
		log.info("Bean constructor called.");
		itemFilter = new Horario();
		limpaPesquisa();
			}
	
	
	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
		listaTurma = turmaService.list();
		listaDisciplina = disciplinaService.list();
	}
	
	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}
	
	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = Horario.class.newInstance();
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
	
	public void pesquisa(){
		items = service.pesquisa(item);
	}
	
	public void limpaPesquisa(){
	
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
	
	public List<Horario> getItems() {
		return items;
	}
	
	public void setItems(List<Horario> items) {
		this.items = items;
	}
	
	public Horario getItem() {
		return item;
	}
	
	public void setItem(Horario item) {
		this.item = item;
	}
	public Horario getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Horario itemFilter) {
		this.itemFilter = itemFilter;
	}


	public List<Turma> getListaTurma() {
		return listaTurma;
	}


	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}


	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}


	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	

}