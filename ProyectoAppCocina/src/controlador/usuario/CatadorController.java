package controlador.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionDB;
import modelo.usuario.Catador;

public class CatadorController implements ICatadorController{
	
	@Override
	public int add (Catador oCatador) {
		
		String sql = "INSERT INTO catador VALUES (";
		sql += "\"" + oCatador.getsEmail() + "\",";
		sql += "\"" + oCatador.getCriterio() + "\",";
		sql += "\"" + oCatador.getsContrasenia() + "\",";
		sql += "\"" + oCatador.getsNombre() + "\",";
		sql += "\"" + oCatador.getsApellidos() + "\",";
		sql += "\"" + oCatador.getsTelefono() + "\",";
		sql += "\"" + oCatador.getsExperiencia() + "\",";
		sql += "\"" + oCatador.getsCiudad() + "\",";
		sql += ")";
		
		return ConexionDB.executeUpdate(sql);
	}
	
	@Override
	public int remove (Catador oCatador) {
	String sql = "DELETE FROM catador WHERE email LIKE \""+oCatador.getsEmail()+"\"";
	return ConexionDB.executeUpdate(sql);
    }

	@Override
    public int existeCatador (Catador oCatador) {
	String sql = "SELECT COUNT(*) FROM catador WHERE email LIKE \"" + oCatador.getsEmail() + "\"";
	return ConexionDB.executeCount(sql);
    }
	
	@Override
	public int checkLogin(Catador oCatador) {
		String sql = "SELECT COUNT(*) FROM persona WHERE email LIKE \"" + oCatador.getsEmail() 
		+ "\" AND contraseña LIKE \"" + oCatador.getsContrasenia() + "\"";
		return ConexionDB.executeCount(sql);
	}
	
	
	@Override
	public List<Catador> searchCatadorPorEmail(Catador oCatador) {

		List<Catador> lCatadores = new ArrayList<Catador>();
		String sql = "SELECT * FROM catador WHERE email=" + oCatador.getsEmail();
		Statement stm = null;

		try {
			stm = ConexionDB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String sEmail = rs.getString(1);
				String sContrasenia = rs.getString(2);
				String sNombre = rs.getString(3);
				String sApellidos = rs.getString(4);
				String sTelefono = rs.getString(5);
				String sExperiencia = rs.getString(6);
				String sCiudad = rs.getString(7);
				byte bCriterio = rs.getByte(8);
				lCatadores.add(new Catador(sEmail, sContrasenia, sNombre, sApellidos, sTelefono, sExperiencia, sCiudad, bCriterio));
			}
			stm.close();
		} catch (SQLException e) {
			lCatadores = null;
		}
		return lCatadores;
	}
	
}
