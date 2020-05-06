package controlador.intermedias;

import controlador.ConexionDB;
import controlador.usuario.CatadorController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Catador_x_servicio;


public class Catador_x_servicioController {
	public int add(Catador_x_servicio oCatXserv, CatadorController oCatador, ServicioController oServicio) {

		String sql = "INSERT INTO catador_x_servicio VALUES (";
		sql += "\"" + oAlimXserv.getiIdSevicio() + "\",";
		sql += "\"" + oAlimXserv.getNombre_alimento() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	public int remove(Catador_x_servicio oCatXserv) {

		String sql = "DELETE FROM catador_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oAlimXserv.getiIdSevicio() + "\" AND nombre_alimento LIKE ";
		sql += "\"" + oAlimXserv.getNombre_alimento() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
}
