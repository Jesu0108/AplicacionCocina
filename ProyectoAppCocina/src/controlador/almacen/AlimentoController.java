package controlador.almacen;

import controlador.ConexionDB;
import modelo.almacen.Alimento;

public class AlimentoController {
	// Operaciones CRUD

	@Override
	public int add(Alimento oAlimento) {
		String sql = "INSERT INTO alimento VALUES (";
		sql += "\"" + oAlimento.getsNombre_alimento() + "\",";
		sql += "\"" + oAlimento.getbCantidad() + "\",";
		sql += ")";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Alimento oAlimento) {
		String sql = "DELETE FROM alimento WHERE nombre_alimento LIKE \"" + oAlimento.getsNombre_alimento() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeCliente(Alimento oAlimento) {
		String sql = "SELECT COUNT(*) FROM Alimento WHERE nombre_alimento LIKE \"" + oAlimento.getsNombre_alimento() + "\"";
		return ConexionDB.executeCount(sql);
	}
}
