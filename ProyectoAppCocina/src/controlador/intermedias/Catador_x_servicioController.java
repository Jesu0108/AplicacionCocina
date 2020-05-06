package controlador.intermedias;

import controlador.ConexionDB;
import controlador.usuario.CatadorController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Catador_x_servicio;


public class Catador_x_servicioController implements ICatador_x_servicioController{
	
	@Override
	public int add(Catador_x_servicio oCatXserv, CatadorController oCatador, ServicioController oServicio) {

		oCatador.add(oCatXserv.getEmail());
		oServicio.add(oCatXserv.getId_servicio());
		
		String sql = "INSERT INTO catador_x_servicio VALUES (";
		sql += "\"" + oCatXserv.getEmail() + "\",";
		sql += "\"" + oCatXserv.getId_servicio() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Catador_x_servicio oCatXserv) {

		String sql = "DELETE FROM catador_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" +oCatXserv.getId_servicio() + "\" AND email LIKE ";
		sql += "\"" +oCatXserv.getEmail() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
}
