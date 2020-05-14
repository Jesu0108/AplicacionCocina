package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.usuario.Cocinero;

public class CocineroController implements iCocineroController{
	@Override
	public int add(Cocinero oCocinero) {

		String sql = "INSERT INTO cocinero VALUES (";
		sql += "\"" + oCocinero.getsEmail() + "\",";
		sql += "\"" + oCocinero.getsEspecialidad() + "\",";
		sql += "\"" + oCocinero.getsContrasenia() + "\",";
		sql += "\"" + oCocinero.getsNombre() + "\",";
		sql += "\"" + oCocinero.getsApellidos() + "\",";
		sql += "\"" + oCocinero.getsTelefono() + "\",";
		sql += "\"" + oCocinero.getsExperiencia() + "\",";
		sql += "\"" + oCocinero.getsCiudad() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Cocinero oCocinero) {
		String sql = "DELETE FROM cocinero WHERE email LIKE \"" + oCocinero.getsEmail() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCocinero(Cocinero oCocinero) {
		String sql = "SELECT COUNT(*) FROM cocinero WHERE email LIKE \"" + oCocinero.getsEmail() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public int checkLogin(Cocinero oCocinero) {
		String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oCocinero.getsEmail() 
		+ "\" AND contraseña LIKE \"" + oCocinero.getsContrasenia() + "\"";
		return ConexionDB.executeCount(sql);
	}
	
	@Override
	public Cocinero searchCocinero(Cocinero oCocinero) {

		Cocinero lCocinero = null;
		String sql = "SELECT * FROM catador WHERE email=" + oCocinero.getsEmail();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sEspecialidad = rs.getString(1);
				String sEmail = rs.getString(2);
				String sContrasenia = rs.getString(3);
				String sNombre = rs.getString(4);
				String sApellidos = rs.getString(5);
				String sExperiencia = rs.getString(6);
				String sCiudad = rs.getString(7);
				String sTelefono = rs.getString(8);
				
				lCocinero = new Cocinero(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad, sEspecialidad);
			}
		} catch (SQLException e) {
			lCocinero = null;
		}
		return lCocinero;
	}
	
	
	@Override
	public List<Cocinero> searchCocineroPorCiudad(Cocinero oCocinero) {

		List<Cocinero> lCocineros = new ArrayList<Cocinero>();
		String sql = "SELECT * FROM cocinero WHERE email=" + oCocinero.getsEmail();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sEmail = rs.getString(1);
				String sContrasenia = rs.getString(2);
				String sNombre = rs.getString(3);
				String sApellidos = rs.getString(4);
				String sTelefono = rs.getString(5);
				String sExperiencia = rs.getString(6);
				String sCiudad = rs.getString(7);
				String sEspecialidad = rs.getString(8);
				lCocineros.add(new Cocinero(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad, sEspecialidad));
			}
			stm.close();
		} catch (SQLException e) {
			lCocineros = null;
		}
		return lCocineros;
	}
}
