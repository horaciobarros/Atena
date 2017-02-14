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
public  class EscolaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(EscolaBean.class);

	@Inject
	private EscolaService service;
	@Inject
	private UfService ufService;
	@Inject
	private CidadeService cidadeService;
	
	private List<Uf> ufs;
	private List<Cidade> cidades;
	
	private String state;
	private List<Escola> items;
	private Escola item;
	private Escola itemFilter;
	
	
	public EscolaBean() {
		log.info("Bean constructor called.");
		itemFilter = new Escola();
		limpaPesquisa();
			}
	
	
	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
		ufs = ufService.list();
		cidades = cidadeService.list();
	}
	
	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}
	
	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = Escola.class.newInstance();
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
	
	public List<Escola> getItems() {
		return items;
	}
	
	public void setItems(List<Escola> items) {
		this.items = items;
	}
	
	public Escola getItem() {
		return item;
	}
	
	public void setItem(Escola item) {
		this.item = item;
	}
	public Escola getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Escola itemFilter) {
		this.itemFilter = itemFilter;
	}
	
	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}
	
	public void refreshUf() {
		cidades = cidadeService.findByUf(item.getUf());
		
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}


}