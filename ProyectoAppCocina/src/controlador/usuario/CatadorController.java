package controlador.usuario;

import controlador.ConexionDB;
import modelo.usuario.Catador;
import modelo.usuario.Persona;

public class CatadorController {
	
	public int add (Catador oCatador, PersonaController oPersona) {
		
		//oPersona.add(oPersona);
		
		String sql = "INSERT INTO catador VALUES (";
		sql += "\"" + oCatador.getsEmail() + "\",";
		sql += "\"" + oCatador.getCriterio()+ "\",";
		sql += ")";
		
		return ConexionDB.executeUpdate(sql);
	}
	
	public int remove (Catador oCatador) {
	String sql = "DELETE FROM catador WHERE email LIKE \""+oCatador.getsEmail()+"\"";
	return ConexionDB.executeUpdate(sql);
    }

    // ##########
    public int existeCatador (Catador oCatador) {
	String sql = "SELECT COUNT(*) FROM catador WHERE email LIKE \"" + oCatador.getsEmail() + "\"";
	return ConexionDB.executeCount(sql);
    }
}
