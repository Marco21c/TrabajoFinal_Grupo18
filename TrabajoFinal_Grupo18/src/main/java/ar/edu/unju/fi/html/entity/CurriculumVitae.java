package ar.edu.unju.fi.html.entity;

public class CurriculumVitae {
private long id;
private String contacto;
private String expLaboral;
private String educacion;
private String idiomas;
private String conocimientoInfo;
private String infoComplementaria;
private Ciudadano ciudadanoId;

public CurriculumVitae() {
	
}

public CurriculumVitae(String contacto, String expLaboral, String educacion, String idiomas, String conocimientoInfo,
		String infoComplementaria) {
	super();
	this.contacto = contacto;
	this.expLaboral = expLaboral;
	this.educacion = educacion;
	this.idiomas = idiomas;
	this.conocimientoInfo = conocimientoInfo;
	this.infoComplementaria = infoComplementaria;
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
