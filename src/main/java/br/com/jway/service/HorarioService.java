package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Horario;

public interface HorarioService extends Serializable {

	public void create(Horario horario);

	public void delete(Horario horario);

	public void update(Horario horario);

	public List<Horario> list();

	public void delete(long id);

	public Horario read(long id);

	public List<Horario> pesquisa(Horario horario);
}