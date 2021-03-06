package br.com.jway.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.jway.model.Aluno;
import br.com.jway.model.Cidade;
import br.com.jway.model.Pessoa;
import br.com.jway.model.Uf;
import br.com.jway.service.AlunoService;
import br.com.jway.service.CidadeService;
import br.com.jway.service.PessoaService;
import br.com.jway.service.UfService;
import br.com.jway.util.FacesUtils;

@ManagedBean
@SessionScoped
public class AlunoBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(AlunoBean.class);

	@Inject
	private AlunoService service;

	private String state;
	private List<Aluno> items;
	private List<Pessoa> listaPessoa;
	private List<Uf> ufs;
	private List<Cidade> cidades;

	@Inject
	private PessoaService pessoaService;
	@Inject
	private UfService ufService;
	@Inject
	private CidadeService cidadeService;
	
	private Aluno item;
	private Aluno itemFilter;

	public AlunoBean() {
		log.info("Bean constructor called.");
		itemFilter = new Aluno();
		itemFilter.setPessoa(new Pessoa());
		limpaPesquisa();
	}

	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = service.list();
		listaPessoa = pessoaService.list();
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
			item = Aluno.class.newInstance();
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

	public List<Aluno> getItems() {
		return items;
	}

	public void setItems(List<Aluno> items) {
		this.items = items;
	}

	public Aluno getItem() {
		if (item.getPessoa() == null) {
			item.setPessoa(new Pessoa());
		}
		return item;
	}

	public void setItem(Aluno item) {
		this.item = item;
	}

	public Aluno getItemFilter() {
		if (itemFilter.getPessoa() == null) {
			itemFilter.setPessoa(new Pessoa());
		}
		return itemFilter;
	}

	public void setItemFilter(Aluno itemFilter) {
		this.itemFilter = itemFilter;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public StreamedContent getImagem() {
		if (item.getPessoa() != null && item.getPessoa().getFoto() != null) {
			return new DefaultStreamedContent(new ByteArrayInputStream(item.getPessoa().getFoto()), "image/png");
		} else {
			return new DefaultStreamedContent();
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			this.item.getPessoa().setFoto(foto);
		} catch (IOException ex) {
			System.out.println("Erro em evento de upload");
		}
	}

	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}
	
	public void refreshUf() {
		cidades = cidadeService.findByUf(item.getPessoa().getUf());
		
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
	
	

}