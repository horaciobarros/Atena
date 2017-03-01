package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.LancamentoCobranca;

public interface LancamentoCobrancaService extends Serializable {

	public void create(LancamentoCobranca lancamentoCobranca);

	public void delete(LancamentoCobranca lancamentoCobranca);

	public void update(LancamentoCobranca lancamentoCobranca);

	public List<LancamentoCobranca> list();

	public void delete(long id);

	public LancamentoCobranca read(long id);

	public List<LancamentoCobranca> pesquisa(LancamentoCobranca lancamentoCobranca);

}
