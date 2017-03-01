package br.com.jway.model; 

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="turno")
public class Turno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="descricao")
	private String descricao;

	@Column(name="tenancy")
	private Long tenancy;
	
	@Column(name="hora_inicio_turno")
	private String horaInicioTurno;
	
	@Column(name="horario_antecessor_ao_intervalo")
	private String horarioAntecessorAoIntervalo;
	
	@Column(name="duracao_aula")
	private Long duracaoAulaMinutos;
	
	@Column(name="total_horarios")
	private Long totalHorarios;
	
	@Column(name="duracao_intervalo")
	private Long duracaoIntervalo;
	
	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getCodigo() { 
		return codigo;
	}
	public void  setCodigo(String codigo) { 
		this.codigo = codigo;
	}

	public String getDescricao() { 
		return descricao;
	}
	public void  setDescricao(String descricao) { 
		this.descricao = descricao;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((duracaoAulaMinutos == null) ? 0 : duracaoAulaMinutos.hashCode());
		result = prime * result + ((duracaoIntervalo == null) ? 0 : duracaoIntervalo.hashCode());
		result = prime * result + ((horaInicioTurno == null) ? 0 : horaInicioTurno.hashCode());
		result = prime * result
				+ ((horarioAntecessorAoIntervalo == null) ? 0 : horarioAntecessorAoIntervalo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
		result = prime * result + ((totalHorarios == null) ? 0 : totalHorarios.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (duracaoAulaMinutos == null) {
			if (other.duracaoAulaMinutos != null)
				return false;
		} else if (!duracaoAulaMinutos.equals(other.duracaoAulaMinutos))
			return false;
		if (duracaoIntervalo == null) {
			if (other.duracaoIntervalo != null)
				return false;
		} else if (!duracaoIntervalo.equals(other.duracaoIntervalo))
			return false;
		if (horaInicioTurno == null) {
			if (other.horaInicioTurno != null)
				return false;
		} else if (!horaInicioTurno.equals(other.horaInicioTurno))
			return false;
		if (horarioAntecessorAoIntervalo == null) {
			if (other.horarioAntecessorAoIntervalo != null)
				return false;
		} else if (!horarioAntecessorAoIntervalo.equals(other.horarioAntecessorAoIntervalo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		if (totalHorarios == null) {
			if (other.totalHorarios != null)
				return false;
		} else if (!totalHorarios.equals(other.totalHorarios))
			return false;
		return true;
	}
	public String getHoraInicioTurno() {
		return horaInicioTurno;
	}
	public void setHoraInicioTurno(String horaInicioTurno) {
		this.horaInicioTurno = horaInicioTurno;
	}
	public String getHorarioAntecessorAoIntervalo() {
		return horarioAntecessorAoIntervalo;
	}
	public void setHorarioAntecessorAoIntervalo(String horarioAntecessorAoIntervalo) {
		this.horarioAntecessorAoIntervalo = horarioAntecessorAoIntervalo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getDuracaoAulaMinutos() {
		return duracaoAulaMinutos;
	}
	public void setDuracaoAulaMinutos(Long duracaoAulaMinutos) {
		this.duracaoAulaMinutos = duracaoAulaMinutos;
	}
	public Long getTotalHorarios() {
		return totalHorarios;
	}
	public void setTotalHorarios(Long totalHorarios) {
		this.totalHorarios = totalHorarios;
	}
	public Long getDuracaoIntervalo() {
		return duracaoIntervalo;
	}
	public void setDuracaoIntervalo(Long duracaoIntervalo) {
		this.duracaoIntervalo = duracaoIntervalo;
	}
	
	
	
	
	
}