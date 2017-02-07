package br.com.jway.utils.converter; 

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jway.service.UsuarioService;
import br.com.jway.model.Usuario;

@ManagedBean
@ViewScoped
@Named
public class UsuarioConverter implements Converter, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("--")||value.contains("Escolha")){
			return null;
		}
		try {
			long id = Long.parseLong(value);
			Object object = service.read(id);
			System.out.println("Convertendo Usuario");
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException("Não foi possível encontrar o Usuario de id: " + value + ". " + e.getMessage());
		}
	
	
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if (value != null && value != "") {
			Usuario usuario = (Usuario) value;
			System.out.println("ID: " + usuario.getId());
			return usuario.getId() + "";
		}
		return null;
	}
}