package modelo.usuario;

public class Tipo_servicio implements ITipo_servicio{
	private String sNombre_tipo_servicio; //PK
	private int iCalidad; //NN
	
	
	public Tipo_servicio(String sNombre_tipo_servicio, int iCalidad) {
		setiCalidad(iCalidad);
		setsNombre_tipo_servicio(sNombre_tipo_servicio);
	}
	
	//Getters and Setters
	
	@Override
	public String getsNombre_tipo_servicio() {
		return sNombre_tipo_servicio;
	}
	
	private boolean setsNombre_tipo_servicio(String sNombre_tipo_servicio) {
		boolean bExito=false;
		if(sNombre_tipo_servicio != null) {
			this.sNombre_tipo_servicio = sNombre_tipo_servicio;
			bExito = true;
		}
		return bExito;
		
	}
	
	@Override
	public int getiCalidad() {
		return iCalidad;
	}
	
	@Override
	public boolean setiCalidad(int iCalidad) {
		boolean bExito=false;
		if(iCalidad > -1) {
			this.iCalidad = iCalidad;
			bExito = true;
		}
		return bExito;
	}

	//----------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iCalidad;
		result = prime * result + ((sNombre_tipo_servicio == null) ? 0 : sNombre_tipo_servicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Tipo_servicio other = (Tipo_servicio) obj;
		if(this.sNombre_tipo_servicio.equals(other.sNombre_tipo_servicio)) {
		    bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado="";
		sResultado+="Servicio: "+getsNombre_tipo_servicio()+"\n";
		sResultado+="Calidad: "+getiCalidad();
		return sResultado;
	}
	
	
	
	
}
