package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.TurmaDisciplina;

public interface TurmaDisciplinaService extends Serializable {

	public void create(TurmaDisciplina turmadisciplina);

	public void delete(TurmaDisciplina turmadisciplina);

	public void update(TurmaDisciplina turmadisciplina);

	public List<TurmaDisciplina> list();

	public void delete(long id);

	public TurmaDisciplina read(long id);

	public List<TurmaDisciplina> pesquisa(TurmaDisciplina turmadisciplina);
}