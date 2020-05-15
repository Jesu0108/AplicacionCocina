package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.ConexionDB;
import modelo.usuario.Tipo_servicio;

public class Tipo_servicioController implements ITipo_servicioController {

	// Operaciones CRUD

	@Override
	public int add(Tipo_servicio oTipo_servicio) {
		String sql = "INSERT INTO tipo_servicio VALUES ( '" + oTipo_servicio.getsNombre_tipo_servicio() + "', "
				+ oTipo_servicio.getiCalidad() + ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Tipo_servicio oTipo_servicio) {
		String sql = "DELETE FROM tipo_servicio WHERE nombre_tipo_servicio LIKE '"
				+ oTipo_servicio.getsNombre_tipo_servicio() + "' ;";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeTipo_servicio(Tipo_servicio oTipo_servicio) {
		String sql = "SELECT COUNT(*) FROM tipo_servicio WHERE nombre_tipo_servicio LIKE '"
				+ oTipo_servicio.getsNombre_tipo_servicio() + "' ;";
		return ConexionDB.executeCount(sql);
	}
	
	@Override
	public Tipo_servicio searchTipoServicio(String tipServicio) {

		Tipo_servicio lTipServicio = null;
		String sql = "SELECT * FROM tipo_servicio WHERE nombre_tipo_servicio='"
				+ tipServicio + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_tipo_servicio = rs.getString(1);
				byte bCalidad = rs.getByte(2);
				
				lTipServicio = new Tipo_servicio(sNombre_tipo_servicio, bCalidad);
			}
		} catch (SQLException e) {
			lTipServicio = null;
		}
		return lTipServicio;
	}
}
