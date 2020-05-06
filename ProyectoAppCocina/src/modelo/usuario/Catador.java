package modelo.usuario;

public class Catador extends Persona implements ICatador{
	
	private byte bCriterio;

	public Catador(String sEmail, String sContrasenia, String sNombre, String sApellidos, String sTelefono,
			String sExperiencia, String sCiudad, byte bCriterio) {
		super(sEmail, sContrasenia, sCiudad, sNombre, sApellidos, sTelefono, sCiudad);
		setCriterio(bCriterio);
	}
	
	public Catador(String sEmail, byte bCriterio) {
		super(sEmail);
		setCriterio(bCriterio);
	}
	
	public Catador(String sEmail) {
		super(sEmail);
	}
	
	//Getters and Setters
	
	@Override
	public byte getCriterio() {
		return bCriterio;
	}

	@Override
	public boolean setCriterio(byte bCriterio) {
		boolean bExito = false;
		if(bCriterio > -1) {
			this.bCriterio = bCriterio;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String toString() {
		String sResultado= "";
		sResultado += "El Catador: "+super.getsNombre()+ " "+super.getsApellidos()+"/n";
		sResultado+= "Tiene un criterio de: "+getCriterio();
		return sResultado;
	}
	
	
}
