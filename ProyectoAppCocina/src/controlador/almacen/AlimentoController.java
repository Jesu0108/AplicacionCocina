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
		String sql = "INSERT INTO alimento VALUES ( '" + oAlimento.getsNombre_alimento() + "', "
				+ oAlimento.getbCantidad() + " );";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Alimento oAlimento) {
		String sql = "DELETE FROM alimento WHERE nombre_alimento LIKE '" + oAlimento.getsNombre_alimento() + "' ;";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeAlimento(Alimento oAlimento) {
		String sql = "SELECT COUNT(*) FROM Alimento WHERE nombre_alimento LIKE '" + oAlimento.getsNombre_alimento()
				+ "' ;";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Alimento searchAlimento(String sNombreAlimento) {

		Alimento lAlimento = null;
		String sql = "SELECT * FROM alimento WHERE nombre_alimento= '" + sNombreAlimento + "'";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_alimento = rs.getString(1);
				byte bCantidad = rs.getByte(2);
				lAlimento = new Alimento(sNombre_alimento, bCantidad);
			}
		} catch (SQLException e) {
			lAlimento = null;
		}
		return lAlimento;
	}

	@Override
	public int updateAlimento(Alimento oAlimento) {

		String sql = "UPDATE alimento SET nombre_alimento = '" + oAlimento.getsNombre_alimento() + "', cantidad = "
				+ oAlimento.getbCantidad() + " WHERE nombre_alimento= '" + oAlimento.getsNombre_alimento() + "' ;";

		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public List<Alimento> searchAlimentosPorNombre(Alimento oAlimento) {

		List<Alimento> lAlimentos = new ArrayList<Alimento>();
		String sql = "SELECT * FROM alimento WHERE nombre_alimento= '" + oAlimento.getsNombre_alimento() + "' ;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sNombre_alimento = rs.getString(1);
				byte bCantidad = rs.getByte(2);
				lAlimentos.add(new Alimento(sNombre_alimento, bCantidad));
			}
			stm.close();
		} catch (SQLException e) {
			lAlimentos = null;
		}
		return lAlimentos;
	}
}
