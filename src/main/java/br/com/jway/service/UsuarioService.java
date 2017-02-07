package br.com.jway.service; 

import java.io.Serializable;
import java.util.List;
import br.com.jway.model.Usuario;

public interface UsuarioService extends Serializable {

	public void create(Usuario usuario);

	public void delete(Usuario usuario);

	public void update(Usuario usuario);

	public List<Usuario> list();

	public void delete(long id);

	public Usuario read(long id);

	public List<Usuario> pesquisa(Usuario usuario);
}