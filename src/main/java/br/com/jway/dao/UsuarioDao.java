package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Usuario;

public interface UsuarioDao  {

	List<Usuario> list();

	Usuario read(long id);

	void create(Usuario usuario);

	Usuario update(Usuario usuario);

	void delete(Usuario usuario);

	void delete(long id);

	public List<Usuario> pesquisa(Usuario usuario);

	Usuario busca(Usuario usuarioLogado);

}