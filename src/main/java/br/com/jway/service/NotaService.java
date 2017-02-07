package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Nota;

public interface NotaService extends Serializable {

	public void create(Nota nota);

	public void delete(Nota nota);

	public void update(Nota nota);

	public List<Nota> list();

	public void delete(long id);

	public Nota read(long id);

	public List<Nota> pesquisa(Nota nota);
}