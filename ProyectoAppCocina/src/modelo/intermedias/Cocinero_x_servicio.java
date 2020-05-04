package modelo.intermedias;

import modelo.usuario.Cocinero;
import modelo.usuario.Servicio;

public class Cocinero_x_servicio {
	private Cocinero email; //PK and FK
	private Servicio id_servicio; //PK and FK
	
	public Cocinero_x_servicio(Cocinero email, Servicio id_servicio) {
		setEmail(email);
		setId_servicio(id_servicio);
	}
	
	//Getters and Setters
	
	public Cocinero getEmail() {
		return email;
	}
	
	private void setEmail(Cocinero email) {
		this.email = email;
	}
	
	public Servicio getId_servicio() {
		return id_servicio;
	}
	
	private void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

	//-----------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_servicio == null) ? 0 : id_servicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Cocinero_x_servicio other = (Cocinero_x_servicio) obj;
		if(this.email.equals(other.email) && this.id_servicio.equals(other.id_servicio)) {
		    bExito = true;
		}
		return bExito;
	}
	
	
	
}
