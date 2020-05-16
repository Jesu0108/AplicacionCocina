package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Empresa_x_servicio;
import modelo.usuario.Empresa;
import modelo.usuario.Servicio;

public class Empresa_x_servicioController implements IEmpresa_x_servicioController {

	@Override
	public int add(Empresa_x_servicio oEmpXserv) {

		int i = 0;

		// Seleccionamos el id_servicio que queremos para poder
		// usarlo en la query del insert

		String sql1 = "SELECT id_servicio FROM servicio WHERE nombre_tipo_servicio = '"
				+ oEmpXserv.getiIdSevicio().getoNombre_tipo_servicio().getsNombre_tipo_servicio()+ "' ;";

		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql1);

			i = rs.getInt(1);

			stm.close();
		} catch (SQLException e) {
			i = 0;
		}

		String sql = "INSERT INTO empresa_x_servicio VALUES ( '" + oEmpXserv.getsCif().getsCif() + "', " + i + ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Empresa_x_servicio oEmpXserv) {

		String sql = "DELETE FROM cocinero_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oEmpXserv.getiIdSevicio() + "\" AND cif LIKE ";
		sql += "\"" + oEmpXserv.getsCif() + "\"";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Empresa_x_servicio> HistorialEmpXServ() {
		List<Empresa_x_servicio> lEmpXserv = new ArrayList<Empresa_x_servicio>();

		String sql = "SELECT * FROM empresa_x_servicio;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String cif = rs.getString(1);
				int id_servicio = rs.getInt(2);

				Empresa oEmp = new Empresa(cif);
				Servicio oServ = new Servicio(id_servicio);

				lEmpXserv.add(new Empresa_x_servicio(oEmp, oServ));
			}
			stm.close();
		} catch (SQLException e) {
			lEmpXserv = null;
		}
		return lEmpXserv;
	}
}
