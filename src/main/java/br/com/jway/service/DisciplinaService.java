package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Disciplina;

public interface DisciplinaService extends Serializable {

	public void create(Disciplina disciplina);

	public void delete(Disciplina disciplina);

	public void update(Disciplina disciplina);

	public List<Disciplina> list();

	public void delete(long id);

	public Disciplina read(long id);

	public List<Disciplina> pesquisa(Disciplina disciplina);
}