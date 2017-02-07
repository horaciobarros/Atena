package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Escola;

public interface EscolaService extends Serializable {

	public void create(Escola escola);

	public void delete(Escola escola);

	public void update(Escola escola);

	public List<Escola> list();

	public void delete(long id);

	public Escola read(long id);

	public List<Escola> pesquisa(Escola escola);
}