package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Alimento_x_servicio;

public class Alimento_x_servicioController implements IAlimento_x_servicioController {

	@Override
	public int add(Alimento_x_servicio oAlimXserv) {

		int i = 0;

		// Seleccionamos el id_servicio que queremos para poder
		// usarlo en la query del insert

		String sql1 = "SELECT id_servicio FROM servicio WHERE nombre_tipo_servicio = '"
				+ oAlimXserv.getiIdSevicio().getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "' ;";

		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql1);

			i = rs.getInt(1);

			stm.close();
		} catch (SQLException e) {
			i = 0;
		}

		// Hacemos la query
		
		String sql = "INSERT INTO alimento_x_servicio VALUES ( '" + oAlimXserv.getNombre_alimento().getsNombre_alimento()
				+ "', " + i + " );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove() {

		String sql = "DELETE FROM Alimento_x_servicio;";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Alimento_x_servicio> HistorialAlimXServ() {
		List<Alimento_x_servicio> lAlimXserv = new ArrayList<Alimento_x_servicio>();

		String sql = "SELECT * FROM alimento_x_servicio;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				System.out.print("\n"+rs.getString(1)+" - ");
				System.out.println(rs.getInt(2));
			}
			stm.close();
		} catch (SQLException e) {
			lAlimXserv = null;
		}
		return lAlimXserv;
	}

}
