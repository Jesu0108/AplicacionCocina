package controlador.almacen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.almacen.Alimento;


public class AlimentoController implements IAlimento {
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
		String sql = "SELECT COUNT(*) FROM Alimento WHERE nombre_alimento LIKE \"" + oAlimento.getsNombre_alimento()
				+ "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public List<Alimento> searchAlimentosPorNombre(Alimento oAlimento) {

		List<Alimento> lAlimentos = new ArrayList<Alimento>();
		String sql = "SELECT * FROM alimento WHERE nombre_alimento=" + oAlimento.getsNombre_alimento();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_alimento = rs.getString(1);
				byte bCantidad = rs.getByte(2);
				lAlimentos.add(new Alimento(sNombre_alimento,bCantidad));
			}
			stm.close();
		} catch (SQLException e) {
			lAlimentos = null;
		}
		return lAlimentos;
	}
}
