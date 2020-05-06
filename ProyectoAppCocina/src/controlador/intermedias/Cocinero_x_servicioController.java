package controlador.intermedias;

import controlador.ConexionDB;
import controlador.usuario.CocineroController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Cocinero_x_servicio;


public class Cocinero_x_servicioController implements ICocinero_x_servicioController{

	@Override
	public int add(Cocinero_x_servicio oCocXserv, CocineroController oCocinero, ServicioController oServicio) {

		oCocinero.add(oCocXserv.getEmail());
		oServicio.add(oCocXserv.getId_servicio());

		String sql = "INSERT INTO cocinero_x_servicio VALUES (";
		sql += "\"" + oCocXserv.getEmail() + "\",";
		sql += "\"" + oCocXserv.getId_servicio() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Cocinero_x_servicio oCocXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oCocXserv.getId_servicio() + "\" AND email LIKE ";
		sql += "\"" + oCocXserv.getEmail() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
}
