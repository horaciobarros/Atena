package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.HorarioTurmaDisciplina;

public interface HorarioTurmaDisciplinaService extends Serializable {

	public void create(HorarioTurmaDisciplina horarioturmadisciplina);

	public void delete(HorarioTurmaDisciplina horarioturmadisciplina);

	public void update(HorarioTurmaDisciplina horarioturmadisciplina);

	public List<HorarioTurmaDisciplina> list();

	public void delete(long id);

	public HorarioTurmaDisciplina read(long id);

	public List<HorarioTurmaDisciplina> pesquisa(HorarioTurmaDisciplina horarioturmadisciplina);
}