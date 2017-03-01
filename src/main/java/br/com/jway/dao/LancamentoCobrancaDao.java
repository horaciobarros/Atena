package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.LancamentoCobranca;

public interface LancamentoCobrancaDao {
	
	List<LancamentoCobranca> list();

	LancamentoCobranca read(long id);

	void create(LancamentoCobranca lc);

	LancamentoCobranca update(LancamentoCobranca lc);

	void delete(LancamentoCobranca lc);

	void delete(long id);

	public List<LancamentoCobranca> pesquisa(LancamentoCobranca lc);

	LancamentoCobranca findByMatricula(String lc);

}
