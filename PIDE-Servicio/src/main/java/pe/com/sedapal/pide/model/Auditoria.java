package pe.com.sedapal.pide.model;

import java.io.Serializable;
import java.sql.Timestamp;

import pe.com.sedapal.pide.model.base.Base;

public class Auditoria extends Base implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Integer idConsulta;
	Integer idServicio;
	String desServicio;
	String apPaterno;
	String apMaterno;
	String nombres;
	Integer nroFicha;
	String datosConsulta;
	Timestamp fecHorConsulta;
	String fecHorConsultaString;
	String hostConsulta;
	
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getDesServicio() {
		return desServicio;
	}
	public void setDesServicio(String desServicio) {
		this.desServicio = desServicio;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Integer getNroFicha() {
		return nroFicha;
	}
	public void setNroFicha(Integer nroFicha) {
		this.nroFicha = nroFicha;
	}
	public String getDatosConsulta() {
		return datosConsulta;
	}
	public void setDatosConsulta(String datosConsulta) {
		this.datosConsulta = datosConsulta;
	}
	public Timestamp getFecHorConsulta() {
		return fecHorConsulta;
	}
	public void setFecHorConsulta(Timestamp fecHorConsulta) {
		this.fecHorConsulta = fecHorConsulta;
	}
	public String getFecHorConsultaString() {
		return fecHorConsultaString;
	}
	public void setFecHorConsultaString(String fecHorConsultaString) {
		this.fecHorConsultaString = fecHorConsultaString;
	}
	public String getHostConsulta() {
		return hostConsulta;
	}
	public void setHostConsulta(String hostConsulta) {
		this.hostConsulta = hostConsulta;
	}
	
}
