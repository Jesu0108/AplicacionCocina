package controlador.almacen;

import controlador.ConexionDB;
import modelo.almacen.Tipo_material;


public class Tipo_materialController implements ITipo_materialController{
	// Operaciones CRUD

	@Override
	public int add(Tipo_material oTMaterial) {
		String sql = "INSERT INTO tipo_material VALUES (";
		sql += "\"" + oTMaterial.getsNombre_tipo_material() + "\",";
		sql += "\"" + oTMaterial.getiCalidad()+ "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Tipo_material oTMaterial) {
		String sql = "DELETE FROM tipo_material WHERE nombre_tipo_material LIKE \"" + oTMaterial.getsNombre_tipo_material() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Tipo_material oTMaterial) {
		String sql = "SELECT COUNT(*) FROM tipo_material WHERE nombre_tipo_material LIKE \"" + oTMaterial.getsNombre_tipo_material()
				+ "\"";
		return ConexionDB.executeCount(sql);
	}
}
