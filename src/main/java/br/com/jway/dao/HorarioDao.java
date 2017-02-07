package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Horario;

public interface HorarioDao  {

	List<Horario> list();

	Horario read(long id);

	void create(Horario horario);

	Horario update(Horario horario);

	void delete(Horario horario);

	void delete(long id);

	public List<Horario> pesquisa(Horario horario);

}