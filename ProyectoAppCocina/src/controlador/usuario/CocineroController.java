package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.usuario.Cocinero;

public class CocineroController {
	@Override
	public int add(Cocinero oCocinero, PersonaController oPersona) {

		oPersona.add(oCocinero.getsEmail(), oCocinero.getsContrasenia(), oCocinero.getsNombre(), oCocinero.getsApellidos(),
				oCocinero.getsTelefono(), oCocinero.getsExperiencia(), oCocinero.getsCiudad());

		String sql = "INSERT INTO cocinero VALUES (";
		sql += "\"" + oCocinero.getsEmail() + "\",";
		sql += "\"" + oCocinero.getsEspecialidad() + "\",";
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
	public List<Cocinero> searchCocineroPorEmail(Cocinero oCocinero) {

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
				lCocineros
						.add(new Cocinero(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad));
			}
			stm.close();
		} catch (SQLException e) {
			lCocineros = null;
		}
		return lCocineros;
	}
}
