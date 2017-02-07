package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Turno;

public interface TurnoService extends Serializable {

	public void create(Turno turno);

	public void delete(Turno turno);

	public void update(Turno turno);

	public List<Turno> list();

	public void delete(long id);

	public Turno read(long id);

	public List<Turno> pesquisa(Turno turno);
}