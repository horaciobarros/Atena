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
public  class HorarioTurmaDisciplinaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(HorarioTurmaDisciplinaBean.class);

	@Inject
	private HorarioTurmaDisciplinaService service;
	
	private String state;
	private List<HorarioTurmaDisciplina> items;
	private List<TurmaDisciplina> listaTurmaDisciplina;

	private TurmaDisciplina TurmaDisciplina;

	@Inject
	private TurmaDisciplinaService turmadisciplinaService;
	private HorarioTurmaDisciplina item;
	private HorarioTurmaDisciplina itemFilter;
	
	
	public HorarioTurmaDisciplinaBean() {
		log.info("Bean constructor called.");
		itemFilter = new HorarioTurmaDisciplina();
		limpaPesquisa();
		listaTurmaDisciplina = turmadisciplinaService.list();
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
			item = HorarioTurmaDisciplina.class.newInstance();
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
	
	public List<HorarioTurmaDisciplina> getItems() {
		return items;
	}
	
	public void setItems(List<HorarioTurmaDisciplina> items) {
		this.items = items;
	}
	
	public HorarioTurmaDisciplina getItem() {
		return item;
	}
	
	public void setItem(HorarioTurmaDisciplina item) {
		this.item = item;
	}
	public HorarioTurmaDisciplina getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(HorarioTurmaDisciplina itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<TurmaDisciplina> getListaTurmaDisciplina(){
		return listaTurmaDisciplina;
	}
	
	public void setListaTurmaDisciplina(List<TurmaDisciplina> listaTurmaDisciplina){
		this.listaTurmaDisciplina = listaTurmaDisciplina;
	}
	
	
	public TurmaDisciplina getTurmaDisciplina(){
		return TurmaDisciplina;
	}
	
	public void setTurmaDisciplina(TurmaDisciplina TurmaDisciplina){
		this.TurmaDisciplina = TurmaDisciplina;
	}

}