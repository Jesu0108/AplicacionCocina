package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Catador_x_servicio;

public class Catador_x_servicioController implements ICatador_x_servicioController {

	// Hacemos esta funcion para conseguir el id del ultimo servicio
	// que se meta para asi poder enlazarlo en la db en el historial
	
	@Override
	public int idDB() {

		String sql = "SELECT MAX(id_servicio) FROM servicio";

		int i = 0;
		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				i = rs.getInt(1);
			}
			stm.close();
		} catch (SQLException e) {
			i = 0;
		}
		return i;
	}

	@Override
	public int add(Catador_x_servicio oCatXserv) {
		String sql = "INSERT INTO catador_x_servicio VALUES ( '" + oCatXserv.getEmail().getsEmail() + "', " + idDB()
				+ " );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Catador_x_servicio oCatXserv) {

		String sql = "DELETE FROM catador_x_servicio WHERE id_servicio LIKE "
				+ oCatXserv.getId_servicio().getiId_servicio() + " AND email LIKE '" + oCatXserv.getEmail().getsEmail()
				+ "';";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Catador_x_servicio> HistorialCatXServ() {
		List<Catador_x_servicio> lCatXserv = new ArrayList<Catador_x_servicio>();

		String sql = "SELECT * FROM catador_x_servicio;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				System.out.print("\n" + rs.getString(1) + " - ");
				System.out.println(rs.getInt(2));
			}
			stm.close();
		} catch (SQLException e) {
			lCatXserv = null;
		}
		return lCatXserv;
	}
}
