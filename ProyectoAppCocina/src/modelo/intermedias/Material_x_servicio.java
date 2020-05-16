package modelo.intermedias;

import modelo.almacen.Material;
import modelo.usuario.Servicio;

public class Material_x_servicio {
	private Material nombre_material; //PK and FK
	private Servicio id_servicio;//PK and FK
	
	public Material_x_servicio(Material nombre_material, Servicio id_servicio ) {
		setId_servicio(id_servicio);
		setNombre_material(nombre_material);
	}
	
	//Getters and Setters
	
	public Material getNombre_material() {
		return nombre_material;
	}

	private void setNombre_material(Material nombre_material) {
		this.nombre_material = nombre_material;
	}
	public Servicio getId_servicio() {
		return id_servicio;
	}
	private void setId_servicio(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

	//---------------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_servicio == null) ? 0 : id_servicio.hashCode());
		result = prime * result + ((nombre_material == null) ? 0 : nombre_material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Material_x_servicio other = (Material_x_servicio) obj;
		if(this.id_servicio==other.id_servicio && this.nombre_material==other.nombre_material) {
		    bExito = true;
		}
		return bExito;
	}

	
	
	
}
