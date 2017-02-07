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
public  class TurmaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(TurmaBean.class);

	@Inject
	private TurmaService service;
	
	private String state;
	private List<Turma> items;
	private List<Curso> listaCurso;

	private Curso Curso;

	@Inject
	private CursoService cursoService;
	private List<Local> listaLocal;

	private Local Local;

	@Inject
	private LocalService localService;
	private List<Turno> listaTurno;

	private Turno Turno;

	@Inject
	private TurnoService turnoService;
	private Turma item;
	private Turma itemFilter;
	
	
	public TurmaBean() {
		log.info("Bean constructor called.");
		itemFilter = new Turma();
		limpaPesquisa();
		listaCurso = cursoService.list();
listaLocal = localService.list();
listaTurno = turnoService.list();
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
			item = Turma.class.newInstance();
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
	
	public List<Turma> getItems() {
		return items;
	}
	
	public void setItems(List<Turma> items) {
		this.items = items;
	}
	
	public Turma getItem() {
		return item;
	}
	
	public void setItem(Turma item) {
		this.item = item;
	}
	public Turma getItemFilter() {
		return itemFilter;
	}
	
	public void setItemFilter(Turma itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Curso> getListaCurso(){
		return listaCurso;
	}
	
	public void setListaCurso(List<Curso> listaCurso){
		this.listaCurso = listaCurso;
	}
	
	
	public Curso getCurso(){
		return Curso;
	}
	
	public void setCurso(Curso Curso){
		this.Curso = Curso;
	}
	public List<Local> getListaLocal(){
		return listaLocal;
	}
	
	public void setListaLocal(List<Local> listaLocal){
		this.listaLocal = listaLocal;
	}
	
	
	public Local getLocal(){
		return Local;
	}
	
	public void setLocal(Local Local){
		this.Local = Local;
	}
	public List<Turno> getListaTurno(){
		return listaTurno;
	}
	
	public void setListaTurno(List<Turno> listaTurno){
		this.listaTurno = listaTurno;
	}
	
	
	public Turno getTurno(){
		return Turno;
	}
	
	public void setTurno(Turno Turno){
		this.Turno = Turno;
	}

}