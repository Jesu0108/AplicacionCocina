package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Tipo_servicio;

public class Tipo_servicioController {
	
	// Operaciones CRUD

	public int add(Tipo_servicio oTipo_servicio) {
		String sql = "INSERT INTO tipo_servicio VALUES (\"" + oTipo_servicio.getiCalidad() + "\",\"" + oTipo_servicio.getsNombre_tipo_servicio()
				+")";
		return ConexionDB.executeUpdate(sql);
	}

	public int remove(Tipo_servicio oTipo_servicio) {
		String sql = "DELETE FROM tipo_servicio WHERE nombre_Tipo_servicio LIKE \"" + oTipo_servicio.getsNombre_tipo_servicio() + "\"";
		return ConexionDB.executeUpdate(sql);
	}
	
	public int existeTipo_servicio(Tipo_servicio oTipo_servicio) {
		String sql = "SELECT COUNT(*) FROM tipo_servicio WHERE nombre_Tipo_servicio LIKE \"" + oTipo_servicio.getsNombre_tipo_servicio() + "\"";
		return ConexionDB.executeCount(sql);
	}
}
