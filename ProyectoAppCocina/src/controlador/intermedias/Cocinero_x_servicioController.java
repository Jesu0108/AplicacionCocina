package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Cocinero_x_servicio;

public class Cocinero_x_servicioController implements ICocinero_x_servicioController {

	@Override
	public int add(Cocinero_x_servicio oCocXserv) {

		int i = 0;

		// Seleccionamos el id_servicio que queremos para poder
		// usarlo en la query del insert

		String sql1 = "SELECT id_servicio FROM servicio WHERE nombre_tipo_servicio = '"
				+ oCocXserv.getId_servicio().getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "' ;";

		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql1);

			i = rs.getInt(1);

			stm.close();
		} catch (SQLException e) {
			i = 0;
		}

		String sql = "INSERT INTO cocinero_x_servicio VALUES ( '" + oCocXserv.getEmail().getsEmail() + "', " + i+ ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Cocinero_x_servicio oCocXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oCocXserv.getId_servicio() + "\" AND email LIKE ";
		sql += "\"" + oCocXserv.getEmail() + "\"";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Cocinero_x_servicio> HistorialCocXServ() {

		List<Cocinero_x_servicio> lCocXserv = new ArrayList<Cocinero_x_servicio>();

		String sql = "SELECT * FROM catador_x_servicio ;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				System.out.print("\n"+rs.getString(1)+" - ");
				System.out.println(rs.getInt(2));
			}
			stm.close();
		} catch (SQLException e) {
			lCocXserv = null;
		}
		return lCocXserv;
	}
}
