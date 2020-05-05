package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;


public class MaterialController implements IMaterialController{
	
	// Operaciones CRUD

	@Override
	public int add(Material oMaterial) {
		String sql = "INSERT INTO material VALUES (";
		sql += "\"" + oMaterial.getsNombre_material() + "\",";
		sql += "\"" + oMaterial.getoNombre_tipo_material() + "\",";
		sql += "\"" + oMaterial.getiCantidad() + "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material oMaterial) {
		String sql = "DELETE FROM material WHERE nombre_material LIKE \"" + oMaterial.getsNombre_material() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Material oMaterial) {
		String sql = "SELECT COUNT(*) FROM Material WHERE nombre_material LIKE \"" + oMaterial.getsNombre_material()+ "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public List<Material> searchMaterialesPorTipo(Tipo_material oTMaterial) {

		List<Material> lMateriales = new ArrayList<Material>();
		String sql = "SELECT * FROM material WHERE nombre_tipo_material=" + oTMaterial.getsNombre_tipo_material();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				int iCantidad = rs.getInt(2);
				lMateriales.add(new Material(sNombre_material, oTMaterial, iCantidad));
			}
			stm.close();
		} catch (SQLException e) {
			lMateriales = null;
		}
		return lMateriales;
	}
	
	@Override
	public List<Material> searchMaterialesPorNombre(Material oMaterial) {

		List<Material> lMateriales = new ArrayList<Material>();
		String sql = "SELECT * FROM material WHERE nombre_material=" + oMaterial.getsNombre_material();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				int iCantidad = rs.getInt(2);
				lMateriales.add(new Material(sNombre_material, iCantidad));
			}
			stm.close();
		} catch (SQLException e) {
			lMateriales = null;
		}
		return lMateriales;
	}
}
