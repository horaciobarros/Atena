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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import br.com.jway.service.*;
import br.com.jway.model.*;
import br.com.jway.util.FacesUtils;

@ManagedBean
@ViewScoped
public class BaixaCobrancaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(BaixaCobrancaBean.class);

	@Inject
	private BaixaCobrancaService service;
	
	@Inject
	private LancamentoCobrancaService lancamentoCobrancaService;

	private String state;
	private List<BaixaCobranca> items;
	private BaixaCobranca item;
	private BaixaCobranca itemFilter;
	private List<LancamentoCobranca> listaLancamentoCobranca;

	public BaixaCobrancaBean() {
		log.info("Bean constructor called.");
		itemFilter = new BaixaCobranca();
		limpaPesquisa();
	}

	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
		listaLancamentoCobranca = lancamentoCobrancaService.list();
	}

	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}

	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = BaixaCobranca.class.newInstance();
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

	public List<BaixaCobranca> getItems() {
		return items;
	}

	public void setItems(List<BaixaCobranca> items) {
		this.items = items;
	}

	public BaixaCobranca getItem() {
		return item;
	}

	public void setItem(BaixaCobranca item) {
		this.item = item;
	}

	public BaixaCobranca getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(BaixaCobranca itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<LancamentoCobranca> getListaLancamentoCobranca() {
		return listaLancamentoCobranca;
	}

	public void setListaLancamentoCobranca(List<LancamentoCobranca> listaLancamentoCobranca) {
		this.listaLancamentoCobranca = listaLancamentoCobranca;
	}

}