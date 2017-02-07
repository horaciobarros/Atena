package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Local;

public interface LocalService extends Serializable {

	public void create(Local local);

	public void delete(Local local);

	public void update(Local local);

	public List<Local> list();

	public void delete(long id);

	public Local read(long id);

	public List<Local> pesquisa(Local local);
}