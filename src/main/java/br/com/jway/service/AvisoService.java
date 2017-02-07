package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Aviso;

public interface AvisoService extends Serializable {

	public void create(Aviso aviso);

	public void delete(Aviso aviso);

	public void update(Aviso aviso);

	public List<Aviso> list();

	public void delete(long id);

	public Aviso read(long id);

	public List<Aviso> pesquisa(Aviso aviso);
}