package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.HorarioTurmaDisciplina;

public interface HorarioTurmaDisciplinaDao  {

	List<HorarioTurmaDisciplina> list();

	HorarioTurmaDisciplina read(long id);

	void create(HorarioTurmaDisciplina horarioturmadisciplina);

	HorarioTurmaDisciplina update(HorarioTurmaDisciplina horarioturmadisciplina);

	void delete(HorarioTurmaDisciplina horarioturmadisciplina);

	void delete(long id);

	public List<HorarioTurmaDisciplina> pesquisa(HorarioTurmaDisciplina horarioturmadisciplina);

}