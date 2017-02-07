package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Turma;

public interface TurmaService extends Serializable {

	public void create(Turma turma);

	public void delete(Turma turma);

	public void update(Turma turma);

	public List<Turma> list();

	public void delete(long id);

	public Turma read(long id);

	public List<Turma> pesquisa(Turma turma);
}