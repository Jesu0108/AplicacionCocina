package modelo;

public class Material implements IMaterial{
	private String sNombre_material; //PK
	private Tipo_material oNombre_tipo_material; //FK

	public Material(String sNombre_material, Tipo_material oNombre_tipo_material) {
		setsNombre_material(sNombre_material);
		setoNombre_tipo_material(oNombre_tipo_material);
	}

	//----------------------------------------------------------
	//Getters and Setters
	
	@Override
	public String getsNombre_material() {
		return sNombre_material;
	}

	private boolean setsNombre_material(String sNombre_material) {
		boolean bExito=false;
		if(sNombre_material != null) {
			this.sNombre_material = sNombre_material;
			bExito = true;
		}
		return bExito;
		
	}

	@Override
	public Tipo_material getoNombre_tipo_material() {
		return oNombre_tipo_material;
	}

	@Override
	public boolean setoNombre_tipo_material(Tipo_material oNombre_tipo_material) {
		boolean bExito=false;
		if(oNombre_tipo_material != null) {
			this.oNombre_tipo_material = oNombre_tipo_material;
			bExito = true;
		}
		return bExito;
	}
	
	//----------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oNombre_tipo_material == null) ? 0 : oNombre_tipo_material.hashCode());
		result = prime * result + ((sNombre_material == null) ? 0 : sNombre_material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Material other = (Material) obj;
		if(this.sNombre_material.equals(other.sNombre_material)) {
		    bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		return "Material "+getsNombre_material()+" de tipo "+getoNombre_tipo_material();
	}
	
	
}
