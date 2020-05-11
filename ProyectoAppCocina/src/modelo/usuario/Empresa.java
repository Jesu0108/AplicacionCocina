package modelo.usuario;

public class Empresa extends Persona implements IEmpresa{
	private String sCif; //PK
	private String sDomilio;
		
	public Empresa(String sCif, String sDomilio, String sCiudad, String sNombre, 
			String sTelefono, String sEmail, String sContrasenia, String sApellidos,String sExperencia) {
		
		super(sEmail, sContrasenia, sCiudad, sNombre, sApellidos, sTelefono, sExperencia);
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
	
	
	//----------------------------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sCif == null) ? 0 : sCif.hashCode());
		result = prime * result + ((sDomilio == null) ? 0 : sDomilio.hashCode());
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
