package modelo.usuario;

public interface IPersona {

	public boolean setsContrasenia(String sContrasenia);

	public String getsNombre();

	public boolean setsNombre(String sNombre);

	public String getsApellidos();

	public boolean setsApellidos(String sApellidos);

	public boolean setsTelefono(String sTelefono);
	
	public String getsTelefono();

	public String getsExperiencia();

	public boolean setsExperiencia(String sExperiencia);

	public String getsCiudad();

	public boolean setsCiudad(String sCiudad);

	public String encryptSha512(String input);

	public boolean checkUser();

	public boolean checkLogin(Object obj);

	

}
