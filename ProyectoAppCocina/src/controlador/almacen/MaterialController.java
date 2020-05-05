package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Material;


public class MaterialController {
	
	// Operaciones CRUD

	@Override
	public int add(Material oMaterial) {
		String sql = "INSERT INTO material VALUES (";
		sql += "\"" + oMaterial.getsNombre_material() + "\",";
		sql += "\"" + oMaterial.getoNombre_tipo_material() + "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material oMaterial) {
		String sql = "DELETE FROM Material WHERE nombre_Material LIKE \"" + oMaterial.getsNombre_Material() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Material oMaterial) {
		String sql = "SELECT COUNT(*) FROM Material WHERE nombre_Material LIKE \"" + oMaterial.getsNombre_Material()
				+ "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public List<Material> searchMaterialesPorNombre(Material oMaterial) {

		List<Material> lMateriales = new ArrayList<Material>();
		String sql = "SELECT * FROM Material WHERE nombre_Material=" + oMaterial.getsNombre_Material();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_Material = rs.getString(1);
				byte bCantidad = (byte) rs.getByte(2);
				lMateriales.add(new Material(sNombre_Material, bCantidad));
			}
			stm.close();
		} catch (SQLException e) {
			lMateriales = null;
		}
		return lMateriales;
	}
}
