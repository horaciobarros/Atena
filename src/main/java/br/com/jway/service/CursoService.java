package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Curso;

public interface CursoService extends Serializable {

	public void create(Curso curso);

	public void delete(Curso curso);

	public void update(Curso curso);

	public List<Curso> list();

	public void delete(long id);

	public Curso read(long id);

	public List<Curso> pesquisa(Curso curso);
}