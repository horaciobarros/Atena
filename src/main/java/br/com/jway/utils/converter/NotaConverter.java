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

import br.com.jway.service.NotaService;
import br.com.jway.model.Nota;

@ManagedBean
@ViewScoped
@Named
public class NotaConverter implements Converter, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NotaService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("--")||value.contains("Escolha")){
			return null;
		}
		try {
			long id = Long.parseLong(value);
			Object object = service.read(id);
			System.out.println("Convertendo Nota");
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException("N�o foi poss�vel encontrar o Nota de id: " + value + ". " + e.getMessage());
		}
	
	
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if (value != null && value != "") {
			Nota nota = (Nota) value;
			System.out.println("ID: " + nota.getId());
			return nota.getId() + "";
		}
		return null;
	}
}