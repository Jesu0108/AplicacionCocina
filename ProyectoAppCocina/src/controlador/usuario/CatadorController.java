package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Catador;

public class CatadorController implements ICatadorController{
	
	@Override
	public int add (Catador oCatador, PersonaController oPersona) {
		
		oPersona.add(oCatador.getsEmail(), oCatador.getsContrasenia(), oCatador.getsNombre(), oCatador.getsApellidos(),
				oCatador.getsTelefono(), oCatador.getsExperiencia(), oCatador.getsCiudad());
		
		String sql = "INSERT INTO catador VALUES (";
		sql += "\"" + oCatador.getsEmail() + "\",";
		sql += "\"" + oCatador.getCriterio()+ "\",";
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
}
