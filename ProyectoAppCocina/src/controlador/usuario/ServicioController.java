package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Servicio;

public class ServicioController {

	// Operaciones CRUD

	public int add(Servicio oServicio) {
		String sql = "INSERT INTO servicio VALUES (";
		sql += "\"" + oServicio.getiId_servicio() + "\",";
		sql += "\"" + oServicio.getsNombre_tipo_servicio() + "\",";
		sql += "\"" + oServicio.getCif() + "\",";
		sql += "\"" + oServicio.getdFecha();
		sql += "\"" + oServicio.getbTiempo_servicio() + "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	public int remove(Servicio oServicio) {
		String sql = "DELETE FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	public int existeCliente(Servicio oServicio) {
		String sql = "SELECT COUNT(*) FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeCount(sql);
	}
}
