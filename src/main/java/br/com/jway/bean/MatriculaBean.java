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
import br.com.jway.util.Util;

@ManagedBean
@ViewScoped
public  class MatriculaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(MatriculaBean.class);

	@Inject
	private MatriculaService service;
	
	@Inject
	private AlunoService alunoService;
	
	@Inject
	private TurmaService turmaService;
	
	
	private String state;
	private List<Matricula> items;
	private List<Aluno> listaAluno;
	private List<Long> listaAnoLetivo;
	private List<Turma> listaTurma;

	private Matricula item;
	private Matricula itemFilter;
	
	
	public MatriculaBean() {
		log.info("Bean constructor called.");
		itemFilter = new Matricula();
		limpaPesquisa();
	}
	
	
	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
		listaAluno = alunoService.list();
		listaAnoLetivo = Util.listaAnoLetivo();
		listaTurma = turmaService.list();
	}
	
	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}
	
	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = Matricula.class.newInstance();
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
		items = service.pesquisa(itemFilter);
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
	
	public List<Matricula> getItems() {
		return items;
	}
	
	public void setItems(List<Matricula> items) {
		this.items = items;
	}
	
	public Matricula getItem() {
		return item;
	}
	
	public void setItem(Matricula item) {
		this.item = item;
	}
	public Matricula getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Matricula itemFilter) {
		this.itemFilter = itemFilter;
	}


	public List<Aluno> getListaAluno() {
		return listaAluno;
	}


	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}


	public List<Long> getListaAnoLetivo() {
		return listaAnoLetivo;
	}


	public void setListaAnoLetivo(List<Long> listaAnoLetivo) {
		this.listaAnoLetivo = listaAnoLetivo;
	}


	public List<Turma> getListaTurma() {
		return listaTurma;
	}


	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	
	
}