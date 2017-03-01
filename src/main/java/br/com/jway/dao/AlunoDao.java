package br.com.jway.dao; 

import java.util.*;

import br.com.jway.model.Aluno;

public interface AlunoDao  {

	List<Aluno> list();

	Aluno read(long id);

	void create(Aluno aluno);

	Aluno update(Aluno aluno);

	void delete(Aluno aluno);

	void delete(long id);

	public List<Aluno> pesquisa(Aluno aluno);

	Aluno findByMatricula(String matricula);

}