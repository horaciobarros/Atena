package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Advertencia;

public interface AdvertenciaService extends Serializable {

	public void create(Advertencia advertencia);

	public void delete(Advertencia advertencia);

	public void update(Advertencia advertencia);

	public List<Advertencia> list();

	public void delete(long id);

	public Advertencia read(long id);

	public List<Advertencia> pesquisa(Advertencia advertencia);
}