package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Professor;

public interface ProfessorDao  {

	List<Professor> list();

	Professor read(long id);

	void create(Professor professor);

	Professor update(Professor professor);

	void delete(Professor professor);

	void delete(long id);

	public List<Professor> pesquisa(Professor professor);

}