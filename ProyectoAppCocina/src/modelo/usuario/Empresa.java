package modelo.usuario;

public class Empresa extends Persona implements IEmpresa{
	private String sCif; //PK
	private String sDomilio,sCiudad;
	private String sNombre,sTelefono; //NN
		
	public Empresa(String sCif, String sDomilio, String sCiudad, String sNombre, 
			String sTelefono, String sEmail, String sContrasenia, String sApellidos) {
		
		super(sEmail, sContrasenia, sCiudad, sNombre, sApellidos, sTelefono, sCiudad);
		setsCif(sCif);
		setsDomilio(sDomilio);
		setsCiudad(sCiudad);
		setsNombre(sNombre);
		setsTelefono(sTelefono);
	}
	
	public Empresa(String sEmail, String sContrasenia) {
		super(sEmail,sContrasenia);
	}
	
	
	//Constructor solo con PK
	public Empresa(String sCif) {
		super(sCif);
		setsCif(sCif);
	}
	
	//Getters and Setters
	
	@Override
	public String getsCif() {
		return sCif;
	}
	
	private boolean setsCif(String sCif) {
		boolean bExito=false;
		if(sCif != null) {
			this.sCif = sCif;
			bExito = true;
		}
		return bExito;	
	}
	
	@Override
	public String getsDomilio() {
		return sDomilio;
	}
	
	@Override
	public boolean setsDomilio(String sDomilio) {
		boolean bExito=false;
		if(sDomilio != null) {
			this.sDomilio = sDomilio;
			bExito = true;
		}
		return bExito;	
	}
	
	@Override
	public String getsCiudad() {
		return sCiudad;
	}
	
	@Override
	public boolean setsCiudad(String sCiudad) {
		boolean bExito=false;
		if(sCiudad != null) {
			this.sCiudad = sCiudad;
			bExito = true;
		}
		return bExito;	
	}
	
	@Override
	public String getsNombre() {
		return sNombre;
	}
	
	@Override
	public boolean setsNombre(String sNombre) {
		boolean bExito=false;
		if(sNombre != null) {
			this.sNombre = sNombre;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String getsTelefono() {
		return sTelefono;
	}
	
	@Override
	public boolean setsTelefono(String sTelefono) {
		boolean bExito=false;
		if(sTelefono != null) {
			this.sTelefono = sTelefono;
			bExito = true;
		}
		return bExito;
	}

	
	//----------------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sCif == null) ? 0 : sCif.hashCode());
		result = prime * result + ((sCiudad == null) ? 0 : sCiudad.hashCode());
		result = prime * result + ((sDomilio == null) ? 0 : sDomilio.hashCode());
		result = prime * result + ((sNombre == null) ? 0 : sNombre.hashCode());
		result = prime * result + ((sTelefono == null) ? 0 : sTelefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Empresa other = (Empresa) obj;
		if(this.sCif.equals(other.sCif)) {
		    bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado="";
		sResultado+="Nombre de la empresa: "+getsNombre()+"\n";
		sResultado+="Con telefono: "+getsTelefono()+"\n";
		sResultado+="En la ciudad de: "+getsCiudad()+"\n";
		sResultado+="Y nombre domicilio : "+getsDomilio()+"\n";
		sResultado+="Con CIF: "+getsCif();
		return sResultado;
	}
	
}
