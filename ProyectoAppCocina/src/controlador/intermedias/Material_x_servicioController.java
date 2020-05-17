package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Material_x_servicio;

public class Material_x_servicioController implements IMaterial_x_servicioController {

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
	public int add(Material_x_servicio oMatXserv) {

		String sql = "INSERT INTO material_x_servicio VALUES ( '" + oMatXserv.getNombre_material().getsNombre_material()
				+ "', " + idDB() + " );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove() {

		String sql = "DELETE FROM material_x_servicio;";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Material_x_servicio> HistorialMatXServ() {

		List<Material_x_servicio> lMatXserv = new ArrayList<Material_x_servicio>();

		String sql = "SELECT * FROM material_x_servicio;";
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
			lMatXserv = null;
		}
		return lMatXserv;
	}
}
