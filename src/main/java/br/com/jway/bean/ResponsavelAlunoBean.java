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
public  class ResponsavelAlunoBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(ResponsavelAlunoBean.class);

	@Inject
	private ResponsavelAlunoService service;
	
	private String state;
	private List<ResponsavelAluno> items;
	private List<Aluno> listaAluno;

	private Aluno Aluno;

	@Inject
	private AlunoService alunoService;
	private List<Responsavel> listaResponsavel;

	private Responsavel Responsavel;

	@Inject
	private ResponsavelService responsavelService;
	private ResponsavelAluno item;
	private ResponsavelAluno itemFilter;
	
	
	public ResponsavelAlunoBean() {
		log.info("Bean constructor called.");
		itemFilter = new ResponsavelAluno();
		limpaPesquisa();
		listaAluno = alunoService.list();
listaResponsavel = responsavelService.list();
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
			item = ResponsavelAluno.class.newInstance();
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
	
	public List<ResponsavelAluno> getItems() {
		return items;
	}
	
	public void setItems(List<ResponsavelAluno> items) {
		this.items = items;
	}
	
	public ResponsavelAluno getItem() {
		return item;
	}
	
	public void setItem(ResponsavelAluno item) {
		this.item = item;
	}
	public ResponsavelAluno getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(ResponsavelAluno itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Aluno> getListaAluno(){
		return listaAluno;
	}
	
	public void setListaAluno(List<Aluno> listaAluno){
		this.listaAluno = listaAluno;
	}
	
	
	public Aluno getAluno(){
		return Aluno;
	}
	
	public void setAluno(Aluno Aluno){
		this.Aluno = Aluno;
	}
	public List<Responsavel> getListaResponsavel(){
		return listaResponsavel;
	}
	
	public void setListaResponsavel(List<Responsavel> listaResponsavel){
		this.listaResponsavel = listaResponsavel;
	}
	
	
	public Responsavel getResponsavel(){
		return Responsavel;
	}
	
	public void setResponsavel(Responsavel Responsavel){
		this.Responsavel = Responsavel;
	}

}