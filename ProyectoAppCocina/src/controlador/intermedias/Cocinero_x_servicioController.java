package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Cocinero_x_servicio;

public class Cocinero_x_servicioController implements ICocinero_x_servicioController {

	//Hacemos esta funcion para conseguir el id del ultimo servicio
	//que se meta para asi poder enlazarlo en la db en el historial
	
	@Override
	public int idDB() {
		
		String sql = "SELECT MAX(id_servicio) FROM servicio";
		
		int i =0;
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
	public int add(Cocinero_x_servicio oCocXserv) {
		String sql = "INSERT INTO cocinero_x_servicio VALUES ( '" + oCocXserv.getEmail().getsEmail() + "', " + idDB() + " )";

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
