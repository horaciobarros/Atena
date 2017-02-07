package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Frequencia;

public interface FrequenciaService extends Serializable {

	public void create(Frequencia frequencia);

	public void delete(Frequencia frequencia);

	public void update(Frequencia frequencia);

	public List<Frequencia> list();

	public void delete(long id);

	public Frequencia read(long id);

	public List<Frequencia> pesquisa(Frequencia frequencia);
}