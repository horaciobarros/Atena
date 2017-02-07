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

import br.com.jway.service.HorarioTurmaDisciplinaService;
import br.com.jway.model.HorarioTurmaDisciplina;

@ManagedBean
@ViewScoped
@Named
public class HorarioTurmaDisciplinaConverter implements Converter, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HorarioTurmaDisciplinaService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.contains("--")||value.contains("Escolha")){
			return null;
		}
		try {
			long id = Long.parseLong(value);
			Object object = service.read(id);
			System.out.println("Convertendo HorarioTurmaDisciplina");
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException("Não foi possível encontrar o HorarioTurmaDisciplina de id: " + value + ". " + e.getMessage());
		}
	
	
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if (value != null && value != "") {
			HorarioTurmaDisciplina horarioturmadisciplina = (HorarioTurmaDisciplina) value;
			System.out.println("ID: " + horarioturmadisciplina.getId());
			return horarioturmadisciplina.getId() + "";
		}
		return null;
	}
}