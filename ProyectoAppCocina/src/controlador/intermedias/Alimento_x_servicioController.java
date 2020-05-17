package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Alimento_x_servicio;

public class Alimento_x_servicioController implements IAlimento_x_servicioController {

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
	public int add(Alimento_x_servicio oAlimXserv) {

		String sql = "INSERT INTO alimento_x_servicio VALUES ( '"
				+ oAlimXserv.getNombre_alimento().getsNombre_alimento() + "', " + idDB() + " );";

		return ConexionDB.executeUpdate(sql);

	}

	@Override
	public int remove() {

		String sql = "DELETE FROM Alimento_x_servicio;";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Alimento_x_servicio> HistorialAlimXServ() {
		List<Alimento_x_servicio> lAlimXserv = new ArrayList<Alimento_x_servicio>();

		String sql = "SELECT * FROM alimento_x_servicio;";
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
			lAlimXserv = null;
		}
		return lAlimXserv;
	}

}
