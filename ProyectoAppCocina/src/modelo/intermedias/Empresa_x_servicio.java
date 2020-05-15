package modelo.intermedias;

import modelo.usuario.Empresa;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Empresa_x_servicio {
	private Empresa sCif; //PK and FK
	private Servicio iIdSevicio; //PK and FK
	private Opinion opinion; //PK and FK
	
	public Empresa_x_servicio(Empresa sCif, Servicio iIdSevicio,Opinion opinion) {
		setiIdSevicio(iIdSevicio);
		setsCif(sCif);
		setOpinion(opinion);
	}

	//Getters and setters
	
	public Empresa getsCif() {
		return sCif;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	public void setsCif(Empresa sCif) {
		this.sCif = sCif;
	}

	public Servicio getiIdSevicio() {
		return iIdSevicio;
	}

	public void setiIdSevicio(Servicio iIdSevicio) {
		this.iIdSevicio = iIdSevicio;
	}

	//----------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iIdSevicio == null) ? 0 : iIdSevicio.hashCode());
		result = prime * result + ((opinion == null) ? 0 : opinion.hashCode());
		result = prime * result + ((sCif == null) ? 0 : sCif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Empresa_x_servicio other = (Empresa_x_servicio) obj;
		if(this.iIdSevicio.equals(other.iIdSevicio) && this.sCif.equals(other.sCif)) {
		    bExito = true;
		}
		return bExito;
	}
	
	
}
