package modelo;

public class Alimento {
	private String sNombre_alimento; //PK
	private byte bCantidad; //NN
		
	public Alimento(String sNombre_alimento, byte bCantidad) {
		setbCantidad(bCantidad);
		setsNombre_alimento(sNombre_alimento);
	}

	//-------------------------------------------------------------------------------
	//Getters and Setters
	
	public String getsNombre_alimento() {
		return sNombre_alimento;
	}
	
	private boolean setsNombre_alimento(String sNombre_alimento) {
		boolean bExito=false;
		if(sNombre_alimento != null) {
			this.sNombre_alimento = sNombre_alimento;
		}
		return bExito;
	}
	
	public byte getbCantidad() {
		return bCantidad;
	}
	
	public boolean setbCantidad(byte bCantidad) {
		boolean bExito=false;
		if(bCantidad > -1) {
			this.bCantidad = bCantidad;
		}
		return bExito;
	}
	//-------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bCantidad;
		result = prime * result + ((sNombre_alimento == null) ? 0 : sNombre_alimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Alimento other = (Alimento) obj;
		if(this.sNombre_alimento.equals(other.sNombre_alimento)) {
		    bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		return "De "+getsNombre_alimento()+ " se necesita "+getbCantidad();
	}
	
	
	
}
