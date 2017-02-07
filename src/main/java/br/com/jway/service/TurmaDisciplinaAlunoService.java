package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.TurmaDisciplinaAluno;

public interface TurmaDisciplinaAlunoService extends Serializable {

	public void create(TurmaDisciplinaAluno turmadisciplinaaluno);

	public void delete(TurmaDisciplinaAluno turmadisciplinaaluno);

	public void update(TurmaDisciplinaAluno turmadisciplinaaluno);

	public List<TurmaDisciplinaAluno> list();

	public void delete(long id);

	public TurmaDisciplinaAluno read(long id);

	public List<TurmaDisciplinaAluno> pesquisa(TurmaDisciplinaAluno turmadisciplinaaluno);
}