package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Usuario;
import br.com.jway.dao.UsuarioDao;
import br.com.jway.service.UsuarioService;

@Named
public class UsuarioServiceImpl implements UsuarioService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private UsuarioDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Usuario usuario){
		dao.create(usuario);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Usuario usuario){
		dao.delete(usuario);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Usuario usuario){
		dao.update(usuario);
	}
	@Override
	public Usuario read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Usuario> list(){
		return dao.list();
 	}
	@Override
	public List<Usuario> pesquisa(Usuario usuario){
		return dao.pesquisa(usuario);
 	}
}