package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Servicio;

public class ServicioController implements IServicioController{

	// Operaciones CRUD
	
	@Override
	public int add(Servicio oServicio) {
		String sql = "INSERT INTO servicio VALUES (";
		sql += "\"" + oServicio.getiId_servicio() + "\",";
		sql += "\"" + oServicio.getsNombre_tipo_servicio() + "\",";
		sql += "\"" + oServicio.getdFecha();
		sql += "\"" + oServicio.getbTiempo_servicio() + "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Servicio oServicio) {
		String sql = "DELETE FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Servicio oServicio) {
		String sql = "SELECT COUNT(*) FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeCount(sql);
	}
}
