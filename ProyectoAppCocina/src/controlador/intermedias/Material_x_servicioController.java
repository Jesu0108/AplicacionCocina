package controlador.intermedias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Material;
import modelo.intermedias.Material_x_servicio;
import modelo.usuario.Opinion;
import modelo.usuario.Servicio;

public class Material_x_servicioController implements IMaterial_x_servicioController {

	@Override
	public int add(Material_x_servicio oMatXserv) {

		String sql = "INSERT INTO material_x_servicio VALUES ( '" + oMatXserv.getNombre_material().getsNombre_material()
				+ "', " + oMatXserv.getId_servicio() +", "+ oMatXserv.getOpinion().getiId_opinion()+");";

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
	public List<Material_x_servicio> HistorialCatXServ(Material_x_servicio oMatXserv) {

		List<Material_x_servicio> lMatXserv = new ArrayList<Material_x_servicio>();

		String sql = "SELECT * FROM catador_x_servicio WHERE nombre_material LIKE '" + oMatXserv.getNombre_material().getsNombre_material() + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString(1);
				int id_servicio = rs.getInt(2);
				int id_opinion = rs.getInt(3);

				Material oNomMat = new Material(email);
				Servicio oServ = new Servicio(id_servicio);
				Opinion oOpin = new Opinion(id_opinion);

				lMatXserv.add(new Material_x_servicio(oNomMat, oServ, oOpin));
			}
			stm.close();
		} catch (SQLException e) {
			lMatXserv = null;
		}
		return lMatXserv;
	}
}
