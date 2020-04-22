package modelo;

public class Catador extends Persona{
	
	private byte bCriterio;

	public Catador(String sEmail, String sContrasenia, String sNombre, String sApellidos, String sTelefono,
			String sExperiencia, String sCiudad) {
		super(sEmail, sContrasenia, sCiudad, sNombre, sApellidos, sTelefono, sCiudad);
		setCriterio(bCriterio);
	}
	
	public Catador(String sEmail, byte bCriterio) {
		super(sEmail);
		setCriterio(bCriterio);
	}
	
	//Getters and Setters
	
	public byte getCriterio() {
		return bCriterio;
	}

	public boolean setCriterio(byte bCriterio) {
		boolean bExito = false;
		if(bCriterio > -1) {
			this.bCriterio = bCriterio;
			bExito = true;
		}
		return bExito;
	}
}
