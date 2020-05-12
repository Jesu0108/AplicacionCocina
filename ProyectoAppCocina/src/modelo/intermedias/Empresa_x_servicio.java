package modelo.intermedias;

import modelo.usuario.Empresa;
import modelo.usuario.Servicio;

public class Empresa_x_servicio {
	private Empresa sCif; //PK and FK
	private Servicio iIdSevicio; //PK and FK
	
	public Empresa_x_servicio(Empresa sCif, Servicio iIdSevicio) {
		setiIdSevicio(iIdSevicio);
		setsCif(sCif);
	}

	public Empresa getsCif() {
		return sCif;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iIdSevicio == null) ? 0 : iIdSevicio.hashCode());
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
	
	//----------------------------------------------------------------------------------

	
	
}
