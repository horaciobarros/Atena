package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Etapa;

public interface EtapaService extends Serializable {

	public void create(Etapa etapa);

	public void delete(Etapa etapa);

	public void update(Etapa etapa);

	public List<Etapa> list();

	public void delete(long id);

	public Etapa read(long id);

	public List<Etapa> pesquisa(Etapa etapa);
}