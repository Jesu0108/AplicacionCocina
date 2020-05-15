package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controlador.ConexionDB;
import modelo.almacen.Tipo_material;

public class Tipo_materialController implements ITipo_materialController {
	// Operaciones CRUD

	@Override
	public int add(Tipo_material oTMaterial) {
		String sql = "INSERT INTO tipo_material VALUES ( '" + oTMaterial.getsNombre_tipo_material() + "', "
				+ oTMaterial.getiCalidad() + " );";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Tipo_material oTMaterial) {
		String sql = "DELETE FROM tipo_material WHERE nombre_tipo_material LIKE '"
				+ oTMaterial.getsNombre_tipo_material() + "' ;";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeTipoMaterial(Tipo_material oTMaterial) {
		String sql = "SELECT COUNT(*) FROM tipo_material WHERE nombre_tipo_material LIKE '"
				+ oTMaterial.getsNombre_tipo_material() + "' ;";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Tipo_material searchTipo_material(Tipo_material oTMaterial) {

		Tipo_material lTpipMaterial = null;
		String sql = "SELECT * FROM tipo_material WHERE nombre_tipo_material= '" + oTMaterial.getsNombre_tipo_material()
				+ "' ;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_Tipo_material = rs.getString(1);
				int iCalidad = rs.getInt(2);
				lTpipMaterial = new Tipo_material(sNombre_Tipo_material, iCalidad);
			}
			stm.close();
		} catch (SQLException e) {
			lTpipMaterial = null;
		}
		return lTpipMaterial;
	}

	@Override
	public int updateTipo_material(Tipo_material oTMaterial) {

		String sql = "UPDATE tipo_material SET calidad = " + oTMaterial.getiCalidad() + "WHERE nombre_material= '"
				+ oTMaterial.getsNombre_tipo_material() + "' ;";

		return ConexionDB.executeUpdate(sql);
	}
}
