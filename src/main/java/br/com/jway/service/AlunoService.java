package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Aluno;

public interface AlunoService extends Serializable {

	public void create(Aluno aluno);

	public void delete(Aluno aluno);

	public void update(Aluno aluno);

	public List<Aluno> list();

	public void delete(long id);

	public Aluno read(long id);

	public List<Aluno> pesquisa(Aluno aluno);
	
	public Aluno findByMatricula(String matricula);
}