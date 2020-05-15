package modelo.intermedias;

import modelo.almacen.Alimento;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Alimento_x_servicio {
	private Alimento nombre_alimento; //PK and FK
	private Servicio iIdSevicio; //PK and FK
	private Opinion opinion; //PK and FK
	
	public Alimento_x_servicio(Alimento nombre_alimento, Servicio iIdSevicio, Opinion opinion) {
		setiIdSevicio(iIdSevicio);
		setNombre_alimento(nombre_alimento);	
		setOpinion(opinion);
	}
	
	//Getters and Setters
	
	public Alimento getNombre_alimento() {
		return nombre_alimento;
	}
	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	private void setNombre_alimento(Alimento nombre_alimento) {
		this.nombre_alimento = nombre_alimento;
	}
	public Servicio getiIdSevicio() {
		return iIdSevicio;
	}
	private void setiIdSevicio(Servicio iIdSevicio) {
		this.iIdSevicio = iIdSevicio;
	}

	//----------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iIdSevicio == null) ? 0 : iIdSevicio.hashCode());
		result = prime * result + ((nombre_alimento == null) ? 0 : nombre_alimento.hashCode());
		result = prime * result + ((opinion == null) ? 0 : opinion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Alimento_x_servicio other = (Alimento_x_servicio) obj;
		if(this.iIdSevicio.equals(other.iIdSevicio) && this.nombre_alimento.equals(other.nombre_alimento)) {
		    bExito = true;
		}
		return bExito;
	}
}
