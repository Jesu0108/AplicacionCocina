package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Material;
import modelo.intermedias.Material_x_servicio;
import modelo.usuario.Servicio;

public class Material_x_servicioController implements IMaterial_x_servicioController {

	@Override
	public int add(Material_x_servicio oMatXserv) {

		String sql = "INSERT INTO material_x_servicio VALUES ( '" + oMatXserv.getNombre_material().getsNombre_material()
				+ "', " + null +" );";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material_x_servicio oMatXserv) {

		String sql = "DELETE FROM material_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oMatXserv.getId_servicio() + "\" AND nombre_material LIKE ";
		sql += "\"" + oMatXserv.getNombre_material() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
	
	@Override
	public List<Material_x_servicio> HistorialCatXServ() {

		List<Material_x_servicio> lMatXserv = new ArrayList<Material_x_servicio>();

		String sql = "SELECT * FROM catador_x_servicio;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString(1);
				int id_servicio = rs.getInt(2);

				Material oNomMat = new Material(email);
				Servicio oServ = new Servicio(id_servicio);

				lMatXserv.add(new Material_x_servicio(oNomMat, oServ));
			}
			stm.close();
		} catch (SQLException e) {
			lMatXserv = null;
		}
		return lMatXserv;
	}
}
