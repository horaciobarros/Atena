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
public  class ResponsavelBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(ResponsavelBean.class);

	@Inject
	private ResponsavelService service;
	
	private String state;
	private List<Responsavel> items;
	private List<Pessoa> listaPessoa;

	private Pessoa Pessoa;

	@Inject
	private PessoaService pessoaService;
	private Responsavel item;
	private Responsavel itemFilter;
	
	
	public ResponsavelBean() {
		log.info("Bean constructor called.");
		itemFilter = new Responsavel();
		limpaPesquisa();
		listaPessoa = pessoaService.list();
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
			item = Responsavel.class.newInstance();
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
	
	public List<Responsavel> getItems() {
		return items;
	}
	
	public void setItems(List<Responsavel> items) {
		this.items = items;
	}
	
	public Responsavel getItem() {
		return item;
	}
	
	public void setItem(Responsavel item) {
		this.item = item;
	}
	public Responsavel getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Responsavel itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Pessoa> getListaPessoa(){
		return listaPessoa;
	}
	
	public void setListaPessoa(List<Pessoa> listaPessoa){
		this.listaPessoa = listaPessoa;
	}
	
	
	public Pessoa getPessoa(){
		return Pessoa;
	}
	
	public void setPessoa(Pessoa Pessoa){
		this.Pessoa = Pessoa;
	}

}