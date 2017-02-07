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
public  class AvisoBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(AvisoBean.class);

	@Inject
	private AvisoService service;
	
	private String state;
	private List<Aviso> items;
	private List<TurmaDisciplinaAluno> listaTurmaDisciplinaAluno;

	private TurmaDisciplinaAluno TurmaDisciplinaAluno;

	@Inject
	private TurmaDisciplinaAlunoService turmadisciplinaalunoService;
	private Aviso item;
	private Aviso itemFilter;
	
	
	public AvisoBean() {
		log.info("Bean constructor called.");
		itemFilter = new Aviso();
		limpaPesquisa();
		listaTurmaDisciplinaAluno = turmadisciplinaalunoService.list();
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
			item = Aviso.class.newInstance();
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
	
	public List<Aviso> getItems() {
		return items;
	}
	
	public void setItems(List<Aviso> items) {
		this.items = items;
	}
	
	public Aviso getItem() {
		return item;
	}
	
	public void setItem(Aviso item) {
		this.item = item;
	}
	public Aviso getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Aviso itemFilter) {
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

}