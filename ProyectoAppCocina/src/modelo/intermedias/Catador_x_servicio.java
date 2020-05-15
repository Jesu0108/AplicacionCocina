package modelo.intermedias;

import modelo.usuario.Catador;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Catador_x_servicio {
	private Catador email; // PK and FK
	private Servicio id_servicio; // PK and FK
	private Opinion opinion; // PK and FK

	public Catador_x_servicio(Catador email, Servicio id_servicio, Opinion opinion) {
		setEmail(email);
		setId_servicio(id_servicio);
		setOpinion(opinion);
	}

	// Getters and Setters
	
	public Catador getEmail() {
		return email;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	private void setEmail(Catador email) {
		this.email = email;
	}

	public Servicio getId_servicio() {
		return id_servicio;
	}

	private void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

	// -----------------------------------------------------------------------------

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
		Catador_x_servicio other = (Catador_x_servicio) obj;
		if (this.email.equals(other.email) && this.id_servicio.equals(other.id_servicio)) {
			bExito = true;
		}
		return bExito;
	}

}
