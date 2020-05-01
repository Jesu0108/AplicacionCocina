package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Persona;

public class PersonaController {

	//Operaciones CRUD
	
	public int add (Persona oPersona) {
		String sql = "INSERT INTO persona VALUES (\""+oPersona.getsEmail()+"\",\""+oPersona.getsContrasenia()+"\")";
		return ConexionDB.executeUpdate(sql);
	}
	
	public int remove (Persona oPersona) {
		String sql = "DELETE FROM persona WHERE email LIKE \""+oPersona.getsEmail()+"\"";
		return ConexionDB.executeUpdate(sql);
	}
	
	//Operaciones de checking
	
	public int existeUsuario (Persona oPersona) {
		String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oPersona.getsEmail() + "\"";
		return ConexionDB.executeCount(sql);
	    }
	
	 public int checkLogin(Persona oPersona) {	
			String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oPersona.getsEmail() + "\" AND contraseña LIKE \"" + oPersona.getsContrasenia() + "\"";	
			return ConexionDB.executeCount(sql);
		    }
}
