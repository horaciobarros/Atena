package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Professor;

public interface ProfessorService extends Serializable {

	public void create(Professor professor);

	public void delete(Professor professor);

	public void update(Professor professor);

	public List<Professor> list();

	public void delete(long id);

	public Professor read(long id);

	public List<Professor> pesquisa(Professor professor);
}