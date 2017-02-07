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
public  class AdvertenciaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(AdvertenciaBean.class);

	@Inject
	private AdvertenciaService service;
	
	private String state;
	private List<Advertencia> items;
	private List<TurmaDisciplinaAluno> listaTurmaDisciplinaAluno;

	private TurmaDisciplinaAluno TurmaDisciplinaAluno;

	@Inject
	private TurmaDisciplinaAlunoService turmadisciplinaalunoService;
	private List<Disciplina> listaDisciplina;

	private Disciplina Disciplina;

	@Inject
	private DisciplinaService disciplinaService;
	private Advertencia item;
	private Advertencia itemFilter;
	
	
	public AdvertenciaBean() {
		log.info("Bean constructor called.");
		itemFilter = new Advertencia();
		limpaPesquisa();
		listaTurmaDisciplinaAluno = turmadisciplinaalunoService.list();
listaDisciplina = disciplinaService.list();
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
			item = Advertencia.class.newInstance();
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
	
	public List<Advertencia> getItems() {
		return items;
	}
	
	public void setItems(List<Advertencia> items) {
		this.items = items;
	}
	
	public Advertencia getItem() {
		return item;
	}
	
	public void setItem(Advertencia item) {
		this.item = item;
	}
	public Advertencia getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Advertencia itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<TurmaDisciplinaAluno> getListaTurmaDisciplinaAluno(){
		return listaTurmaDisciplinaAluno;
	}
	
	public void setListaTurmaDisciplinaAluno(List<TurmaDisciplinaAluno> listaTurmaDisciplinaAluno){
		this.listaTurmaDisciplinaAluno = listaTurmaDisciplinaAluno;
	}
	
	
	public TurmaDisciplinaAluno getTurmaDisciplinaAluno(){
		return TurmaDisciplinaAluno;
	}
	
	public void setTurmaDisciplinaAluno(TurmaDisciplinaAluno TurmaDisciplinaAluno){
		this.TurmaDisciplinaAluno = TurmaDisciplinaAluno;
	}
	public List<Disciplina> getListaDisciplina(){
		return listaDisciplina;
	}
	
	public void setListaDisciplina(List<Disciplina> listaDisciplina){
		this.listaDisciplina = listaDisciplina;
	}
	
	
	public Disciplina getDisciplina(){
		return Disciplina;
	}
	
	public void setDisciplina(Disciplina Disciplina){
		this.Disciplina = Disciplina;
	}

}