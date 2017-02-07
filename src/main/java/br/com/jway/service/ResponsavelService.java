package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Responsavel;

public interface ResponsavelService extends Serializable {

	public void create(Responsavel responsavel);

	public void delete(Responsavel responsavel);

	public void update(Responsavel responsavel);

	public List<Responsavel> list();

	public void delete(long id);

	public Responsavel read(long id);

	public List<Responsavel> pesquisa(Responsavel responsavel);
}