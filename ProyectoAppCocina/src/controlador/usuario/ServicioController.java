package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import controlador.ConexionDB;
import modelo.usuario.Servicio;

public class ServicioController implements IServicioController {

	// Operaciones CRUD

	@Override
	public int add(Servicio oServicio) {
		String sql = "INSERT INTO servicio VALUES (";
		sql += "\"" + (oServicio.getiId_servicio() + 1) + "\",";
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
	public int existeServicio(Servicio oServicio) {
		String sql = "SELECT COUNT(*) FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Servicio searchServicio(String sNombreTipoServicio) {

		Servicio lServicio = null;
		String sql = "SELECT * FROM servicio WHERE nombre_tipo_servicio()=" + sNombreTipoServicio;
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_tipo_servicio = rs.getString(1);
				Date dFecha = rs.getDate(2);
				byte bTiempo_servicio = rs.getByte(3);
				lServicio = new Servicio(sNombre_tipo_servicio, dFecha, bTiempo_servicio);
			}
		} catch (SQLException e) {
			lServicio = null;
		}
		return lServicio;
	}

	@Override
	public int updateServicio(Servicio oServicio) {
		
		String sql = "UPDATE servicio ";
	    sql += "SET nombre_tipo_servicio = '" + oServicio.getsNombre_tipo_servicio() + "',";
	    sql += "fecha = '" + oServicio.getdFecha() + " ";
	    sql += "tiempo_servicio = \"" + oServicio.getbTiempo_servicio();
	    sql += "WHERE id_servicio=" + oServicio.getiId_servicio();
	    
		return ConexionDB.executeUpdate(sql);
	}
}
