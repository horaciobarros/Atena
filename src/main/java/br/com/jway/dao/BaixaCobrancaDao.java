package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.BaixaCobranca;

public interface BaixaCobrancaDao {
	
	List<BaixaCobranca> list();

	BaixaCobranca read(long id);

	void create(BaixaCobranca bc);

	BaixaCobranca update(BaixaCobranca bc);

	void delete(BaixaCobranca bc);

	void delete(long id);

	public List<BaixaCobranca> pesquisa(BaixaCobranca bc);

}
