package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.ConexionDB;
import controlador.ControladorGeneral;
import modelo.almacen.Material;
import modelo.almacen.Tipo_material;

public class MaterialController implements IMaterialController {

	// Operaciones CRUD

	@Override
	public int add(Material oMaterial) {
		String sql = "INSERT INTO material VALUES ( '" + oMaterial.getsNombre_material() + "', '"
				+ oMaterial.getoNombre_tipo_material().getsNombre_tipo_material() + "', " + oMaterial.getiCantidad()
				+ ");";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Material oMaterial) {
		String sql = "DELETE FROM material WHERE nombre_material LIKE '" + oMaterial.getsNombre_material() + "' ;";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Material oMaterial) {
		String sql = "SELECT COUNT(*) FROM material WHERE nombre_material LIKE '" + oMaterial.getsNombre_material()
				+ "' ;";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Material searchMaterialPorTipo(Material oMaterial) {

		Material lMaterial = null;
		String sql = "SELECT * FROM material WHERE nombre_tipo_Material= '"
				+ oMaterial.getoNombre_tipo_material().getsNombre_tipo_material() + "' ;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				String sNombreTipoMaterial = rs.getString(2);
				int iCantidad = rs.getInt(3);
				Tipo_material oTipMaterial = new Tipo_material(sNombreTipoMaterial);
				lMaterial = new Material(sNombre_material, oTipMaterial, iCantidad);
			}
		} catch (SQLException e) {
			lMaterial = null;
		}
		return lMaterial;
	}

	@Override
	public Material searchMaterialPorNombre(Material oMaterial, ControladorGeneral oCont) {

		Material lMaterial = null;
		String sql = "SELECT * FROM material WHERE nombre_material= '"
				+ oMaterial.getsNombre_material() + "';";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_material = rs.getString(1);
				String sNombreTipoMaterial = rs.getString(2);
				int iCantidad = rs.getInt(3);
				Tipo_material oTipMaterial = new Tipo_material(sNombreTipoMaterial);
				
				oTipMaterial=oCont.getAlmacenCtrl().getTipoMaterialCtrl().searchTipo_material(oTipMaterial);
				
				lMaterial = new Material(sNombre_material, oTipMaterial, iCantidad);
			}
		} catch (SQLException e) {
			lMaterial = null;
		}
		return lMaterial;
	}

	@Override
	public int updateMaterial(Material oMaterial) {

		String sql = "UPDATE material SET cantidad = " + oMaterial.getiCantidad() + " WHERE nombre_material= '"
				+ oMaterial.getsNombre_material() + "' ;";

		return ConexionDB.executeUpdate(sql);
	}

}
