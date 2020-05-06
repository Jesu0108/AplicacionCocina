package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Persona;

public class PersonaController {

	public int add(String sEmail, String sContrasenia, String sNombre, String sApellidos, String sTelefono,
			String sExperiencia, String sCiudad) {

		String sql = "INSERT INTO catador VALUES (";
		sql += "\"" + sEmail + "\",";
		sql += "\"" + sContrasenia + "\",";
		sql += "\"" + sNombre + "\",";
		sql += "\"" + sApellidos + "\",";
		sql += "\"" + sTelefono + "\",";
		sql += "\"" + sExperiencia + "\",";
		sql += "\"" + sCiudad + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	// Operaciones de checking

	public int existePersona(Persona oPersona) {
		String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oPersona.getsEmail() + "\"";
		return ConexionDB.executeCount(sql);
	}

	public int checkLogin(Persona oPersona) {
		String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oPersona.getsEmail() + "\" AND contraseña LIKE \"" + oPersona.getsContrasenia() + "\"";
		return ConexionDB.executeCount(sql);
	}
}
