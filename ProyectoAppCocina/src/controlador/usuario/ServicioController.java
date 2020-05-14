package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import controlador.ConexionDB;
import modelo.usuario.Servicio;
import modelo.usuario.Tipo_servicio;

public class ServicioController implements IServicioController {

	// Operaciones CRUD

	@Override
	public int add(Servicio oServicio) {
		String sql = "INSERT INTO servicio VALUES ( " + (oServicio.getiId_servicio() + 1) + ", '"
				+ oServicio.getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "', '" + oServicio.getdFecha()
				+ "'," + oServicio.getbTiempo_servicio() + ");";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Servicio oServicio) {
		String sql = "DELETE FROM servicio WHERE id_servicio LIKE \"" + oServicio.getiId_servicio() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeServicio(Servicio oServicio) {
		String sql = "SELECT COUNT(*) FROM servicio WHERE nombre_tipo_servicio LIKE \""
				+ oServicio.getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Servicio searchServicio(Servicio fecha) {

		Servicio lServicio = null;
		String sql = "SELECT * FROM servicio WHERE fecha='" + fecha.getdFecha() + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_tipo_servicio = rs.getString(2);
				Date dFecha = rs.getDate(3);
				byte bTiempo_servicio = rs.getByte(4);

				Tipo_servicio oTipServ = new Tipo_servicio(sNombre_tipo_servicio);
				lServicio = new Servicio(dFecha, bTiempo_servicio, oTipServ);
			}
		} catch (SQLException e) {
			lServicio = null;
		}
		return lServicio;
	}

	@Override
	public int updateServicio(Servicio oServicio) {

		String sql = "UPDATE servicio ";
		sql += "SET nombre_tipo_servicio = '" + oServicio.getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "',";
		sql += "fecha = '" + oServicio.getdFecha() + " ";
		sql += "tiempo_servicio = \"" + oServicio.getbTiempo_servicio();
		sql += "WHERE id_servicio=" + oServicio.getiId_servicio();

		return ConexionDB.executeUpdate(sql);
	}
}
