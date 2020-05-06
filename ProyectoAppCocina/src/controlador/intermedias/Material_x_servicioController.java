package controlador.intermedias;

import controlador.ConexionDB;
import controlador.almacen.MaterialController;
import controlador.usuario.ServicioController;
import modelo.intermedias.Material_x_servicio;


public class Material_x_servicioController implements IMaterial_x_servicioController{
	
	@Override
	public int add(Material_x_servicio oMatXserv, MaterialController oMaterial, ServicioController oServicio) {

		oMaterial.add(oMatXserv.getNombre_material());
		oServicio.add(oMatXserv.getId_servicio());

		String sql = "INSERT INTO material_x_servicio VALUES (";
		sql += "\"" + oMatXserv.getId_servicio() + "\",";
		sql += "\"" + oMatXserv.getNombre_material() + "\",";
		sql += ")";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material_x_servicio oMatXserv) {

		String sql = "DELETE FROM material_x_servicio WHERE id_servicio LIKE ";
		sql += "\"" + oMatXserv.getId_servicio() + "\" AND nombre_material LIKE ";
		sql += "\"" + oMatXserv.getNombre_material() + "\"";

		return ConexionDB.executeUpdate(sql);
	}
}
