package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.BaixaCobranca;

public interface BaixaCobrancaService extends Serializable {

	public void create(BaixaCobranca bc);

	public void delete(BaixaCobranca bc);

	public void update(BaixaCobranca bc);

	public List<BaixaCobranca> list();

	public void delete(long id);

	public BaixaCobranca read(long id);

	public List<BaixaCobranca> pesquisa(BaixaCobranca bc);
}
