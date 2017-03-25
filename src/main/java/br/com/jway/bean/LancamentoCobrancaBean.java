package br.com.jway.bean;

import java.io.Serializable;
import java.math.BigDecimal;
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
import br.com.jway.util.Util;

@ManagedBean
@ViewScoped
public class LancamentoCobrancaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(LancamentoCobrancaBean.class);

	@Inject
	private LancamentoCobrancaService service;

	private String state;
	private List<LancamentoCobranca> items;
	private List<Matricula> listaMatricula;

	@Inject
	private MatriculaService matriculaService;

	private LancamentoCobranca item;
	private LancamentoCobranca itemFilter;

	public LancamentoCobrancaBean() {
		log.info("Bean constructor called.");
		itemFilter = new LancamentoCobranca();
		item = null;
		limpaPesquisa();
		listaMatricula = matriculaService.listSemServicos();
	}

	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		item = null;
		items = service.list();
	}

	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}

	public void clearItem() {
		item = new LancamentoCobranca();
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

	public List<LancamentoCobranca> getItems() {
		return items;
	}

	public void setItems(List<LancamentoCobranca> items) {
		this.items = items;
	}

	public LancamentoCobranca getItem() {
		if (item == null) {
			item = new LancamentoCobranca();
		}
		return item;
	}

	public void setItem(LancamentoCobranca item) {
		this.item = item;
	}

	public LancamentoCobranca getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(LancamentoCobranca itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Matricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
	}

	public void getValorCobrado() {
		item.setValorCobrado(matriculaService.getValorLiquidoMatricula(item.getMatricula()));
	}

}