package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.intermedias.Material_x_servicio;

public class Material_x_servicioController implements IMaterial_x_servicioController {

	@Override
	public int add(Material_x_servicio oMatXserv) {
		
		int i=0;
		
		// Seleccionamos el id_servicio que queremos para poder
		// usarlo en la query del insert

		String sql1 = "SELECT id_servicio FROM servicio WHERE nombre_tipo_servicio = '"
				+ oMatXserv.getId_servicio().getoNombre_tipo_servicio().getsNombre_tipo_servicio() + "' ;";

		Statement stm = null;
		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql1);

			i = rs.getInt(1);
			
			stm.close();
		} catch (SQLException e) {
			i=0;
		}
		
		// Hacemos la query

		String sql = "INSERT INTO material_x_servicio VALUES ( '" + oMatXserv.getNombre_material().getsNombre_material()
				+ "', " + i + " );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material_x_servicio oMatXserv) {

		String sql = "DELETE FROM material_x_servicio WHERE id_servicio LIKE " + oMatXserv.getId_servicio()
				+ " AND nombre_material LIKE '" + oMatXserv.getNombre_material().getsNombre_material() + "' ;";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Material_x_servicio> HistorialMatXServ() {

		List<Material_x_servicio> lMatXserv = new ArrayList<Material_x_servicio>();

		String sql = "SELECT * FROM material_x_servicio;";
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
			lMatXserv = null;
		}
		return lMatXserv;
	}
}
