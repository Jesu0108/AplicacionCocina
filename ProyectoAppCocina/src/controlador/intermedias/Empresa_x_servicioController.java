package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Empresa_x_servicio;

public class Empresa_x_servicioController implements IEmpresa_x_servicioController {

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
	public int add(Empresa_x_servicio oEmpXserv) {

		String sql = "INSERT INTO empresa_x_servicio VALUES ( '" + oEmpXserv.getsCif().getsCif() + "', " + idDB() + ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Empresa_x_servicio oEmpXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oEmpXserv.getiIdSevicio() + "\" AND cif LIKE ";
		sql += "\"" + oEmpXserv.getsCif() + "\"";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Empresa_x_servicio> HistorialEmpXServ() {
		List<Empresa_x_servicio> lEmpXserv = new ArrayList<Empresa_x_servicio>();

		String sql = "SELECT * FROM empresa_x_servicio;";
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
			lEmpXserv = null;
		}
		return lEmpXserv;
	}
}
