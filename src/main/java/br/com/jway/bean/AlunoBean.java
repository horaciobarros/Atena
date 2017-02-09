package br.com.jway.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import br.com.jway.service.*;
import br.com.jway.model.*;
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

	private Pessoa Pessoa;

	@Inject
	private PessoaService pessoaService;
	private Aluno item;
	private Aluno itemFilter;

	private StreamedContent imagem;

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
		try {
			imagem = new DefaultStreamedContent(new ByteArrayInputStream(item.getPessoa().getFoto()));
		} catch (Exception e) {

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

	public Pessoa getPessoa() {
		return Pessoa;
	}

	public void setPessoa(Pessoa Pessoa) {
		this.Pessoa = Pessoa;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public void handleFileUpload(FileUploadEvent event) {
		
		try {
			imagem = new DefaultStreamedContent(event.getFile().getInputstream());
			byte[] foto = event.getFile().getContents();
			this.item.getPessoa().setFoto(foto);
		} catch (IOException ex) {
			System.out.println("Erro em evento de upload");
		}
	}

}