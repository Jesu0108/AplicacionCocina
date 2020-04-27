package modelo;

public class Tipo_material {
	private String sNombre_tipo_material; //PK
	private int iCalidad; //NN
	
	
	public Tipo_material(String sNombre_tipo_material, int iCalidad) {
		setsNombre_tipo_material(sNombre_tipo_material);
		setiCalidad(iCalidad);
	}

	//---------------------------------------------------------
	//Getters and Setters
	public String getsNombre_tipo_material() {
		return sNombre_tipo_material;
	}
	
	
	private boolean setsNombre_tipo_material(String sNombre_tipo_material) {
		boolean bExito=false;
		if(sNombre_tipo_material != null) {
			this.sNombre_tipo_material = sNombre_tipo_material;
			bExito=true;
		}
		return bExito;
	}
	
	
	public int getiCalidad() {
		return iCalidad;
	}
	
	
	public boolean setiCalidad(int iCalidad) {
		boolean bExito=false;
		if(iCalidad > -1) {
			this.iCalidad = iCalidad;
			bExito=true;
		}
		return bExito;
	}
	//---------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iCalidad;
		result = prime * result + ((sNombre_tipo_material == null) ? 0 : sNombre_tipo_material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Tipo_material other = (Tipo_material) obj;
		if(this.sNombre_tipo_material.equals(other.sNombre_tipo_material)) {
		    bExito = true;
		}
		return bExito;
	}
	
	
}
