package br.com.jway.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import br.com.jway.service.*;
import br.com.jway.model.*;
import br.com.jway.util.FacesUtils;
import br.com.jway.util.Util;

@ManagedBean
@ViewScoped
public class MatriculaBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(MatriculaBean.class);

	@Inject
	private MatriculaService service;

	@Inject
	private AlunoService alunoService;

	@Inject
	private TurmaService turmaService;

	@Inject
	private ServicoService servicoService;

	@Inject
	private ServicoMatriculaService servicoMatriculaService;

	private String state;
	private List<Matricula> items;
	private List<Aluno> listaAluno;
	private List<Long> listaAnoLetivo;
	private List<Turma> listaTurma;
	private List<Servico> listaServico;
	private ServicoMatricula servicoMatricula;
	private Servico servico;
	private ServicoMatricula servicoMatriculaRemove;

	private Matricula item;
	private Matricula itemFilter;

	private Integer percentualDesconto;
	private BigDecimal valorMatricula;

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
		listaServico = servicoService.list();
		servicoMatricula = new ServicoMatricula();
		servicoMatricula.setServico(new Servico());
		servico = new Servico();
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

	@Transactional(propagation = Propagation.REQUIRED)
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
		items = service.pesquisa(itemFilter);
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
		atualizaValorMatricula();
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

	public void incluirServico() {
		if (servico.getId() != null) {
			if (item.getServicoMatriculaList() == null) {
				item.setServicoMatriculaList(new ArrayList<ServicoMatricula>());
			}
			servicoMatricula.setMatricula(item);
			servicoMatricula = new ServicoMatricula();
			servicoMatricula.setServico(servico);
			servicoMatricula.setPercDesconto(percentualDesconto);
			item.getServicoMatriculaList().add(servicoMatricula);
			servico = new Servico();
			percentualDesconto = null;
			atualizaValorMatricula();

		}

	}

	private void atualizaValorMatricula() {
		valorMatricula = service.getValorLiquidoMatricula(item);
		

	}

	public List<Servico> getListaServico() {
		return listaServico;
	}

	public void setListaServico(List<Servico> listaServico) {
		this.listaServico = listaServico;
	}

	public ServicoMatricula getServicoMatricula() {
		return servicoMatricula;
	}

	public void setServicoMatricula(ServicoMatricula servicoMatricula) {
		this.servicoMatricula = servicoMatricula;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public ServicoMatricula getServicoMatriculaRemove() {
		return servicoMatriculaRemove;
	}

	public void setServicoMatriculaRemove(ServicoMatricula servicoMatriculaRemove) {
		this.servicoMatriculaRemove = servicoMatriculaRemove;
	}

	public void removeServicoMatricula() {
		item.getServicoMatriculaList().remove(servicoMatriculaRemove);
		if (item.getServicoMatriculaListToRemove() == null) {
			item.setServicoMatriculaListToRemove(new ArrayList<ServicoMatricula>());
		}
		item.getServicoMatriculaListToRemove().add(servicoMatriculaRemove);
		atualizaValorMatricula();
	}

	public Integer getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Integer percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

}