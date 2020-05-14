package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.ConexionDB;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;

public class MaterialController implements IMaterialController {

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
		String sql = "SELECT COUNT(*) FROM Material WHERE nombre_material LIKE \"" + oMaterial.getsNombre_material()
				+ "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Material searchMaterialPorTipo(Material oMaterial) {

		Material lMaterial = null;
		String sql = "SELECT * FROM material WHERE nombre_tipo_Material=\"" + oMaterial.getoNombre_tipo_material().getsNombre_tipo_material()+"\"";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				String sNombreTipoMaterial = rs.getString(2);
				int Icantidad = rs.getInt(3);
				Tipo_material oTipMaterial = new Tipo_material (sNombreTipoMaterial);
				lMaterial = new Material(sNombre_material,Icantidad,oTipMaterial);
			}
		} catch (SQLException e) {
			lMaterial = null;
		}
		return lMaterial;
	}

	@Override
	public Material searchMaterialPorNombre(Material oMaterial) {

		Material lMaterial = null;
		String sql = "SELECT * FROM material WHERE nombre_Material=\"" + oMaterial.getoNombre_tipo_material()+"\"";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				String sNombreTipoMaterial = rs.getString(2);
				int Icantidad = rs.getInt(3);
				Tipo_material oTipMaterial = new Tipo_material (sNombreTipoMaterial);
				lMaterial = new Material(sNombre_material,Icantidad,oTipMaterial);
			}
		} catch (SQLException e) {
			lMaterial = null;
		}
		return lMaterial;
	}
	
	@Override
	public int updateMaterial(Material oMaterial) {

		String sql = "UPDATE material ";
		sql += "SET nombre_material = '" + oMaterial.getsNombre_material() + "',";
		sql += "nombre_tipo_material = '" + oMaterial.getoNombre_tipo_material() + " ";
		sql += "cantidad = \"" + oMaterial.getiCantidad();
		sql += "WHERE nombre_material=" + oMaterial.getsNombre_material();

		return ConexionDB.executeUpdate(sql);
	}


}
