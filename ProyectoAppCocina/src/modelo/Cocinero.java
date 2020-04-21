package modelo;

public class Cocinero extends Persona{
	
	private String sEspecialidad;
	
	public Cocinero(String sEmail, String sContrasenia, String sNombre, String sApellidos, String sTelefono,
			String sExperiencia, String sCiudad) {
		super(sEmail, sContrasenia, sCiudad, sNombre, sApellidos, sTelefono, sCiudad);
		setsEspecialidad(sEspecialidad);
	}
	
	
	public Cocinero(String sEmail, String sEspecialidad) {
		super(sEmail);
		setsEspecialidad(sEspecialidad);
	}

	//Getters and Setters
	
	public String getsEspecialidad() {
		return sEspecialidad;
	}

	public boolean setsEspecialidad(String sEspecialidad) {
		boolean bExito=false;
		if(sEspecialidad != null) {
			this.sEspecialidad = sEspecialidad;
			bExito = true;
		}
		return bExito;
	}

	
}
