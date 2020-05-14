package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.usuario.Catador;

public class CatadorController implements ICatadorController {

	@Override
	public int add(Catador oCatador) {

		String sql = "INSERT INTO catador VALUES ( '" + oCatador.getCriterio() + "', '" + oCatador.getsEmail() + "', '"
				+ oCatador.getsContrasenia() + "', '" + oCatador.getsNombre() + "', '" + oCatador.getsApellidos()
				+ "', '" + oCatador.getsCiudad() + "', '" + oCatador.getsTelefono() + "', '" + oCatador.getsExperiencia() + "' );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Catador oCatador) {
		String sql = "DELETE FROM catador WHERE email LIKE \"" + oCatador.getsEmail() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCatador(Catador oCatador) {
		String sql = "SELECT COUNT(*) FROM catador WHERE email LIKE \"" + oCatador.getsEmail() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public int checkLogin(Catador oCatador) {
		String sql = "SELECT COUNT(*) FROM catador WHERE email LIKE \"" + oCatador.getsEmail()
				+ "\" AND contraseņa LIKE \"" + oCatador.getsContrasenia() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Catador searchCatador(Catador oCatador) {

		Catador lCatador = null;
		String sql = "SELECT * FROM catador WHERE email=\"" + oCatador.getsEmail() + "\"";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				byte bCriterio = rs.getByte(1);
				String sEmail = rs.getString(2);
				String sContrasenia = rs.getString(3);
				String sNombre = rs.getString(4);
				String sApellidos = rs.getString(5);
				String sCiudad = rs.getString(6);
				String sTelefono = rs.getString(7);
				String sExperiencia = rs.getString(8);

				lCatador = new Catador(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad,
						bCriterio);
			}
		} catch (SQLException e) {
			lCatador = null;
		}
		return lCatador;
	}

	@Override
	public List<Catador> searchCatadorPorCiudad(Catador oCatador) {

		List<Catador> lCatadores = new ArrayList<Catador>();
		String sql = "SELECT * FROM catador WHERE ciudad=" + oCatador.getsCiudad();
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
				byte bCriterio = rs.getByte(8);
				lCatadores.add(new Catador(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad,
						bCriterio));
				System.out.println("\n-----------------------------------------------------------------\n");
			}
			stm.close();
		} catch (SQLException e) {
			lCatadores = null;
		}
		return lCatadores;
	}

}
