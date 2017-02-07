package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.ResponsavelAluno;

public interface ResponsavelAlunoService extends Serializable {

	public void create(ResponsavelAluno responsavelaluno);

	public void delete(ResponsavelAluno responsavelaluno);

	public void update(ResponsavelAluno responsavelaluno);

	public List<ResponsavelAluno> list();

	public void delete(long id);

	public ResponsavelAluno read(long id);

	public List<ResponsavelAluno> pesquisa(ResponsavelAluno responsavelaluno);
}