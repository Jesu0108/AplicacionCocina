package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.usuario.Empresa;

public class EmpresaController implements IEmpresaController {

	// Operaciones CRUD

	@Override
	public int add(Empresa oEmpresa) {
		String sql = "INSERT INTO empresa VALUES ( '" + oEmpresa.getsCif() + "', '" + oEmpresa.getsDomilio() + "', '"
				+ oEmpresa.getsNombre() + "', '" + oEmpresa.getsTelefono() + "', '" + oEmpresa.getsCiudad() + "', '"
				+ oEmpresa.getsEmail() + "', '" + oEmpresa.getsContrasenia() + "', '" + oEmpresa.getsApellidos()
				+ "', '" + oEmpresa.getsExperiencia() + "' );";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int remove(Empresa oEmpresa) {
		String sql = "DELETE FROM empresa WHERE cif LIKE \"" + oEmpresa.getsCif() + "\"";
		return ConexionDB.executeUpdate(sql);
	}

	@Override
	public int existeEmpresa(Empresa oEmpresa) {
		String sql = "SELECT COUNT(*) FROM empresa WHERE cif LIKE \"" + oEmpresa.getsCif() + "\"";
		return ConexionDB.executeCount(sql);
	}

	@Override
	public Empresa searchEmpresa(Empresa oEmpresa) {

		Empresa lEmpresa = null;
		String sql = "SELECT * FROM empresa WHERE cif=" + oEmpresa.getsCif();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sCif = rs.getString(1);
				String sDomicilio = rs.getString(2);
				String sCiudad = rs.getString(3);
				String sNombre = rs.getString(4);
				String sTelefono = rs.getString(5);
				String sEmail = rs.getString(6);
				String sContrasenia = rs.getString(7);
				String sApellidos = rs.getString(8);
				String sExperiencia = rs.getString(9);

				lEmpresa = new Empresa(sCif, sDomicilio, sCiudad, sNombre, sTelefono, sEmail, sContrasenia, sApellidos,
						sExperiencia);
			}
		} catch (SQLException e) {
			lEmpresa = null;
		}
		return lEmpresa;
	}

	// Operacion de b�squeda por la PK

	@Override
	public List<Empresa> buscarEmpresaPorCif(Empresa oEmpresa) {

		List<Empresa> lEmpresas = new ArrayList<Empresa>();
		String sql = "SELECT * FROM empresa;";
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sCif = rs.getString(1);
				String sDomicilio = rs.getString(2);
				String sCiudad = rs.getString(3);
				String sNombre = rs.getString(4);
				String sTelefono = rs.getString(5);
				String sEmail = rs.getString(6);
				String sContrasenia = rs.getString(7);
				String sApellidos = rs.getString(8);
				String sExperiencia = rs.getString(9);

				lEmpresas.add(new Empresa(sCif, sDomicilio, sCiudad, sNombre, sTelefono, sEmail, sContrasenia,
						sApellidos, sExperiencia));
			}
			stm.close();
		} catch (SQLException e) {
			lEmpresas = null;
		}
		return lEmpresas;
	}

}
