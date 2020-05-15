package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Cocinero_x_servicio;
import modelo.usuario.Cocinero;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Cocinero_x_servicioController implements ICocinero_x_servicioController {

	@Override
	public int add(Cocinero_x_servicio oCocXserv) {

		String sql = "INSERT INTO cocinero_x_servicio VALUES ( '" + oCocXserv.getEmail().getsEmail() + "', "
				+ oCocXserv.getId_servicio().getiId_servicio() + oCocXserv.getOpinion().getiId_opinion()+")";

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
	public List<Cocinero_x_servicio> HistorialCatXServ(Cocinero_x_servicio oCocXserv) {

		List<Cocinero_x_servicio> lCocXserv = new ArrayList<Cocinero_x_servicio>();

		String sql = "SELECT * FROM catador_x_servicio WHERE email LIKE '" + oCocXserv.getEmail().getsEmail() + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString(1);
				int id_servicio = rs.getInt(2);
				int id_opinion = rs.getInt(3);

				Cocinero oCoc = new Cocinero(email);
				Servicio oServ = new Servicio(id_servicio);
				Opinion oOpin = new Opinion(id_opinion);

				lCocXserv.add(new Cocinero_x_servicio(oCoc, oServ, oOpin));
			}
			stm.close();
		} catch (SQLException e) {
			lCocXserv = null;
		}
		return lCocXserv;
	}
}
