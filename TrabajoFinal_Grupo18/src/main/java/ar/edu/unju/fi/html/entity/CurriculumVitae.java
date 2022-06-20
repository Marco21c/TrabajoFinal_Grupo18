package ar.edu.unju.fi.html.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="curriculums")
public class CurriculumVitae {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
@Column(name="ID_CV")
private long id;
@Column(name="CONTACTO_CV")
private String contacto;
@Column(name="EXP_LABO_CV")
private String expLaboral;
@Column(name="EDUCACION_CV")
private String educacion;
@Column(name="IDIOMAS_CV")
private String idiomas;
@Column(name="CONOCIM_INFO_CV")
private String conocimientoInfo;
@Column(name="INFO_COMPLE_CV")
private String infoComplementaria;

@OneToOne(fetch= FetchType.LAZY)
@JoinColumn(name="DNI_CIU")
private Ciudadano ciudadanoId;

public CurriculumVitae() {
	
}

public CurriculumVitae(String contacto, String expLaboral, String educacion, String idiomas, String conocimientoInfo,
		String infoComplementaria, Ciudadano ciudadanoId) {
	super();
	this.contacto = contacto;
	this.expLaboral = expLaboral;
	this.educacion = educacion;
	this.idiomas = idiomas;
	this.conocimientoInfo = conocimientoInfo;
	this.infoComplementaria = infoComplementaria;
	this.ciudadanoId = ciudadanoId;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getContacto() {
	return contacto;
}
public void setContacto(String contacto) {
	this.contacto = contacto;
}
public String getExpLaboral() {
	return expLaboral;
}
public void setExpLaboral(String expLaboral) {
	this.expLaboral = expLaboral;
}
public String getEducacion() {
	return educacion;
}
public void setEducacion(String educacion) {
	this.educacion = educacion;
}
public String getIdiomas() {
	return idiomas;
}
public void setIdiomas(String idiomas) {
	this.idiomas = idiomas;
}
public String getConocimientoInfo() {
	return conocimientoInfo;
}
public void setConocimientoInfo(String conocimientoInfo) {
	this.conocimientoInfo = conocimientoInfo;
}
public String getInfoComplementaria() {
	return infoComplementaria;
}
public void setInfoComplementaria(String infoComplementaria) {
	this.infoComplementaria = infoComplementaria;
}
public Ciudadano getCiudadanoId() {
	return ciudadanoId;
}
public void setCiudadanoId(Ciudadano ciudadanoId) {
	this.ciudadanoId = ciudadanoId;
}


}
